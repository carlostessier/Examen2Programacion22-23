package com.hogwartslegacy.modelo;

import java.util.Locale;

public class Hechizo {
    private String nombre;
    private int costeMana;



    public Hechizo() {
        this("", 0);
    }

    public Hechizo(Hechizo hechizo){
        this(hechizo.getNombre(), hechizo.getCosteMana());
    }

    public Hechizo(String nombre, int costeMana) {
       setNombre(nombre);
        this.costeMana = costeMana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim().toUpperCase(Locale.ROOT);
    }

    public int getCosteMana() {
        return costeMana;
    }

    public void setCosteMana(int costeMana) {
        this.costeMana = costeMana;
    }

    public String lanzarHechizo(Object objetivo){
        return "Lanzando hechizo " + this.nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hechizo hechizo = (Hechizo) o;

        return nombre != null ? nombre.equals(hechizo.nombre) : hechizo.nombre == null;
    }


}
