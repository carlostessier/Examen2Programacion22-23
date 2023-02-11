package com.hogwartslegacy.modelo;

public class Muggle extends Personaje{

        private String nombre;
        private double vida;

        public Muggle() {
            super("", 0);
        }

        public Muggle(String nombre, int vida) {
           super(nombre, vida);
        }

}
