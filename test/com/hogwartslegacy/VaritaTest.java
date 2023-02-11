package com.hogwartslegacy;

import com.hogwartslegacy.modelo.Varita;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaritaTest {

    @Test
    void getLongitud() {
        Varita v = new Varita();
        assertEquals(0, v.getLongitud());
        v.setLongitud(20);
        assertEquals(20, v.getLongitud());
        v.setLongitud(40);
        assertEquals(40, v.getLongitud());
        v.setLongitud(19);
        assertEquals(40, v.getLongitud());
        v.setLongitud(41);
        assertEquals(40, v.getLongitud());
    }
}