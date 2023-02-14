package com.hogwartslegacy.modelo;

public abstract class Personaje {

    public static final int MAX_VIDA = 100;
    private String nombre;
    private int vida;

    public Personaje() {
    }

    public Personaje(String nombre, int vida) {
        setNombre(nombre);
        setVida(vida);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null ){
            return;
        }
        this.nombre = nombre.trim().toUpperCase();
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if( vida > MAX_VIDA){
            this.vida = MAX_VIDA;
        }
        else this.vida = Math.max(vida, 0);
    }

    @Override
    public String toString() {
        return  nombre + " (pv:" + vida+")";
    }
}
