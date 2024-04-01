/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2_s4_grupo6;

import java.util.Scanner;

/**
 *
 * @author M
 */
public class Exp2_S4_grupo6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    // TODO code application logic here
    
    Scanner scan = new Scanner(System.in); 
        boolean menu = true;
        int entradaA = 20000;
        int entradaB = 15000;
        int entradaC = 10000;
    while(menu == true){
        System.out.println("-------------------------------------");
        System.out.println("-------BIENVENIDO AL TEATRO----------");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("¿Que te gustaria hacer?");
        System.out.println("Por favor elige el numero de una de las siguientes opciones");
        System.out.println("1. Comprar entradas");
        System.out.println("2. Consultar valor de entradas y descuentos");
        System.out.println("3. Salir");
        System.out.print("tu seleccion es: ");
        int selemenu = scan.nextInt();
        switch (selemenu){
            case 1:
                //seleccion compra de entrada
            System.out.println("¿Cuantas entradas desea comprar? (por favor solo ingrese el numero)");
            int canten = scan.nextInt();
            
            //for para pasar por cada una de las entradas a comprar
            for (int forcanten = 0; forcanten < canten; forcanten++ ){
                String numentrada = "entrada "+(forcanten+1);
                System.out.println("--------------------------------------");
                System.out.println ("---- Estan disponibles las zonas ----");
                System.out.println ("---- A - Diamante -------------------");
                System.out.println ("---- B - VIP ------------------------");
                System.out.println ("---- C - ORO ------------------------");
                System.out.println("¿Que Zona desea elegir para la "+numentrada+"? (solo usar la letra de referencia A, B o C)");
                String zona = scan.next();
                
                //Seleccion de la zona A
                    if (zona.equalsIgnoreCase("A")){
                    System.out.println("-------------------------------------");
                    System.out.println("¿Que edad tiene la persona de la entrada numero "+(forcanten+1)+"?");
                    System.out.println("Solo ingrese el numero: ");
                        int edad = scan.nextInt();
                        int precioEn;
                        int descuento = 0;
                            if (edad < 18){
                               descuento = (int) (entradaA * 0.10);
                               precioEn = entradaA - descuento;
                            }
                            else if (edad > 60){
                               descuento = (int) (entradaA * 0.15);
                               precioEn = entradaA - descuento;
                            }
                            else{
                                precioEn = entradaA;
                            }
                            // resumen de la compra de entrada zona A
                    System.out.println("-------------------------------------");
                    System.out.println ("La "+numentrada+"  es la siguiente");
                    System.out.println ("Ubicacón del asiento: Zona "+zona);
                    System.out.println ("Precio base de la entrada: " + entradaA);
                    System.out.println ("Descuento aplicado: "+descuento);
                    System.out.println("-------------------------------------");
                    System.out.println ("Total a pagar: "+precioEn);
                    System.out.println("-------------------------------------");
                    }
                    
                    //Seleccion zona B
                    else if (zona.equalsIgnoreCase("B")){
                    System.out.println("-------------------------------------");    
                    System.out.println("¿Que edad tiene la persona de la entrada numero "+(forcanten+1)+"?");
                    System.out.println("Solo ingrese el numero: ");
                        int edad = scan.nextInt();
                        int precioEn;
                        int descuento = 0;
                            if (edad < 18){
                               descuento = (int) (entradaB * 0.10);
                               precioEn = entradaB - descuento;
                            }
                            else if (edad > 60){
                               descuento = (int) (entradaB * 0.15);
                               precioEn = entradaB - descuento;
                            }
                            else{
                                precioEn = entradaB;
                            }
                            // resumen de la compra de entrada zona B
                    System.out.println("-------------------------------------");
                    System.out.println ("La "+numentrada+"  es la siguiente");
                    System.out.println ("Ubicacón del asiento: Zona "+zona);
                    System.out.println ("Precio base de la entrada: " + entradaB);
                    System.out.println ("Descuento aplicado: "+descuento);
                    System.out.println("-------------------------------------");
                    System.out.println ("Total a pagar: "+precioEn);
                    System.out.println("-------------------------------------");
                    }
                    
                    //Seleccion de la zona C
                    else if (zona.equalsIgnoreCase("C")){
                    System.out.println("-------------------------------------");    
                    System.out.println("¿Que edad tiene la persona de la entrada numero "+(forcanten+1)+"?");
                    System.out.println("Solo ingrese el numero: ");
                        int edad = scan.nextInt();
                        int precioEn;
                        int descuento = 0;
                            if (edad < 18){
                               descuento = (int) (entradaC * 0.10);
                               precioEn = entradaC - descuento;
                            }
                            else if (edad > 60){
                               descuento = (int) (entradaC * 0.15);
                               precioEn = entradaC - descuento;
                            }
                            else{
                                precioEn = entradaC;
                            }
                            // resumen de la compra de entrada zona C
                    System.out.println("-------------------------------------");
                    System.out.println ("La "+numentrada+"  es la siguiente");
                    System.out.println ("Ubicacón del asiento: Zona "+zona);
                    System.out.println ("Precio base de la entrada: " + entradaC);
                    System.out.println ("Descuento aplicado: "+descuento);
                    System.out.println("-------------------------------------");
                    System.out.println ("Total a pagar: "+precioEn);
                    System.out.println("-------------------------------------");
                    }

            }
            break;
            
            // seleccion 2 para poder salir del programa
            case 2:
                System.out.println("-------------------------------------");
                System.out.println("El valor de entradas de la zona A es de "+entradaA);
                System.out.println("El valor de entradas de la zona B es de "+entradaB);
                System.out.println("El valor de entradas de la zona C es de "+entradaC);
                System.out.println("-------------------------------------");
                System.out.println("------------ DESCUENTOS -------------");
                System.out.println("Adulto Mayor (Mayores de 60 años): 15%");
                System.out.println("Estudaintes (Menores de 18 años): 10%");
                break;
                
            case 3:                                       
                menu = false;
                break;
            
            // En caso de no seleccionar un numero del menu
            default:
            System.out.println("-------------------------------------");
            System.out.println("Por favor seleccione un numero del menu");
            System.out.println("-------------------------------------");
            }
    }
    //Final y despedida del programa
    System.out.println("-------------------------------------");
    System.out.println ("Muchas gracias por visitar el teatro");
    System.out.println("-------------------------------------");
    }
}
    

