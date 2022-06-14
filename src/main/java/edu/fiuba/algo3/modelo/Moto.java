package edu.fiuba.algo3.modelo;

import java.util.HashMap;

import java.util.Random;

public class Moto extends Vehiculo{
    public Moto(Puntaje puntos) {
        this.movimientos = puntos;
        this.PROBABILIDAD_DE_ENCONTRAR_CONTROL = 8;
    }

    public Auto cambiarAlSiguiente() {
        return new Auto(this.movimientos);
    }
}
