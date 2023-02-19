package com.hogwartslegacy;


import com.hogwartslegacy.modelo.*;

import static com.hogwartslegacy.modelo.Casa.*;
import static com.hogwartslegacy.modelo.Madera.*;
import static com.hogwartslegacy.modelo.Mago.*;
import static com.hogwartslegacy.modelo.Nucleo.*;
import static com.hogwartslegacy.modelo.Varita.*;

public class Main {


    public static void main(String[] args) {

        Varita varitaEbano = new Varita(ABETO, CORAZON_DRAGON, 20, 80);
        Mago harry = new Mago("Harry Potter", MAX_VIDA, GRYFFINDOR, MAX_MAGIA, varitaEbano);
        Varita varitaRoble = new Varita(TEJO,PLUMA_FENIX, 30, MAX_POW);
        Mago voldemort = new Mago("Voldemort", MAX_VIDA, SLYTHERIN, MAX_MAGIA, varitaRoble);

        Hechizo crucio = new Hechizo("Crucio", 5) {
            @Override
            public String efecto(Object objetivo) {
                if (objetivo instanceof Personaje) {
                    int damage = (int) (Math.random() * 100);
                    ((Personaje) objetivo).setVida(((Personaje) objetivo).getVida() - damage);
                    return "Daño " + damage + " a " + ((Personaje) objetivo).getNombre();
                }
                return "No se puede atacar a " + objetivo;
            }
        };

        harry.aprenderHechizo(crucio);
        voldemort.aprenderHechizo(crucio);

        while ((harry.getVida() > 0 && voldemort.getVida() > 0) ) {
            harry.lanzarHechizo(voldemort, "Crucio");
            System.out.println(voldemort);

            if (voldemort.getVida() == 0) {
                break;
            }
            voldemort.lanzarHechizo(harry, "Crucio");
            System.out.println(harry);
        }

        if (harry.getVida() == 0) {
            System.out.println("Harry has been defeated.");
        }
        else if (voldemort.getVida() == 0) {
            System.out.println("Voldemort has been defeated.");
        }



    }

}


