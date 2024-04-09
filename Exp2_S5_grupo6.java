/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2_s5_grupo6;

import java.util.Scanner;

public class Exp2_S5_grupo6 {
static Scanner scan = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    boolean menu = true;
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
                CompraEntrada();
            break;
            case 2:
                Promociones();
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
    
    
private static void Promociones(){

                System.out.println("-------------------------------------");
                System.out.println("El valor de entradas de la zona A es de "+entrada.A);
                System.out.println("El valor de entradas de la zona B es de "+entrada.B);
                System.out.println("El valor de entradas de la zona C es de "+entrada.C);
                System.out.println("-------------------------------------");
                System.out.println("------------ DESCUENTOS -------------");
                System.out.println("Adulto Mayor (Mayores de 60 años): "+entrada.adulMayor);
                System.out.println("Estudiantes (Menores de 18 años): "+entrada.estudian);
                System.out.println("Al comprar 3 o más entradas hay un descuento de: "+entrada.porMayor);
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
                                    if (edad < 18){
                                      precioEn = entrada.A - entrada.desEsA;
                                    }
                                    else if (edad >= 60){
                                       precioEn = entrada.A - entrada.desAduA;
                                    }
                                    else{
                                        precioEn = entrada.A;
                                    }
                                    // resumen de la compra de entrada zona A
                            int precioFin = precioEn - ((int)(entrada.A * desMayor)); 
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
                                    // resumen de la compra de entrada zona B
                            int precioFin = precioEn - ((int)(entrada.B * desMayor));
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
                                    // resumen de la compra de entrada zona C
                            int precioFin = precioEn - ((int)(entrada.C * desMayor));
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
                    }

            }

}
class entrada {                
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
