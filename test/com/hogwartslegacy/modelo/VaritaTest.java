package com.hogwartslegacy.modelo;

import org.junit.jupiter.api.Test;

import static com.hogwartslegacy.modelo.Varita.MIN_LONG;
import static com.hogwartslegacy.modelo.Varita.MAX_LONG;
import static com.hogwartslegacy.modelo.Varita.MAX_POW;

import static org.junit.jupiter.api.Assertions.*;

class VaritaTest {

    @Test
    void testSetLongitud() {
        Varita v = new Varita();
        assertEquals(MIN_LONG, v.getLongitud());
        v.setLongitud(21);
        assertEquals(21, v.getLongitud());
        v.setLongitud(MAX_LONG);
        assertEquals(MAX_LONG, v.getLongitud());
        v.setLongitud(19);
        assertEquals(MIN_LONG, v.getLongitud());
        v.setLongitud(MAX_LONG + 1);
        assertEquals(MAX_LONG, v.getLongitud());
    }

    @Test
    void testSetPoderMagico() {
        Varita v = new Varita();
        assertEquals(0, v.getPoderMagico());
        v.setPoderMagico(MAX_POW);
        assertEquals(MAX_POW, v.getPoderMagico());
        v.setPoderMagico(MAX_POW+1);
        assertEquals(MAX_POW, v.getPoderMagico());
        v.setPoderMagico(-1);
        assertEquals(0, v.getPoderMagico());
    }


}