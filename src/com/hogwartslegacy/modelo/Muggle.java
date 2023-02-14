package com.hogwartslegacy.modelo;

import java.util.Locale;

public class Muggle extends Personaje {

    private String profesion;

    public Muggle() {
        this("", 0, "");
    }

    public Muggle(Muggle muggle) {
        this(muggle.getNombre(), muggle.getVida(), muggle.getProfesion());
    }

    public Muggle(String nombre, int vida, String profesion) {
        super(nombre, vida);
        setProfesion(profesion);
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        if(profesion == null){
            return;
        }
        this.profesion = profesion.trim().toUpperCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return getNombre() +
                " (pv:" +
                getVida() +
                ") " +
                profesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Muggle muggle = (Muggle) o;

        return profesion != null ? profesion.equals(muggle.profesion) : muggle.profesion == null;
    }

    @Override
    public int hashCode() {
        return profesion != null ? profesion.hashCode() : 0;
    }
}
