package com.hogwartslegacy.modelo;

import java.util.Arrays;
import java.util.Locale;

public class Mago extends Personaje implements AccionesMago {

    public static int MAX_HECHIZOS = 10;
    public static int MAX_MAGIA= 30;

    private Casa casa;
    private int magia;
    private Varita varita;
    private Hechizo[] hechizos;

    public Mago(String nombre, int vida) {
        this(nombre,vida,Casa.SIN_CASA, 0, new Varita());
    }

    public Mago(Mago mago){
        this(mago.getNombre(), mago.getVida(), mago.getCasa(), mago.getMagia(), mago.getVarita());
        this.hechizos = new Hechizo[MAX_HECHIZOS];
        for (int i = 0; i < MAX_HECHIZOS; i++) {
            mago.getHechizos()[i] = new Hechizo();
        }
    }
    public Mago() {
        this("",0,Casa.SIN_CASA, 0, new Varita());
    }

    public Mago(String nombre, int vida, Casa casa, int magia, Varita varita) {
        super(nombre,vida) ;
        this.casa = casa;
        setMagia(magia);
        setVarita(varita);
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
                    System.out.println(hechizos[i].efecto(objetivo));
                    magia -= hechizos[i].getCosteMana();
                    lanzado = true;
                } else {
                    System.err.println("No tengo suficiente magia");
                }
            }
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
        boolean hechizoOlvidado;
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

        if(varita != null)
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
       if(magia < 0 ){
          this.magia = 0;
       }
       else this.magia = Math.min(magia, MAX_MAGIA);

    }


    public Hechizo[] getHechizos() {
        return hechizos;
    }

    @Override
    public String toString() {
        return getNombre() +
                " (pv:" +
                getVida() +
                ",pm:" +
                getMagia() +
                ") " +
                casa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mago mago = (Mago) o;

        if (magia != mago.magia) return false;
        if (casa != mago.casa) return false;
        if (varita != null ? !varita.equals(mago.varita) : mago.varita != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(hechizos, mago.hechizos);
    }

    @Override
    public int hashCode() {
        int result = casa != null ? casa.hashCode() : 0;
        result = 31 * result + magia;
        result = 31 * result + (varita != null ? varita.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(hechizos);
        return result;
    }
}
