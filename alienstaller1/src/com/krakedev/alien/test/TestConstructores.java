package com.krakedev.alien.test;

import com.krakedev.alien.Alien;

public class TestConstructores {

    public static void main(String[] args) {

        // Alien normal
        Alien a1 = new Alien(10, "Verde");

        // Alien con tamaño fuera de rango
        Alien a2 = new Alien(50, "Rojo");

        a1.imprimir();
        System.out.println();
        a2.imprimir();
    }
}