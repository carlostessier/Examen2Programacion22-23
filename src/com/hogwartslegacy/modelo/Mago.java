package com.hogwartslegacy.modelo;

import java.util.Locale;

public class Mago extends Personaje implements AccionesMago {

    public static int MAX_HECHIZOS = 10;


    public static enum Casa {
        GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN, SIN_CASA
    }

    private Casa casa;
    private int magia;
    private Varita varita;
    private Hechizo[] hechizos;

    public Mago(String nombre, int vida) {
        this(nombre,vida,Casa.SIN_CASA, 0, new Varita());
    }

    public Mago() {
        this("mago",100,Casa.SIN_CASA, 0, new Varita());
    }

    public Mago(String nombre, int vida, Casa casa, int magia, Varita varita) {
        super(nombre,vida) ;
        this.casa = casa;
        setMagia(magia);
        this.varita = varita;
        this.hechizos = new Hechizo[MAX_HECHIZOS];
        for (int i = 0; i < MAX_HECHIZOS; i++) {
            hechizos[i] = new Hechizo();
        }
    }

    @Override
    public boolean lanzarHechizo(Object objetivo, String hechizo) {
        boolean lanzado = false;

        if(varita.equals(new Varita())){
            System.err.println( "No tengo varita");
            return false;
        }

        int indice = buscarHechizo(hechizo.trim().toUpperCase(Locale.ROOT));

        if(indice == -1){
            System.err.println("No conozco ese hechizo");
            return false;
        }

        for (int i = 0; i < MAX_HECHIZOS; i++) {
            if (hechizos[i].getNombre().equals(hechizo.trim().toUpperCase(Locale.ROOT))) {
                if (hechizos[i].getCosteMana() <= magia) {
                    System.out.println(hechizos[i].lanzarHechizo(objetivo));
                    magia -= hechizos[i].getCosteMana();
                    lanzado = true;
                } else {
                    System.err.println("No tengo suficiente magia");
                }
            }
        }
       if(!lanzado){
           System.err.println("No conozco ese hechizo");
       }

       return lanzado;
    }

    @Override
    public boolean aprenderHechizo(Hechizo hechizo) {
        boolean hechizoAprendido = false;
        if(buscarHechizo(hechizo.getNombre()) != -1){
            System.err.println("Ya conozco ese hechizo");
            return false;
        }

        // buscar hueco
        int indice = buscarHechizo("");

        if(indice == -1){
            System.err.println("No tengo hueco para aprender más hechizos");
        }
        else {
            hechizos[indice] = hechizo;
            hechizoAprendido = true;
        }

        return hechizoAprendido;
    }

    @Override
    public boolean olvidarHechizo(Hechizo hechizo) {
        boolean hechizoOlvidado = false;
        int indice = buscarHechizo(hechizo.getNombre());
        if(indice == -1){
            System.err.println("No conozco ese hechizo");
            return false;
        }
        else {
            hechizos[indice] = new Hechizo();
            hechizoOlvidado = true;
        }
        return hechizoOlvidado;
    }

    public Varita getVarita() {
        return varita;
    }

    public void setVarita(Varita varita) {
        this.varita = varita;
    }

    private int buscarHechizo(String hechizo) {
        int posicion = -1;
        boolean encontrado = false;
        for (int i = 0; !encontrado && i < hechizos.length; i++) {
            if (hechizos[i].getNombre().equals(hechizo)){
                posicion = i;
                encontrado = true;
            }
        }
        return posicion;
    }


    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
       if(magia < 0 || magia > 100){
          return;
       }

       this.magia = magia;

    }


    public Hechizo[] getHechizos() {
        return hechizos;
    }

    @Override
    public String toString() {
        return  getNombre() + " (pv:" + getVida()+",pm:"+magia+") "+casa;
    }
}
