package com.lslutnfra.ejemplospinner;

/**
 * Created by ernesto on 23/09/15.
 */
public class Persona {

    private String nombre;
    private String apellido;

    public Persona(String nombre,String apellido)
    {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getApellido()
    {
        return apellido;
    }
}