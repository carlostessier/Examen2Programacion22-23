package com.hogwartslegacy;

import com.hogwartslegacy.modelo.Mago;
import com.hogwartslegacy.modelo.Muggle;
import com.hogwartslegacy.modelo.Personaje;
import com.hogwartslegacy.modelo.Varita;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {

    @Test
    void getNombre() {

    }

    @Test
    void setNombre() {
        Personaje p1 = new Muggle("Pepe", 100);
        assertEquals(0, p1.getNombre().compareTo("PEPE"));
        Personaje p2 = new Mago(" Harry Potter ", 100);
        assertEquals(0, p2.getNombre().compareTo("HARRY POTTER"));

    }

    @Test
    void getVida() {

    }

    @Test
    void setVida() {
        Personaje p = new Muggle();
        assertEquals(0, p.getVida());
        p.setVida(50);
        assertEquals(50, p.getVida());
        p.setVida(-1);
        assertEquals(50, p.getVida());
        p.setVida(101);
        assertEquals(50, p.getVida());

        // probando constructores
        p = new Mago("prueba1", -1);
        assertEquals(0, p.getVida());
        p = new Mago("prueba2", 101);
        assertEquals(0, p.getVida());
        p = new Muggle("prueba3", -1);
        assertEquals(0, p.getVida());
        p = new Muggle("prueba4", 101);
        assertEquals(0, p.getVida());



    }

    @Test
    void testToString() {
        Personaje muggle = new Muggle("Pepe", 100);
        System.out.println(muggle.toString());
        assertEquals(0, muggle.toString().compareTo("PEPE (pv:100)"));
        Personaje mago = new Mago("Harry Potter", 100, Mago.Casa.GRYFFINDOR, 100, new Varita());
        System.out.println(mago.toString());
        assertEquals(0, mago.toString().compareTo("HARRY POTTER (pv:100,pm:100) GRYFFINDOR"));
    }
}