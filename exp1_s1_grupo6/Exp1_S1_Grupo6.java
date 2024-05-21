/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp1_s1_grupo6;

import exp1_s1_grupo6.entidades.Cliente;
import exp1_s1_grupo6.entidades.Cuenta;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author M
 */
public class Exp1_S1_Grupo6 {
        static Scanner sc = new Scanner(System.in);
        static ArrayList<Cliente> clientes = new ArrayList<>();
       
    public static void main(String[] args) {
        boolean menu=true;
        try{
        do{
        System.out.println("-------------------------");
        System.out.println("BIENVENIDO A BANK BOSTON");
        System.out.println("-------------------------");
        System.out.println("1. Depósitos ");
        System.out.println("2. Giros ");
        System.out.println("3. Consultas de saldo");
        System.out.println("4. Registros de Clientes");
        System.out.println("5. Visualización de los datos personales");
        System.out.println("6. Salir");
        System.out.println("-------------------------");
        System.out.println("Elija la opción que desea hacer: ");
        int var = sc.nextInt();
        switch (var) {
            case 1:
                Cuenta.depositar(clientes);
                break;
            case 2:
               Cuenta.girar(clientes);
                break;
            case 3:
              Cuenta.cSaldo(clientes);
                break;
            case 4:
                Cliente.agregarCliente(clientes);
                break;
            case 5:
                Cliente.visCliente(clientes);
                break;         
            case 6:
                menu=false;
                break;
            default:
                System.out.println("Ingrese una opción valida");;
        }
        }while(menu==true);        
    } catch(Exception e){
            System.out.println("OH! ha ocurrido un problema, por favor intente nuevamente");
            
    }




}
}
