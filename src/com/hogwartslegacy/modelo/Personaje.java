package com.hogwartslegacy.modelo;

public abstract class Personaje {

    private String nombre;
    private int vida;

    public Personaje() {
    }

    public Personaje(String nombre, int vida) {
        this.nombre = nombre.trim().toUpperCase();
        setVida(vida);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if(vida < 0 || vida > 100){
            return;
        }
        this.vida = vida;
    }

    @Override
    public String toString() {
        return  nombre + " (pv:" + vida+")";
    }
}
