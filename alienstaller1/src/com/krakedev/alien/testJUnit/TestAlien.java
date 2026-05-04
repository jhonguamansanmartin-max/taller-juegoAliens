package com.krakedev.alien.testJUnit;

import static org.junit.jupiter.api.Assertions.*;
import com.krakedev.alien.Alien;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestAlien {

    //Validar asignación de atributos
   
    public void testCreacionAlien() {

        Alien alien = new Alien(10, "Verde");

        assertEquals(10, alien.getTamanio());
        assertEquals("Verde", alien.getColor());
    }

    // Validar tamaño mínimo
    
    public void testTamanioMinimo() {

        Alien alien = new Alien(2, "Rojo");

        // debería ajustarse a 5
        assertEquals(5, alien.getTamanio());
    }

    // Validar tamaño máximo
    @Test
    public void testTamanioMaximo() {

        Alien alien = new Alien(50, "Azul");

        // debería ajustarse a 30
        assertEquals(30, alien.getTamanio());
    }

    // Validar cálculo de precios iniciales
    @Test
    public void testCalculoPrecios() {

        Alien alien = new Alien(10, "Negro");

        assertEquals(2.0, alien.getPrecioCuerpo(), 0.001);
        assertEquals(1.0, alien.getPrecioExtremidad(), 0.001);
        assertEquals(0.5, alien.getPrecioOjo(), 0.001);
    }

    // Validar agregar brazos correctamente
    @Test
    public void testAgregarBrazosValido() {

        Alien alien = new Alien(10, "Verde");

        boolean resultado = alien.agregarBrazos(4);

        assertTrue(resultado);
        assertEquals(4, alien.getNumeroBrazos());
    }

    // Validar límite de extremidades
    @Test
    public void testAgregarBrazosExcede() {

        Alien alien = new Alien(10, "Verde");

        boolean resultado = alien.agregarBrazos(11);

        assertFalse(resultado);
        assertEquals(0, alien.getNumeroBrazos());
    }

    // Validar ojos según tamaño
    @Test
    public void testAgregarOjosLimite() {

        Alien alien = new Alien(8, "Gris"); // max 3 ojos

        assertTrue(alien.agregarOjos(3));
        assertFalse(alien.agregarOjos(1)); // excede
    }

    // Validar cálculo de precio total
    @Test
    public void testPrecioTotal() {

        Alien alien = new Alien(10, "Negro");

        alien.agregarBrazos(2);
        alien.agregarPiernas(2);
        alien.agregarOjos(2);

        double esperado = 2.0 + (4 * 1.0) + (2 * 0.5);

        assertEquals(esperado, alien.getPrecioTotal(), 0.001);
    }
}
