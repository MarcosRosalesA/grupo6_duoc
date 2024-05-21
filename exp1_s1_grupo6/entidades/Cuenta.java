/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp1_s1_grupo6.entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author M
 */
public class Cuenta {
static Scanner sc = new Scanner(System.in);
    private long numc;
    private long saldo;

    public Cuenta(){
    }
    
    public Cuenta(long numc, long saldo) {
        this.numc = numc;
        this.saldo = saldo;
    }

    public long getNumc() {
        return numc;
    }

    public void setNumc(long numc) {
        this.numc = numc;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public static void depositar(ArrayList<Cliente> clientes){
    boolean buc=true;
    System.out.println("-------------------------");
    System.out.println("Depositos de cuenta");
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
                    System.out.println("Cuanto es el monto que desea depositar?: ");
                    long deposito = sc.nextLong();
                    
                    long salActual=v1rut.getCc().getSaldo();
                    long salNuevo=salActual+deposito;
                    v1rut.getCc().setSaldo(salNuevo);
                    
                    System.out.println("Se ha hecho el deposito con exito!");
                    System.out.println("Su saldo nuevo es: "+v1rut.getCc().getSaldo());
                    buc=false;
                    
                }
            } else {
                System.out.println("Formato de RUT incorrecto. Por favor intente nuevamente.");
                }
        }    
    }
    
    public static void girar(ArrayList<Cliente> clientes){
        boolean buc=true;
    System.out.println("-------------------------");
    System.out.println("Giros de cuenta");
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
                    System.out.println("Cuanto es el monto que desea girar?: ");
                    long giro = sc.nextLong();
                    long salActual=v1rut.getCc().getSaldo();
                    if (giro>salActual){
                        System.out.println("El saldo no es suficiente para girar");
                    }else{
                    long salNuevo=salActual-giro;
                    v1rut.getCc().setSaldo(salNuevo);
                    System.out.println("Se ha hecho el giro con exito!");
                    System.out.println("Su saldo nuevo es: "+v1rut.getCc().getSaldo());
                    buc=false;
                    }
                }
            } else {
                System.out.println("Formato de RUT incorrecto. Por favor intente nuevamente.");
                }
        }
    }
    public static void cSaldo(ArrayList<Cliente> clientes){
    boolean buc=true;
    System.out.println("-------------------------");
    System.out.println("Consulta de saldo");
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
                    System.out.println("El saldo de la cuenta es de: "+v1rut.getCc().getSaldo());
                    buc=false;
                    }
                }
            else {
                System.out.println("Formato de RUT incorrecto. Por favor intente nuevamente.");
                }
        }
    
    }
    
}
