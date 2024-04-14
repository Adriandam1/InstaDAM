/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redsocial;

/**
 *
 * @author Adrian
 */
public class Publicacion {
    private final String username;
    private final String mensaje;

    public Publicacion(String username, String mensaje) {
        this.username = username;
        this.mensaje = mensaje;
    }

    public String getUsername() {
        return username;
    }

    public String getMensaje() {
        return mensaje;
    }
}