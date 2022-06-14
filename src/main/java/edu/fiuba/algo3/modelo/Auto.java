package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class Auto extends Vehiculo{

    public Auto(Puntaje puntos) {
        this.movimientos = puntos;
        this.PROBABILIDAD_DE_ENCONTRAR_CONTROL = 5;
    }

    public Camioneta cambiarAlSiguiente() {
        return (new Camioneta(this.movimientos));
    }
}
