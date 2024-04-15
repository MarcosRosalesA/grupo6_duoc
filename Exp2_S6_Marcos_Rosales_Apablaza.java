/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2_s6_Marcos_Rosales_Apablaza;

import java.util.Scanner;

public class Exp2_S6_Marcos_Rosales_Apablaza {
static Scanner scan = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    boolean menu = true;
    entrada.zonaA = true;
    entrada.zonaB = true;
    entrada.zonaC = true;
    while(menu == true){
        System.out.println("-------------------------------------");
        System.out.println("-------BIENVENIDO AL TEATRO----------");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("¿Que te gustaria hacer?");
        System.out.println("Por favor elige la letra de una de las siguientes opciones");
        System.out.println("A. Comprar entradas");
        System.out.println("B. Consultar valor de entradas y descuentos");
        System.out.println("C. Configurar la disponibilidad de asientos");
        System.out.println("D. Salir");
        System.out.print("tu seleccion es: ");
        String selemenu = scan.next().toUpperCase();
        switch (selemenu){
            case "A":
                CompraEntrada();
            break;
            case "B":
                Promociones();
            break; 
            case "C":
                DisponibilidadEntradas();
            break;
            case "D":                                       
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
    
    
private static void Promociones(){

                System.out.println("-------------------------------------");
                System.out.println("El valor de entradas de la zona Diamante es de "+entrada.A);
                System.out.println("El valor de entradas de la zona VIP es de "+entrada.B);
                System.out.println("El valor de entradas de la zona ORO es de "+entrada.C);
                System.out.println("-------------------------------------");
                System.out.println("------------ DESCUENTOS -------------");
                System.out.println("Adulto Mayor (Mayores de 60 años): "+entrada.adulMayor);
                System.out.println("Estudiantes (Menores de 18 años): "+entrada.estudian);
                System.out.println("Al comprar 3 o más entradas hay un descuento de: "+entrada.porMayor);
}
    



private static void DisponibilidadEntradas(){
    // validación de disponibilidad y configuración
    boolean dispMenu = true;
    while (dispMenu != false ){
    System.out.println("-------------------------------------------------------");
    System.out.println("Configuración de la disponibilidad de zonas de asientos");
    System.out.println("-------------------------------------------------------");
    System.out.println("Las zonas son las siguientes: ");
    System.out.println ("---- A - Diamante -------------------");
    System.out.println ("---- B - VIP --------------------------");
    System.out.println ("---- C - ORO --------------------------");
    System.out.println ("---- D - Menu principal ------------------------");
    System.out.println("-------------------------------------------------------");
    System.out.println("Elige la zona que deseas configurar: (solo usar la letra de referencia A, B, C o D) ");
    String zonaconfig = scan.next().toUpperCase();
    switch(zonaconfig){   
        case "A":
            System.out.println("la zona Diamante se encuentra en: "+entrada.dispoA);
            System.out.println("la Zona Diamante se encuentrará disponible? (si/no)");
            String camZonaA = scan.next().toLowerCase();
            if(camZonaA.equalsIgnoreCase("si")) {
                entrada.zonaA = true;
                entrada.dispoA = "Disponible";
            }
            else if (camZonaA.equalsIgnoreCase("no")){
                entrada.zonaA = false;
                entrada.dispoA = "NO Disponible";
            }
            else {
                System.out.println("Por favor ingresa si o no");
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("la zona Diamante AHORA se encuentra en: "+entrada.dispoA);
            System.out.println("-------------------------------------------------------");
            break;
        case "B":
            System.out.println("la zona VIP se encuentra en: "+entrada.dispoB);
            System.out.println("la Zona VIP se encuentrará disponible? (si/no)");
            String camZonaB = scan.next().toLowerCase();
            if(camZonaB.equalsIgnoreCase("si")) {
                entrada.zonaB = true;
                entrada.dispoB = "Disponible";
            }
            else if (camZonaB.equalsIgnoreCase("no")){
                entrada.zonaB = false;
                entrada.dispoB = "NO Disponible";
            }
            else {
                System.out.println("Por favor ingresa si o no");
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("la zona VIP AHORA se encuentra en: "+entrada.dispoB);
            System.out.println("-------------------------------------------------------");
            break;
        case "C":
            System.out.println("la zona ORO se encuentra en: "+entrada.dispoC);
            System.out.println("la Zona ORO se encuentrará disponible? (si/no)");
            String camZonaC = scan.next().toLowerCase();
            if(camZonaC.equalsIgnoreCase("si")) {
                entrada.zonaC = true;
                entrada.dispoC = "Disponible";
            }
            else if (camZonaC.equalsIgnoreCase("no")){
                entrada.zonaC = false;
                entrada.dispoC = "NO Disponible";
            }
            else {
                System.out.println("Por favor ingresa si o no");
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("la zona ORO AHORA se encuentra en: "+entrada.dispoC);
            System.out.println("-------------------------------------------------------");
            break;
        case "D":
            dispMenu = false;
            break;
        default:
            System.out.println("-------------------------------------------------------");
            System.out.println("Por favor ingrese una de las opciones establecidas");
            System.out.println("-------------------------------------------------------");
            break;
            
        }
    }
    
    

}
private static void CompraEntrada(){
        //seleccion compra de entrada
            double desMayor;
            System.out.println("¿Cuantas entradas desea comprar? (por favor solo ingrese el numero)");
            int canten = scan.nextInt();
            if (canten >= 3){
                desMayor = 0.10;
            }
            else {
                desMayor = 0.0;
            }
            //for para pasar por cada una de las entradas a comprar
            for (int forcanten = 0; forcanten < canten; forcanten++ ){
                        String numentrada = "entrada "+(forcanten+1);
                        System.out.println("--------------------------------------");
                        System.out.println ("---- Estan disponibles las zonas ----");
                        System.out.println("--------------------------------------");
                            // validación de disponibilidad
                        if (entrada.zonaA != false){
                            System.out.println ("---- A - Diamante -------------------");
                            System.out.println("--------------------------------------");
                        }
                        if (entrada.zonaB != false ){
                            System.out.println ("---- B - VIP ------------------------");
                            System.out.println("--------------------------------------");
                        }
                        if (entrada.zonaC != false){
                            System.out.println ("---- C - ORO ------------------------");
                            System.out.println("--------------------------------------");
                        }
                        else{
                            System.out.println ("---- NO hay zonas disponibles ----");
                            System.out.println("--------------------------------------");
                            break;
                        }                        
                       
                        
                        System.out.println("¿Que Zona de asientos desea elegir para la "+numentrada+"? (solo usar la letra de referencia A, B o C)");
                        String zona = scan.next();

                        //Seleccion de la zona A
                            if (zona.equalsIgnoreCase("A")){
                            System.out.println("-------------------------------------");
                            System.out.println("¿Que edad tiene la persona de la entrada numero "+(forcanten+1)+"?");
                            System.out.println("Solo ingrese el numero: ");
                                int edad = scan.nextInt();
                                int precioEn;
                                    if (edad < 18){
                                      precioEn = entrada.A - entrada.desEsA;
                                    }
                                    else if (edad >= 60){
                                       precioEn = entrada.A - entrada.desAduA;
                                    }
                                    else{
                                        precioEn = entrada.A;
                                    }
                                    // BOLETA
                            int precioFin = precioEn - ((int)(entrada.A * desMayor)); 
                            System.out.println("-------------------------------------");
                            System.out.println("------- ----- BOLETA ---- -----------");
                            System.out.println("-------------------------------------");
                            System.out.println ("La "+numentrada+"  es la siguiente");
                            System.out.println ("Ubicacón del asiento: Zona "+zona);
                            System.out.println ("Precio base de la entrada: " + entrada.A);
                            System.out.println ("Descuento por entrada: "+(precioEn - entrada.A));
                            System.out.println ("Descuento por venta x Mayor "+ ((int) entrada.A * -desMayor));
                            System.out.println("-------------------------------------");
                            System.out.println ("Total a pagar: "+precioFin);
                            System.out.println("-------------------------------------");
                            }

                            //Seleccion zona B
                            else if (zona.equalsIgnoreCase("B")){
                            System.out.println("-------------------------------------");    
                            System.out.println("¿Que edad tiene la persona de la entrada numero "+(forcanten+1)+"?");
                            System.out.println("Solo ingrese el numero: ");
                                int edad = scan.nextInt();
                                int precioEn;
                                    if (edad < 18) {
                                       precioEn = entrada.B - entrada.desEsB;
                                    }
                                    else if (edad > 60){
                                       precioEn = entrada.B - entrada.desAduB;
                                    }
                                    else{
                                        precioEn = entrada.B;
                                    }
                                     // BOLETA
                            int precioFin = precioEn - ((int)(entrada.B * desMayor));
                            System.out.println("-------------------------------------");
                            System.out.println("------- ----- BOLETA ---- -----------");
                            System.out.println("-------------------------------------");
                            System.out.println ("La "+numentrada+"  es la siguiente");
                            System.out.println ("Ubicacón del asiento: Zona "+zona);
                            System.out.println ("Precio base de la entrada: " + entrada.B);
                            System.out.println ("Descuento aplicado: "+(precioEn - entrada.B));
                            System.out.println ("Descuento por venta x Mayor "+ ((int) entrada.B * -desMayor));
                            System.out.println("-------------------------------------");
                            System.out.println ("Total a pagar: "+precioFin);
                            System.out.println("-------------------------------------");
                            }

                            //Seleccion de la zona C
                            else if (zona.equalsIgnoreCase("C")){
                            System.out.println("-------------------------------------");    
                            System.out.println("¿Que edad tiene la persona de la entrada numero "+(forcanten+1)+"?");
                            System.out.println("Solo ingrese el numero: ");
                                int edad = scan.nextInt();
                                int precioEn;
                                    if (edad < 18){
                                       precioEn = entrada.C - entrada.desEsC;
                                    }
                                    else if (edad > 60){
                                       precioEn = entrada.C - entrada.desAduC;
                                    }
                                    else{
                                        precioEn = entrada.C;
                                    }
                                      // BOLETA
                            int precioFin = precioEn - ((int)(entrada.C * desMayor));
                            System.out.println("-------------------------------------");
                            System.out.println("------- ----- BOLETA ---- -----------");
                            System.out.println("-------------------------------------");
                            System.out.println ("La "+numentrada+"  es la siguiente");
                            System.out.println ("Ubicacón del asiento: Zona "+zona);
                            System.out.println ("Precio base de la entrada: " + entrada.C);
                            System.out.println ("Descuento aplicado: "+(precioEn - entrada.C));
                            System.out.println ("Descuento por venta x Mayor "+ ((int) entrada.C * -desMayor));
                            System.out.println("-------------------------------------");
                            System.out.println ("Total a pagar: "+precioFin);
                            System.out.println("-------------------------------------");
                            }
                            else {
                            System.out.println("-------------------------------------");
                            System.out.println("POR FAVOR INGRESE UNA ZONA DISPONIBLE");
                            System.out.println("-------------------------------------");
                            break;
                            }
                    }

            }

}
class entrada {                
    static boolean zonaA;
    static String dispoA = "Disponible";
    static String dispoB = "Disponible";
    static String dispoC = "Disponible";
    static boolean zonaB;
    static boolean zonaC;
    static double adulMayor = 0.15;
    static double estudian = 0.10;
    static double porMayor = 0.10;
    static int A = 20000;
    static int B = 15000;
    static int C = 10000;
    static int desEsA = (int) (entrada.A * entrada.adulMayor);
    static int desAduA = (int) (entrada.A * entrada.estudian);
    static int desEsB = (int) (entrada.B * entrada.porMayor);
    static int desAduB = (int) (entrada.B * entrada.adulMayor);
    static int desEsC = (int) (entrada.C * entrada.estudian);
    static int desAduC = (int) (entrada.C * entrada.adulMayor);
}
