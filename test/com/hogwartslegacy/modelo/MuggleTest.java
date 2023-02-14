package com.hogwartslegacy.modelo;

import org.junit.jupiter.api.Test;


import static com.hogwartslegacy.modelo.Personaje.MAX_VIDA;
import static org.junit.jupiter.api.Assertions.*;

class MuggleTest {
    @Test
    void testToString() {
        Personaje muggle = new Muggle("Pepe", MAX_VIDA, "fontanero");
        assertEquals(0, muggle.toString().compareTo("PEPE (pv:"+MAX_VIDA+") FONTANERO"));
    }

    @Test
    void testSetters() {
        Muggle muggle = new Muggle("Pepe ", MAX_VIDA, "fontanero");

        muggle.setNombre(null);
        assertEquals("PEPE", muggle.getNombre());
        muggle.setProfesion(null);
        assertEquals("FONTANERO", muggle.getProfesion());

    }

    @Test
    void testEquals() {
        Muggle muggle = new Muggle("Pepe", MAX_VIDA, "fontanero");
        Personaje muggleCopia = new Muggle(muggle);
        assertEquals(muggle, muggleCopia);
        Personaje muggleVacio = new Muggle();
        assertNotEquals(muggle, muggleVacio);
    }

}