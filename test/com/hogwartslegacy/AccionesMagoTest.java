package com.hogwartslegacy;

import com.hogwartslegacy.modelo.Hechizo;
import com.hogwartslegacy.modelo.Mago;
import com.hogwartslegacy.modelo.Personaje;
import com.hogwartslegacy.modelo.Varita;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccionesMagoTest {

    @Test
    void lanzarHechizo() {
        Varita varitaEbano = new Varita("Ebano", 20, 80);
        Mago mago = new Mago("Lily Potter", 100, Mago.Casa.GRYFFINDOR, 20, new Varita());
        Varita varitaRoble = new Varita("Roble", 30, 100);
        Mago mortifago = new Mago("Voldemort", 100, Mago.Casa.SLYTHERIN, 100, varitaRoble);

        Hechizo avadakedavra = new Hechizo("Avada Kedavra", 50){
            @Override
            public String lanzarHechizo(Object objetivo){
                if(objetivo instanceof Personaje){
                    ((Personaje)objetivo).setVida(0);
                    return "Mataste a " + ((Personaje)objetivo).getNombre();
                }
                return "No se puede matar a " + objetivo;
            }
        };

        Hechizo expelliarmus = new Hechizo("Expelliarmus", 25){
            @Override
            public String lanzarHechizo(Object objetivo){
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
        Mago mago = new Mago("Harry", 100, Mago.Casa.GRYFFINDOR, 100, new Varita());
        Varita varita = new Varita("Roble", 30, 100);
        mago.setVarita(varita);
        Hechizo hechizo = new Hechizo("Wingardium Leviosa", 5);
        assertTrue(mago.aprenderHechizo(hechizo));
        assertEquals(mago.getHechizos()[0].getNombre(), "WINGARDIUM LEVIOSA");

        Object pluma = new Object();

        assertTrue(mago.lanzarHechizo(pluma, "Wingardium Leviosa"));
        assertEquals(95, mago.getMagia());

        // el hechizo puede estar en minusculas
        assertTrue(mago.lanzarHechizo(pluma, "wingardium leviosa"));
        assertEquals(90, mago.getMagia());

        // el hechizo puede tener espacio al principio y al final
        assertTrue(mago.lanzarHechizo(pluma, " Wingardium Leviosa "));
        assertEquals(85, mago.getMagia());

    }

    @Test
    void cogerVarita() {
        Mago mago = new Mago("Harry", 100, Mago.Casa.GRYFFINDOR, 100, new Varita());
        Hechizo hechizo = new Hechizo("Wingardium Leviosa", 5);
        assertTrue(mago.aprenderHechizo(hechizo));

        Object pluma = new Object();
        assertFalse(mago.lanzarHechizo(pluma, "Wingardium Leviosa"));

        Varita varita = new Varita("Roble", 30, 100);
        mago.setVarita(varita);

        assertTrue(mago.lanzarHechizo(pluma, "Wingardium Leviosa"));

        assertEquals(95, mago.getMagia());
    }

    @Test
    void olvidarHechizo() {
        Mago mago = new Mago("Harry", 100, Mago.Casa.GRYFFINDOR, 100, new Varita());
        Varita varita = new Varita("Roble", 30, 100);
        mago.setVarita(varita);
        Hechizo hechizo = new Hechizo("Wingardium Leviosa", 5);

        assertFalse(mago.olvidarHechizo(hechizo));
        assertTrue(mago.aprenderHechizo(hechizo));
        assertTrue(mago.olvidarHechizo(hechizo));
        assertEquals(mago.getHechizos()[0].getNombre(), "");

    }
}