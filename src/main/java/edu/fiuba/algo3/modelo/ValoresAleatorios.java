package edu.fiuba.algo3.modelo;

import java.util.Random;

public class ValoresAleatorios {

    public static int valorAleatorio() {
        Random rand = new Random();
        return rand.nextInt(10 - 1);
    }

    public static Posicion obtenerPosicionAleatoria(int dimension, Mapa mapa) {
        return new Posicion((int) (Math.random() * (dimension - 1)), (int) (Math.random() * (dimension - 1)), mapa);
    }

}
