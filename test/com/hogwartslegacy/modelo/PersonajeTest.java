package com.hogwartslegacy.modelo;

import static com.hogwartslegacy.modelo.Casa.*;
import static com.hogwartslegacy.modelo.Mago.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class PersonajeTest {

    @Test
    void getNombre() {

    }

    @Test
    void setNombre() {
        Personaje p1 = new Muggle("Pepe", 100,"fontanero");
        assertEquals(0, p1.getNombre().compareTo("PEPE"));
        Personaje p2 = new Mago(" Harry Potter ", 100);
        assertEquals(0, p2.getNombre().compareTo("HARRY POTTER"));
        p1.setNombre(null);
        assertEquals(0, p1.getNombre().compareTo("PEPE"));

    }


    @Test
    void setVida() {
        Personaje p = new Muggle();
        assertEquals(0, p.getVida());
        p.setVida(50);
        assertEquals(50, p.getVida());
        p.setVida(-1);
        assertEquals(0, p.getVida());
        p.setVida(MAX_VIDA+1);
        assertEquals(MAX_VIDA, p.getVida());

        // probando constructores
        p = new Mago("prueba1", -1);
        assertEquals(0, p.getVida());
        p = new Mago("prueba2", MAX_VIDA+1);
        assertEquals(MAX_VIDA, p.getVida());
        p = new Muggle("prueba3", -1,"");
        assertEquals(0, p.getVida());
        p = new Muggle("prueba4", MAX_VIDA+1,"");
        assertEquals(MAX_VIDA, p.getVida());



    }

    @Test
    void testToString() {
        Personaje muggle = new Muggle("Pepe", MAX_VIDA, "fontanero");
        assertEquals(0, muggle.toString().compareTo("PEPE (pv:"+MAX_VIDA+") FONTANERO"));
        Personaje mago = new Mago("Harry Potter", Personaje.MAX_VIDA, GRYFFINDOR, MAX_MAGIA, new Varita());
        assertEquals(0, mago.toString().compareTo("HARRY POTTER (pv:"+MAX_VIDA+",pm:"+MAX_MAGIA+") GRYFFINDOR"));
    }
}