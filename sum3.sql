CREATE OR REPLACE PACKAGE PKG_LIQUIDACION IS
    v_prom_ventas NUMBER;
    
    -- Procedimiento para errores
    PROCEDURE SP_REG_ERROR(
        p_subprog IN VARCHAR2,     
        p_mensaje IN VARCHAR2,   
        p_desc IN VARCHAR2        
    );
    
    -- Función promedio ventas
    FUNCTION FN_PROM_VENTAS_ANT RETURN NUMBER;
END PKG_LIQUIDACION;
/

--Paquete
CREATE OR REPLACE PACKAGE BODY PKG_LIQUIDACION IS
    -- Procedimiento para registrar errores
    PROCEDURE SP_REG_ERROR(
        p_subprog IN VARCHAR2,
        p_mensaje IN VARCHAR2,
        p_desc IN VARCHAR2
    ) IS
    BEGIN
        -- Insertar error
        INSERT INTO ERROR_CALC (CORREL_ERROR,RUTINA_ERROR,DESCRIP_ERROR,DESCRIP_USER) 
        VALUES (SEQ_ERROR.NEXTVAL,p_subprog,p_mensaje, p_desc);
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            -- Error al registrar
            DBMS_OUTPUT.PUT_LINE('Error al registrar: ' || SQLERRM);
    END SP_REG_ERROR;

    -- Función promedio ventas
    FUNCTION FN_PROM_VENTAS_ANT RETURN NUMBER IS
        v_prom NUMBER;
        v_year NUMBER;
    BEGIN
        -- Año anterior
        v_year := EXTRACT(YEAR FROM SYSDATE) - 1;
        
        -- Calcular promedio
        SELECT NVL(AVG(MONTO_TOTAL_BOLETA), 0)
        INTO v_prom
        FROM BOLETA
        WHERE EXTRACT(YEAR FROM FECHA) = v_year;
        
        RETURN v_prom;
    EXCEPTION
        WHEN OTHERS THEN
            -- Registrar error y retornar 0
            SP_REG_ERROR('FN_PROM_VENTAS_ANT',SQLERRM,'Error promedio ventas ' || v_year);
            RETURN 0;
    END FN_PROM_VENTAS_ANT;
END PKG_LIQUIDACION;
/


-- Función porcentaje antigüedad
CREATE OR REPLACE FUNCTION FN_PORC_ANTIGUEDAD(
    p_sueldo IN NUMBER,
    p_id IN VARCHAR2
) RETURN NUMBER IS
    v_annos NUMBER(4,2);
    v_porcentaje NUMBER;
BEGIN
    -- Años de servicio
    SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, FECHA_CONTRATO)/12)
    INTO v_annos
    FROM EMPLEADO
    WHERE RUN_EMPLEADO = p_id;
    
    -- Obtener porcentaje
    SELECT PORC_ANTIGUEDAD
    INTO v_porcentaje
    FROM PCT_ANTIGUEDAD
    WHERE v_annos BETWEEN ANNOS_ANTIGUEDAD_INF AND ANNOS_ANTIGUEDAD_SUP;
    
    RETURN v_porcentaje;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- No se encontró porcentaje
        PKG_LIQUIDACION.SP_REG_ERROR( 'FN_PORC_ANTIGUEDAD','NO_DATA_FOUND','No porcentaje para ' || v_annos);
        RETURN 0;
    WHEN OTHERS THEN
        -- Otros errores
        PKG_LIQUIDACION.SP_REG_ERROR('FN_PORC_ANTIGUEDAD',SQLERRM,'Error porcentaje empleado: ' || p_id);
        RETURN 0;
END FN_PORC_ANTIGUEDAD;
/


-- Función porcentaje escolaridad
CREATE OR REPLACE FUNCTION FN_PORC_ESCOLARIDAD(
    p_id IN VARCHAR2 
) RETURN NUMBER IS
    v_porcentaje NUMBER;
BEGIN
    -- Obtener porcentaje escolaridad
    SELECT NVL(pne.PORC_ESCOLARIDAD, 0)
    INTO v_porcentaje
    FROM EMPLEADO e
    JOIN PCT_NIVEL_ESTUDIOS pne ON e.COD_ESCOLARIDAD = pne.COD_ESCOLARIDAD
    WHERE e.RUN_EMPLEADO = p_id
    AND e.COD_SALUD = 1; -- FONASA
    
    RETURN v_porcentaje;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        PKG_LIQUIDACION.SP_REG_ERROR('FN_PORC_ESCOLARIDAD','NO_DATA_FOUND','No nivel estudios: ' || p_id);
        RETURN 0;
    WHEN OTHERS THEN
        PKG_LIQUIDACION.SP_REG_ERROR('FN_PORC_ESCOLARIDAD',SQLERRM,'Error porcentaje escolaridad: ' || p_id);
        RETURN 0;
END FN_PORC_ESCOLARIDAD;
/


-- Procedimiento cálculo liquidaciones
CREATE OR REPLACE PROCEDURE SP_CALC_LIQUIDACION(
    p_mes IN NUMBER,
    p_anno IN NUMBER
) IS
    v_prom_ventas NUMBER;
    v_asig_especial NUMBER;
    v_asig_estudios NUMBER;
    v_total_haberes NUMBER;
    v_ventas_emp NUMBER;
BEGIN
    -- Promedio ventas anterior
    PKG_LIQUIDACION.v_prom_ventas := PKG_LIQUIDACION.FN_PROM_VENTAS_ANT();
    
    -- Procesar empleados
    FOR emp IN (SELECT * FROM EMPLEADO) LOOP
        -- Inicializar
        v_asig_especial := 0;
        v_asig_estudios := 0;
        
        -- Total ventas empleado
        SELECT NVL(SUM(b.MONTO_TOTAL_BOLETA), 0)
        INTO v_ventas_emp
        FROM BOLETA b
        WHERE b.RUN_EMPLEADO = emp.RUN_EMPLEADO
        AND EXTRACT(YEAR FROM b.FECHA) = p_anno;
        
        -- Asignación especial
        IF (v_ventas_emp * 0.07) > PKG_LIQUIDACION.v_prom_ventas THEN
            v_asig_especial := (emp.SUELDO_BASE * FN_PORC_ANTIGUEDAD(emp.SUELDO_BASE, emp.RUN_EMPLEADO)) / 100;
        END IF;
        
        -- Asignación estudios
        IF emp.COD_SALUD = 1 THEN
            v_asig_estudios := (emp.SUELDO_BASE * FN_PORC_ESCOLARIDAD(emp.RUN_EMPLEADO)) / 100;
        END IF;
        
        -- Total haberes
        v_total_haberes := emp.SUELDO_BASE + v_asig_especial + v_asig_estudios;
        
        -- Insertar liquidación
        INSERT INTO LIQUIDACION_EMPLEADO (
            MES,
            ANNO,
            RUN_EMPLEADO,
            NOMBRE_EMPLEADO,
            SUELDO_BASE,
            ASIG_ESPECIAL,
            ASIG_ESTUDIOS,
            TOTAL_HABERES
        ) VALUES (
            p_mes,
            p_anno,
            emp.RUN_EMPLEADO,
            emp.NOMBRE || ' ' || emp.paterno || ' ' || emp.materno,
            emp.SUELDO_BASE,
            v_asig_especial,
            v_asig_estudios,
            v_total_haberes
        );
    END LOOP;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        PKG_LIQUIDACION.SP_REG_ERROR('SP_CALC_LIQUIDACION',SQLERRM,'Error cálculo liquidaciones ' || p_mes || '/' || p_anno);
END SP_CALC_LIQUIDACION;
/

-- Trigger protección tabla PRODUCTO
CREATE OR REPLACE TRIGGER TRG_PROT_PRODUCTOS
BEFORE INSERT OR DELETE OR UPDATE OF VALOR_UNITARIO ON PRODUCTO
FOR EACH ROW
DECLARE
    v_dia VARCHAR2(15);
    v_prom_ventas NUMBER;
BEGIN
    -- Día actual
    SELECT TO_CHAR(SYSDATE, 'DY') INTO v_dia FROM DUAL;
    
    -- Validar inserciones y eliminaciones
    IF INSERTING OR DELETING THEN
        IF v_dia IN ('MON', 'TUE', 'WED', 'THU', 'FRI') THEN
            IF INSERTING THEN
                RAISE_APPLICATION_ERROR(-20501, 'TABLA PRODUCTO PROTEGIDA - No inserciones de lunes a viernes');
            ELSE
                RAISE_APPLICATION_ERROR(-20500, 'TABLA PRODUCTO PROTEGIDA - No eliminaciones de lunes a viernes');
            END IF;
        END IF;
    END IF;
    
    -- Validar actualizaciones
    IF UPDATING AND v_dia IN ('MON', 'TUE', 'WED', 'THU', 'FRI') THEN
        -- Promedio ventas
        v_prom_ventas := PKG_LIQUIDACION.FN_PROM_VENTAS_ANT();
        
        -- Si nuevo valor > 10%
        IF :NEW.VALOR_UNITARIO > (v_prom_ventas * 1.1) THEN
            -- Actualizar detalles boleta
            UPDATE DETALLE_BOLETA
            SET VALOR_TOTAL = CANTIDAD * :NEW.VALOR_UNITARIO
            WHERE COD_PRODUCTO = :OLD.COD_PRODUCTO;
        END IF;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        PKG_LIQUIDACION.SP_REG_ERROR(
            'TRG_PROT_PRODUCTOS',
            SQLERRM,
            'Error trigger protección productos'
        );
        RAISE;
END;
/
-- Ejecutar script
EXEC SP_CALC_LIQUIDACION(6, 2024);

-- Validamos los datos
SELECT * FROM LIQUIDACION_EMPLEADO;
SELECT * FROM ERROR_CALC;

-- DELETE PARA PRUEBAS
--DELETE FROM LIQUIDACION_EMPLEADO;
--DELETE FROM ERROR_CALC;
