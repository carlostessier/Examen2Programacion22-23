package com.hogwartslegacy.modelo;

public class Varita {
    private String material;
    private int longitud;
    private int poderMagico;

    public Varita() {
        this("", 0, 0);
    }

    public Varita(String material, int longitud, int poderMagico) {
        this.material = material;
        setLongitud(longitud);
        this.poderMagico = poderMagico;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getLongitud() {

        return longitud;
    }

    public void setLongitud(int longitud) {
        if(longitud < 20 || longitud > 40){
            return;
        }
        this.longitud = longitud;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Varita varita = (Varita) o;

        if (longitud != varita.longitud) return false;
        if (poderMagico != varita.poderMagico) return false;
        return material != null ? material.equals(varita.material) : varita.material == null;
    }


}
