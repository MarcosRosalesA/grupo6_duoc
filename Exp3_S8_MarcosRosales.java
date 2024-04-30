/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exp3_S8_MarcosRosales;

import java.util.ArrayList;
import java.util.Scanner;

public class Exp3_S8_MarcosRosales {
    static int venta=0;
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        

        // Listas para almacenar la información de las ventas
        ArrayList<Integer> idVenta = new ArrayList<>();
        ArrayList<String> nombre = new ArrayList<>();
        ArrayList<String> ubicaciones = new ArrayList<>();
        ArrayList<Integer> preciosFinales = new ArrayList<>();
        ArrayList<Integer> descuentosAplicados = new ArrayList<>();

        System.out.println("Bienvenido al Teatro Moro");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Ver resumen de ventas");
            System.out.println("3. Promociones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    comprarEntrada(scan, idVenta, nombre, ubicaciones, preciosFinales, descuentosAplicados);
                    break;
                case 2:
                    verResumenVentas (idVenta, nombre, ubicaciones, preciosFinales, descuentosAplicados);
                    break;
                case 3:
                    Promociones ();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("¡Gracias por visitar el Teatro Moro!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void comprarEntrada(Scanner scan, ArrayList<Integer> idVenta, ArrayList<String> nombre, ArrayList<String> ubicaciones, ArrayList<Integer> preciosFinales, ArrayList<Integer> descuentosAplicados) {
        
        System.out.println("\nIndique la entrada que desea comprar:");
        System.out.println("VIP:      $"+Promociones.precio[0] );
        System.out.println("PALCO:    $"+Promociones.precio[1]);
        System.out.println("PLATEA:   $"+Promociones.precio[2]);
        System.out.println("GALERIA:  $"+Promociones.precio[3]);
        String tipoDeEntrada = scan.next().toLowerCase();
        int precioBase = 0;
        switch (tipoDeEntrada) {
            case "vip":
                precioBase = Promociones.precio[0];
                break;
            case "palco":
                precioBase = Promociones.precio[1];
                break;
            case "platea":
                precioBase = Promociones.precio[2];
                break;
            case "galeria":
                precioBase = Promociones.precio[3];
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
       
        System.out.println("------------------------------------");
        System.out.println("             Teatro Moro            ");
        System.out.println("------------------------------------");
        for (int i = 0; i < ubicaciones.size(); i++) {
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
        public static void verResumenVentas (ArrayList<Integer> idVenta, ArrayList<String> nombre, ArrayList<String> ubicaciones, ArrayList<Integer> preciosFinales, ArrayList<Integer> descuentosAplicados) {
        if (ubicaciones.isEmpty()) {
            System.out.println("No se han realizado ventas aún.");
            return;
        }

        System.out.println("\n----- Resumen de Ventas -----");
        for (int i = 0; i < ubicaciones.size(); i++) {
            System.out.println("Id Venta: "+idVenta.get(i));
            System.out.println("Nombre: "+nombre.get(i));
            System.out.println("Asiento: " + ubicaciones.get(i).toUpperCase());
            System.out.println("Precio final: $" + preciosFinales.get(i));
            System.out.println("Descuento aplicado: " + descuentosAplicados.get(i) + "%\n");
                        
        }        
    }

        
        
      private static void Promociones(){
                
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
                
                
}  
        class Promociones{
        static int precio[] = {30000, 25000, 20000, 15000};
        static int descuentos[] = {10, 15};
        } 
}


    
