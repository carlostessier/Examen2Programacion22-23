package com.hogwartslegacy.modelo;

public class Varita {


    public static final int MIN_LONG = 20;
    public static final int MAX_LONG = 40;
    public static final int MAX_POW = 20;

    private Madera madera;
    private Nucleo nucleo;
    private int longitud;
    private int poderMagico;

    public Varita() {
        this(Madera.TEJO,Nucleo.CORAZON_DRAGON, MIN_LONG, 0);
    }

    public Varita(Madera madera,Nucleo nucleo, int longitud, int poderMagico) {
        this.madera = madera;
        this.nucleo = nucleo;
        setLongitud(longitud);
        setPoderMagico(poderMagico);
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo){
        this.nucleo = nucleo;
    }

    public Madera getMadera() {
        return madera;
    }

    public void setMadera(Madera madera) {
        this.madera = madera;
    }

    public int getLongitud() {

        return longitud;
    }

    public void setLongitud(int longitud) {
        if(longitud < MIN_LONG){
            this.longitud = MIN_LONG;
        }
        else this.longitud = Math.min(longitud, MAX_LONG);

    }

    public int getPoderMagico() {

        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {

        if(poderMagico < 0){
            this.poderMagico = 0;
        }
        else this.poderMagico = Math.min(poderMagico, MAX_POW);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Varita varita = (Varita) o;

        if (longitud != varita.longitud) return false;
        if (poderMagico != varita.poderMagico) return false;
        if (madera != varita.madera) return false;
        return nucleo == varita.nucleo;
    }

    @Override
    public int hashCode() {
        int result = madera != null ? madera.hashCode() : 0;
        result = 31 * result + (nucleo != null ? nucleo.hashCode() : 0);
        result = 31 * result + longitud;
        result = 31 * result + poderMagico;
        return result;
    }
}
