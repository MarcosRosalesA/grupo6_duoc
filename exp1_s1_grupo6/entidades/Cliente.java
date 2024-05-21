/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_grupo6.entidades;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author M
 */
public class Cliente{
   static Scanner sc = new Scanner(System.in);
   private String rut;
   private String nombre;
   private String aPaterno;
   private String aMaterno;
   private String domicilio;
   private String comuna;
   private long telefono;
   private Cuenta cc = new Cuenta();
   
   public Cliente(){}

    public Cuenta getCc() {
        return cc;
    }


    public Cliente(String rut, String nombre, String aPaterno, String aMaterno, String domicilio, String comuna, long telefono, Cuenta cc) {
        this.rut = rut;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cc = cc;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }  
    
   public static void visCliente(ArrayList<Cliente> clientes){
     boolean buc=true;
    System.out.println("-------------------------");
    System.out.println("Visualización de cliente");
    System.out.println("-------------------------");
        while (buc==true){
            System.out.println("Ingrese su RUT (formato 12345678-9): ");
            String rut = sc.next();
            if (rut.matches("\\d{7,8}-[\\dKk]")) {
                Cliente v1rut = Cliente.busRut(clientes, rut);
                if (v1rut==null){
                   System.out.println("El RUT ingresado no está registrado.");
                   buc=false;
                }
                else{
                    System.out.println("nombre: "+v1rut.getNombre());
                    System.out.println("Apellidos: "+v1rut.getaPaterno()+" "+v1rut.getaMaterno());
                    System.out.println("Domicilio: "+v1rut.getDomicilio()+","+v1rut.getComuna());
                    System.out.println("Telefono: "+v1rut.getTelefono());
                    System.out.println("Cuenta corriente: "+v1rut.getCc().getNumc());
                    System.out.println("Saldo: "+v1rut.getCc().getSaldo());
                    buc=false;
                }
            } else {
                System.out.println("Formato de RUT incorrecto. Por favor intente nuevamente.");
                }
        }
    
       
    
    }
   
   public static Cliente busRut(ArrayList<Cliente> clientes, String brut){
   for(Cliente cliente: clientes){
        if(cliente.getRut().equals(brut)){
            return cliente;
        }
    }
    return null;
   }
public static void agregarCliente(ArrayList<Cliente> clientes){
    boolean buc=true;
    System.out.println("-------------------------");
    System.out.println("Agregar un nuevo Cliente");
    System.out.println("-------------------------");
        while (buc==true){
            System.out.println("Ingrese su RUT (formato 12345678-9): ");
            String rut = sc.next();
            if (rut.matches("\\d{7,8}-[\\dKk]")) {
                Cliente v1rut = Cliente.busRut(clientes, rut);
                if (v1rut==null){
                    System.out.println("Ingrese nombre: ");
                    String nom = sc.next();
                    System.out.println("Ingrese Apellido paterno:");
                    String ap = sc.next();
                    System.out.println("Ingrese Apellido materno: ");
                    String am =sc.next();
                    System.out.println("Ingrese domicilio: ");
                    String dom =sc.next();
                    System.out.println("Ingrese comuna: ");
                    String com =sc.next();
                    System.out.println("Ingrese telefono: ");
                    long tel =sc.nextLong();
                    Random random = new Random();
                    long numeroCuentaAleatorio = 100_000_000 + random.nextInt(900_000_000);
                    buc=false;
                    clientes.add(new Cliente(rut,nom,ap,am,dom,com,tel, new Cuenta(numeroCuentaAleatorio,0)));
                        System.out.println("-------------------------");
                        System.out.println("Se ha creado correctamente el nuevo cliente");
                        System.out.println("-------------------------");
                }
                else{
                    System.out.println("El RUT ingresado ya está registrado. No puede registrar el mismo RUT dos veces.");
                }
            } else {
                System.out.println("Formato de RUT incorrecto. Por favor intente nuevamente.");
                }
        }
    
        
        
}    
}
