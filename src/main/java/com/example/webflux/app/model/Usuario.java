package com.example.webflux.app.model;

public class Usuario {
    private String Nombre;
    private String Apellido;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Usuario(String nombre, String apellido) {
        Nombre = nombre;
        Apellido = apellido;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                '}';
    }
}
