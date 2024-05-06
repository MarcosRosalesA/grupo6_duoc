/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EFT_S9_MarcosRosales;

import java.util.ArrayList;
import java.util.Scanner;

public class EFT_S9_MarcosRosales {
    static int venta=0;
    static int cvip=0;
    static int cpalco=0;
    static int cplatea=0;
    static int cgaleria=0;
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        

        // Listas para almacenar la información de las ventas
        ArrayList<Integer> idVenta = new ArrayList<>();
        ArrayList<String> nombre = new ArrayList<>();
        ArrayList<String> ubicaciones = new ArrayList<>();
        ArrayList<Integer> preciosFinales = new ArrayList<>();
        ArrayList<Integer> descuentosAplicados = new ArrayList<>();
        ArrayList<String> eventotipo = new ArrayList<>();

        System.out.println("Bienvenido al Teatro Moro");

        boolean continuar = true;
       try{
        while (continuar) {
            
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Ver resumen de ventas");
            System.out.println("3. Promociones");
            System.out.println("4. Configurar ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    if (idVenta.isEmpty()){
                    venta=0;
                    }
                    comprarEntrada(scan, eventotipo, idVenta, nombre, ubicaciones, preciosFinales, descuentosAplicados);
                    break;
                case 2:
                    verResumenVentas (idVenta, eventotipo, nombre, ubicaciones, preciosFinales, descuentosAplicados);
                    break;
                case 3:
                    Promociones ();
                    break;
                case 4:
                    if (idVenta.isEmpty()){
                        System.out.println("Aún no se han hecho ventas el día de hoy.");
                    }
                    else {configVenta(idVenta, nombre, ubicaciones, preciosFinales, descuentosAplicados);
                    }
                    break;
                case 5:
                    continuar = false;
                    System.out.println("¡Gracias por visitar el Teatro Moro!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
            
        }
        } 
        catch(java.util.InputMismatchException e){
                System.out.println("Ha ocurrido un error pruebe nuevamente!");
                
            }

                
                
    }
    

    public static void comprarEntrada(Scanner scan,ArrayList<String> eventotipo, ArrayList<Integer> idVenta, ArrayList<String> nombre, ArrayList<String> ubicaciones, ArrayList<Integer> preciosFinales, ArrayList<Integer> descuentosAplicados) {
       // CODIGO COMPLETO DE LAS VENTAS DE ENTRADA
        try{ 
        System.out.println("\nIndique la entrada que desea comprar:");
        // CONSULTA DE DISPONIBILIDAD DE AREAS
        if (disponibilidaEn(Promociones.vip)==true){
            System.out.println("VIP:      $"+Promociones.precio[0]);
                         }
        if (disponibilidaEn(Promociones.palco)==true){
        System.out.println("PALCO:    $"+Promociones.precio[1]);
         }
        if (disponibilidaEn(Promociones.platea)==true){
        System.out.println("PLATEA:   $"+Promociones.precio[2]);
         }
         if (disponibilidaEn(Promociones.galeria)==true){
        System.out.println("GALERIA:  $"+Promociones.precio[3]);
         }
        String tipoDeEntrada = scan.next().toLowerCase();
        int precioBase;
        switch (tipoDeEntrada) {
            case "vip":
                Promociones.vip[cvip]=true;
                precioBase = Promociones.precio[0];
                cvip++;
                break;
            case "palco":
                Promociones.palco[cpalco]=true;
                precioBase = Promociones.precio[1];
                cpalco++;
                break;
            case "platea":
                Promociones.platea[cplatea]=true;
                precioBase = Promociones.precio[2];
                cplatea++;
                break;
            case "galeria":
                Promociones.galeria[cgaleria]=true;
                precioBase = Promociones.precio[3];
                cgaleria++;
                break;
            default:
                System.out.println("Tipo de entrada no válida.");
                return;
        }
       
        idVenta.add(venta+1);
        System.out.println("Por favor ingrese su nombre:" );
        String nom = scan.next();
        nombre.add(nom);
        System.out.println("Por favor ingrese su edad:");
        int edad = scan.nextInt();
        int descuento = 0;
        if (edad <= 18) {
            descuento = Promociones.descuentos[0];
        } else if (edad >= 65) {
            descuento = Promociones.descuentos[1];
        }

        double precioFinal = precioBase * (1 - (double) descuento / 100);
        ubicaciones.add(tipoDeEntrada);
        preciosFinales.add((int) precioFinal);
        descuentosAplicados.add(descuento);
        eventotipo.add(Promociones.evento);
        
        
       // BOLETA DE TODO LO COMPRADO Y SUS DETALLES
        System.out.println("------------------------------------");
        System.out.println("             Teatro Moro            ");
        System.out.println("------------------------------------");
        for (int i = 0; i < ubicaciones.size(); i++) {
            System.out.println("Tipo de Evento: " +eventotipo.get(i));
            System.out.println("IdVenta : "+idVenta.get(i));
            System.out.println("nombre: "+nombre.get(i));
            System.out.println("Asiento: " + ubicaciones.get(i).toUpperCase());
            System.out.println("Costo base: $" + obtenerCostoBase(ubicaciones.get(i)));
            System.out.println("Descuento aplicado: " + descuentosAplicados.get(i) + "%");
            System.out.println("Costo final: $" + preciosFinales.get(i) + "\n");
            System.out.println("------------------------------------");
            System.out.println("Gracias por su visita al Teatro Moro");
            System.out.println("------------------------------------");
        }
        venta++;
       }catch(Exception e){
       
           System.out.println("Ha ocurrido un error, por favor inicie de nuevo la compra.");
       
       }
    }
       
    
    
    public static int obtenerCostoBase(String ubicacion) {
    switch (ubicacion.toLowerCase()) {
        case "vip":
            return Promociones.precio[0];
        case "palco":
            return Promociones.precio[1];
        case "platea":
            return Promociones.precio[2];
        case "galeria":
            return Promociones.precio[3];
        default:
            return 0;
    }
    }
        public static void verResumenVentas (ArrayList<Integer> idVenta,ArrayList<String> eventotipo, ArrayList<String> nombre, ArrayList<String> ubicaciones, ArrayList<Integer> preciosFinales, ArrayList<Integer> descuentosAplicados) {
        if (ubicaciones.isEmpty()) {
            System.out.println("No se han realizado ventas aún.");
            return;
        }

        System.out.println("\n----- Resumen de Ventas -----");
        for (int i = 0; i < ubicaciones.size(); i++) {
            System.out.println("Tipo de Evento: " +eventotipo.get(i));
            System.out.println("Id Venta: "+idVenta.get(i));
            System.out.println("Nombre: "+nombre.get(i));
            System.out.println("Asiento: " + ubicaciones.get(i).toUpperCase());
            System.out.println("Precio final: $" + preciosFinales.get(i));
            System.out.println("Descuento aplicado: " + descuentosAplicados.get(i) + "%\n");
                        
        }        
    }

        
        
      private static void Promociones(){
                try{
                    //CONFIGURACION DE PROMOCIONES DESCUENTOS Y PRECIOS DE ENTRADA
                System.out.println("-------------------------------------");
                System.out.println("El valor de entradas de la zona VIP es de "+Promociones.precio[0]);
                System.out.println("El valor de entradas de la zona PALCO es de "+Promociones.precio[1]);
                System.out.println("El valor de entradas de la zona PLATEA es de "+Promociones.precio[2]);
                System.out.println("El valor de entradas de la zona GALERIA es de "+Promociones.precio[3]);
                System.out.println("-------------------------------------");
                System.out.println("------------ DESCUENTOS -------------");
                System.out.println("Adulto Mayor (Mayores de 60 años): "+Promociones.descuentos[0]);
                System.out.println("Estudiantes (Menores de 18 años): "+Promociones.descuentos[1]);
                
                System.out.println("Desea cambiar los precios o descuentos? (si/no)");
                String config = scan.next().toLowerCase(); 
                if (config.equals("si")) {
                      System.out.println("Cual desea cambiar?");
                      System.out.println("1. Precio de Entradas");
                      System.out.println("2. Descuentos");
                      int opcion = scan.nextInt();
                      switch (opcion){
                          case 1:
                                System.out.println("Ingrese nuevo valor para la zona VIP: ");
                                int newvip = scan.nextInt();
                                Promociones.precio[0]= newvip;
                                System.out.println("Ingrese nuevo valor para la zona PALCO: ");
                                int newpalco = scan.nextInt();
                                Promociones.precio[1]= newpalco ;
                                System.out.println("Ingrese nuevo valor para la zona PLATEA: ");
                                int newplatea = scan.nextInt();
                                 Promociones.precio[2] = newplatea;
                                System.out.println("Ingrese nuevo valor para la zona GALERIA: ");
                                int newgalera = scan.nextInt();
                                Promociones.precio[3] = newgalera;
                              break;
                          case 2:
                               System.out.println("Ingrese nuevo valor para los descuentos de adulto mayor: ");
                                int newadulto = scan.nextInt();
                                Promociones.descuentos[1]= newadulto;
                                System.out.println("Ingrese nuevo valor para los descuendos de Estudiante: ");
                                int newestudiante = scan.nextInt();
                                 Promociones.descuentos[0]= newestudiante;
                              break;
                          default: 
                                System.out.println("Elija una opción correcta");
                              break;
                      }
                }
                else if (config.equals("no")){
                    
                    System.out.println("Entendido hasta luego!");
                
                }
                else{
                    System.out.println("Escriba correctamente la respuesta");
                    
                }
                }catch (Exception e){
                    System.out.println("Ha ocurrido un error pruebe nuevamente.");
                }
                
                
}  
        class Promociones{
            //clase para tener los parametros juntos y limpios
        static String evento="Obra teatro";
        static int precio[] = {30000, 25000, 20000, 15000};
        static int descuentos[] = {10, 15};
        static boolean[] vip = new boolean[5];
        static boolean[] palco = new boolean[10];
        static boolean[] platea = new boolean[15];
        static boolean[] galeria = new boolean[20];
        } 
        

        public static void configVenta(ArrayList<Integer> idVenta, ArrayList<String> nombre, ArrayList<String> ubicaciones, ArrayList<Integer> preciosFinales, ArrayList<Integer> descuentosAplicados){
           //CONFIGURACION COMPLETA DE LAS VENTAS, DISPONIBILIDAD DE AREAS Y CAMBIO DE TIPO DE EVENTO
            try{
            System.out.println("CONFIGURACIÓN DE VENTAS");
            System.out.println("1. configurar información de venta");
            System.out.println("2. eliminar una venta");
            System.out.println("3. Disponibilizar areas");
            System.out.println("4. Cambiar tipo de evento");
            System.out.println("Que desea hacer, por favor elija una opción: ");
            int opconfig = scan.nextInt();
            switch(opconfig){
                case 1:
                    System.out.println("Por favor ingrese el id Venta que desea configurar: ");
                    int venconfig = scan.nextInt();
                    int id=idVenta.indexOf(venconfig);
                    System.out.println("!Resumen de la venta buscada!");
                    System.out.println("Id Venta: "+idVenta.get(id));
                    System.out.println("Nombre: "+nombre.get(id));
                    System.out.println("Asiento: " + ubicaciones.get(id).toUpperCase());
                    System.out.println("Precio final: $" + preciosFinales.get(id));
                    System.out.println("Descuento aplicado: " + descuentosAplicados.get(id) + "%\n");
                    
                    System.out.println("1. Nombre");
                    System.out.println("2. Asiento");
                    System.out.println("3. Descuento Aplicado");
                    System.out.println("Por favor seleccione cual desea cambiar: ");
                    int selec = scan.nextInt();
                    switch (selec){
                        case 1:
                            System.out.println("Ingrese el nuevo nombre: ");
                            String camnom = scan.next().toLowerCase();
                            nombre.set(id, camnom);
                            System.out.println("Se ha configurado el nombre "+nombre.get(id)+ "en  la venta " +idVenta.get(id));
                            break;
                        case 2:
                             System.out.println("Ingrese la nueva ubicación: ");
                             String camubi = scan.next().toLowerCase();
                             ubicaciones.set(id, camubi);
                             int nprecio = obtenerCostoBase(camubi);
                             int descuento = descuentosAplicados.get(id);
                             double nFprecio = nprecio * (1 - (double) descuento / 100); 
                             preciosFinales.set(id,(int) nFprecio);
                             System.out.println("Se ha cambiado la ubicación en la venta "+idVenta.get(id)+" el nuevo precio es: "+preciosFinales.get(id));
                            break;
                        case 3:
                            System.out.println("1. Descuento por adulto mayor");
                            System.out.println("2. Descuento para estudiantes");
                            System.out.println("Seleccione el descuento que quiere hacer: ");
                            int seledes = scan.nextInt();
                            switch (seledes){
                                case 1:
                                    int ndes = Promociones.descuentos[1];
                                    descuentosAplicados.set(id, ndes);
                                    int pre = obtenerCostoBase(ubicaciones.get(id));
                                    nFprecio =  pre * (1 - (double) ndes / 100); 
                                    preciosFinales.set(id,(int) nFprecio);
                                    System.out.println("Se ha cambiado el descuento en la venta "+idVenta.get(id)+" el nuevo precio es: "+preciosFinales.get(id));
                                    break;
                                case 2:
                                    ndes = Promociones.descuentos[0];
                                    descuentosAplicados.set(id, ndes);
                                    pre = obtenerCostoBase(ubicaciones.get(id));
                                    nFprecio =  pre * (1 - (double) ndes / 100); 
                                    preciosFinales.set(id,(int) nFprecio);
                                    System.out.println("Se ha cambiado el descuento en la venta "+idVenta.get(id)+" el nuevo precio es: "+preciosFinales.get(id));
                                    break;
                                default:
                                    System.out.println("Ingrese una opcion correcta");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Ingrese una opción correcta");
                            break;
                    }
                    
                    break;
                case 2:
                    System.out.println("Por favor ingrese el id Venta que desea eliminar:");
                    int ven = scan.nextInt();
                    int vendel = idVenta.indexOf(ven);
                    System.out.println("!Resumen de la venta buscada!");
                    System.out.println("Id Venta: "+idVenta.get(vendel));
                    System.out.println("Nombre: "+nombre.get(vendel));
                    System.out.println("Asiento: " + ubicaciones.get(vendel).toUpperCase());
                    System.out.println("Precio final: $" + preciosFinales.get(vendel));
                    System.out.println("Descuento aplicado: " + descuentosAplicados.get(vendel) + "%\n");
                    System.out.println("Estas seguro que deseas eliminar la venta ?");
                    String op = scan.next().toLowerCase();
                    if (op.equalsIgnoreCase("si")){
                        
                    idVenta.remove(vendel);
                    nombre.remove(vendel);
                    ubicaciones.remove(vendel);
                    preciosFinales.remove(vendel);
                    descuentosAplicados.remove(vendel);
                    
                        System.out.println("Se ha eliminado correctamente la venta!");
                    }
                    else if (op.equalsIgnoreCase("no")){
                        System.out.println("Entendido! no se ha eliminado la venta: "+idVenta.get(vendel));
                    }
                    else{
                        System.out.println("ingrese una opción correcta");
                    
                    }
                    break;
                case 3:
                    if (disponibilidaEn(Promociones.vip)==false){
                    System.out.println("1. VIP");
                    }
                    if (disponibilidaEn(Promociones.palco)==false){
                    System.out.println("2. PALCO");
                    }
                    if (disponibilidaEn(Promociones.platea)==false){
                    System.out.println("3. PLATEA");
                    }
                    if (disponibilidaEn(Promociones.galeria)==false){
                    System.out.println("4. GALERIA");
                    }
                    System.out.println("Seleccione que area desea disponibilizar: ");
                    int disop = scan.nextInt();
                    switch (disop){
                        case 1:
                            for (int i=0; i< Promociones.vip.length; i++){
                                Promociones.vip[i]=true;
                            }
                            break;
                        case 2:
                            for (int i=0; i< Promociones.palco.length; i++){
                                Promociones.palco[i]=true;
                            }
                            break;
                        case 3:
                            for (int i=0; i< Promociones.platea.length; i++){
                                Promociones.platea[i]=true;
                            }
                            break;
                        case 4:
                            for (int i=0; i< Promociones.galeria.length; i++){
                                Promociones.galeria[i]=true;
                            }
                            break;
                    }
                    break;
                case 4: 
                    System.out.println("Escriba que tipo de evento se hará: ");
                    String nevento = scan.nextLine().toLowerCase();
                    Promociones.evento=nevento;
                    System.out.println("El nuevo evento es: "+Promociones.evento);
                break;
                default:
                    System.out.println("Por favor ingrese una seleccion valida");
            }
            }catch (Exception e)
            {
                System.out.println("Ha ocurrido un error, Por favor vuelva a intentar");
            }
        }
        
        
        //METODO PARA SACAR LA DISPONIBILIDAD DE ENTRADAS POR AREA
    public static boolean disponibilidaEn(boolean[] ubi){
       boolean dis=false;
        
        for (boolean iubi : ubi){
            if(!iubi){
                dis=true;
                 break;
            }
        }
        return dis;     
        
    }
    }





    
