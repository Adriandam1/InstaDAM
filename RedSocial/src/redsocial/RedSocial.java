/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package redsocial;

import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class RedSocial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Operaciones operaciones = new Operaciones();
    
            boolean salir = false;
            while (!salir) {
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // scanner para borrar la linea despues del scanner int
        
                // switch dedicado a Antonio el ajedrecista
                switch (opcion) {
                    case 1:
                        operaciones.registrarUsuario();
                        break;
                    case 2:
                        operaciones.iniciarSesion();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtelo de nuevo.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}