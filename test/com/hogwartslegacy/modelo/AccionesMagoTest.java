package com.hogwartslegacy.modelo;


import org.junit.jupiter.api.Test;

import static com.hogwartslegacy.modelo.Hechizo.*;
import static com.hogwartslegacy.modelo.Madera.*;
import static com.hogwartslegacy.modelo.Casa.*;
import static com.hogwartslegacy.modelo.Mago.*;
import static com.hogwartslegacy.modelo.Nucleo.*;
import static com.hogwartslegacy.modelo.Varita.*;
import static org.junit.jupiter.api.Assertions.*;

class AccionesMagoTest {

    @Test
    void lanzarHechizo() {
        Varita varitaEbano = new Varita(ABETO,CORAZON_DRAGON, 20, 80);
        Mago mago = new Mago("Lily Potter", MAX_VIDA, GRYFFINDOR, 1, new Varita());
        Varita varitaRoble = new Varita(TEJO,PLUMA_FENIX, 30, MAX_POW);
        Mago mortifago = new Mago("Voldemort", MAX_VIDA, SLYTHERIN, 10, varitaRoble);

        Hechizo avadakedavra = new Hechizo("Avada Kedavra", 5){
            @Override
            public String efecto(Object objetivo){
                if(objetivo instanceof Personaje){
                    ((Personaje)objetivo).setVida(0);
                    return "Mataste a " + ((Personaje)objetivo).getNombre();
                }
                return "No se puede matar a " + objetivo;
            }
        };

        Hechizo expelliarmus = new Hechizo("Expelliarmus", 2){
            @Override
            public String efecto(Object objetivo){
                if(objetivo instanceof Mago){
                    ((Mago)objetivo).setVarita(new Varita());
                    return "Has desarmado a " + ((Mago)objetivo).getNombre();
                }
                return "No puedes desarmar a " + objetivo;
            }
        };
        mago.aprenderHechizo(expelliarmus);
        mortifago.aprenderHechizo(avadakedavra);

        // probar a lanzar hechizo sin varita
        assertFalse(mago.lanzarHechizo(mortifago, "Expelliarmus"));

        // probar a lanzar hechizo sin mana
        mago.setVarita(varitaEbano);
        assertFalse(mago.lanzarHechizo(mortifago, "Expelliarmus"));


        // lanzar con éxito un hechizo
        assertTrue(mortifago.lanzarHechizo(mago, "Avada Kedavra"));

    }

    @Test
    void aprenderHechizo() {
        Mago mago = new Mago("Harry", MAX_VIDA, GRYFFINDOR, 10, new Varita());
        Varita varita = new Varita(OLMO, CABELLO_THESTRAL, 30, MAX_POW);
        mago.setVarita(varita);
        Hechizo hechizo = new Hechizo("Wingardium Leviosa", 5);
        assertTrue(mago.aprenderHechizo(hechizo));
        assertEquals(mago.getHechizos()[0].getNombre(), "WINGARDIUM LEVIOSA");

        Object pluma = new Object();

        assertTrue(mago.lanzarHechizo(pluma, "Wingardium Leviosa"));
        assertEquals(5, mago.getMagia());

        // el hechizo puede estar en minusculas
        assertTrue(mago.lanzarHechizo(pluma, "wingardium leviosa"));
        assertEquals(0, mago.getMagia());

        // el hechizo puede tener espacio al principio y al final
        assertFalse(mago.lanzarHechizo(pluma, " Wingardium Leviosa "));
        assertEquals(0, mago.getMagia());

    }

    @Test
    void cogerVarita() {
        Mago mago = new Mago("Harry", MAX_VIDA, GRYFFINDOR, MAX_MAGIA, new Varita());
        Hechizo hechizo = new Hechizo("Wingardium Leviosa", MAX_COSTE);
        assertTrue(mago.aprenderHechizo(hechizo));

        Object pluma = new Object();
        assertFalse(mago.lanzarHechizo(pluma, "Wingardium Leviosa"));

        Varita varita = new Varita(Madera.ACEBO, Nucleo.CABELLO_UNICORNIO, 30, MAX_POW);
        mago.setVarita(varita);

        assertTrue(mago.lanzarHechizo(pluma, "Wingardium Leviosa"));

        assertEquals(MAX_MAGIA-MAX_COSTE, mago.getMagia());
    }

    @Test
    void olvidarHechizo() {
        Mago mago = new Mago("Harry", MAX_VIDA, GRYFFINDOR, MAX_MAGIA, new Varita());
        Varita varita = new Varita(ACEBO, PLUMA_FENIX, 30, MAX_POW);
        mago.setVarita(varita);
        Hechizo hechizo = new Hechizo("Wingardium Leviosa", 5);

        assertFalse(mago.olvidarHechizo(hechizo));
        assertTrue(mago.aprenderHechizo(hechizo));
        assertTrue(mago.olvidarHechizo(hechizo));
        for (int i = 0; i < MAX_HECHIZOS; i++) {
            assertEquals(mago.getHechizos()[i],new Hechizo());
        }


    }
}