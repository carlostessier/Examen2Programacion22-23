package com.hogwartslegacy.modelo;

import org.junit.jupiter.api.Test;

import static com.hogwartslegacy.modelo.Hechizo.MAX_COSTE;
import static org.junit.jupiter.api.Assertions.*;

class HechizoTest {

    @Test
    void setNombre() {
        Hechizo h = new Hechizo();
        assertNotNull(h.getNombre());
        assertEquals("", h.getNombre());
        h.setNombre("Expecto Patronum ");
        assertEquals("EXPECTO PATRONUM", h.getNombre());
    }

    @Test
    void setCosteMana() {
        Hechizo h = new Hechizo();
        assertEquals(0, h.getCosteMana());
        h.setCosteMana(10);
        assertEquals(10, h.getCosteMana());
        h.setCosteMana(-1);
        assertEquals(0, h.getCosteMana());
        h.setCosteMana(MAX_COSTE + 1);
        assertEquals(MAX_COSTE, h.getCosteMana());
    }

    @Test
    void efecto() {
        Personaje p = new Muggle("Pepe", 100, "fontanero");
        Hechizo h = new Hechizo();
        assertEquals("Lanzando hechizo ", h.efecto(p));
        h.setNombre("Expecto Patronum");
        assertEquals("Lanzando hechizo EXPECTO PATRONUM", h.efecto(p));
    }
}