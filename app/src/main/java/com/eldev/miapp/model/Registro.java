package com.eldev.miapp.model;

public class Registro {
    private int id;
    private String fecha_hora;

    public int getId() {
        return id;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public String getFecha() {
        if (fecha_hora != null && fecha_hora.contains(" ")) {
            return fecha_hora.split(" ")[0];
        }
        return "";
    }

    public String getHora() {
        if (fecha_hora != null && fecha_hora.contains(" ")) {
            return fecha_hora.split(" ")[1];
        }
        return "";
    }
}
