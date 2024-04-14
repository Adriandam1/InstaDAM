package redsocial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operaciones {
    public List<Usuario> usuarios;
    public List<Publicacion> publicaciones;
    public Scanner scanner;
    public Usuario usuarioActual;

    public Operaciones() {
        usuarios = new ArrayList<>();
        publicaciones = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void registrarUsuario() {
        System.out.print("Ingrese un nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese una contraseña: ");
        String password = scanner.nextLine();

        // Verificar si el nombre de usuario ya existe
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                System.out.println("Nombre de usuario ya existe. Por favor, elija otro.");
                return;
            }
        }

        // Crear y agregar el nuevo usuario
        Usuario nuevoUsuario = new Usuario(username, password);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado con éxito.");
    }

    public void iniciarSesion() {
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        // Verificar las credenciales de inicio de sesión
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                usuarioActual = usuario;
                mostrarMenuUsuario();
                return;
            }
        }

        // Si las credenciales son incorrectas
        System.out.println("Nombre de usuario o contraseña incorrectos.");
    }

    private void mostrarMenuUsuario() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Publicar mensaje");
            System.out.println("2. Ver publicaciones");
            System.out.println("3. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea después del número

            switch (opcion) {
                case 1:
                    publicarMensaje();
                    break;
                case 2:
                    verPublicaciones();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }
    }

    private void publicarMensaje() {
        System.out.print("Ingrese su mensaje: ");
        String mensaje = scanner.nextLine();
        Publicacion publicacion = new Publicacion(usuarioActual.getUsername(), mensaje);
        publicaciones.add(publicacion);
        System.out.println("Mensaje publicado con éxito.");
    }

    private void verPublicaciones() {
        System.out.println("\nPublicaciones:");
        for (Publicacion publicacion : publicaciones) {
            System.out.println(publicacion.getUsername() + ": " + publicacion.getMensaje());
        }
    }
}
