package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class Camioneta extends Vehiculo{

    private Integer cantidadPozos;
    public Camioneta(Puntaje puntos) {
        this.movimientos = puntos;
        this.PROBABILIDAD_DE_ENCONTRAR_CONTROL = 3;
        this.cantidadPozos = 0;
    }

    @Override
    public void pasarPozo() {
        cantidadPozos++;
        if (cantidadPozos%3 == 0) {
            this.movimientos.aumentarPuntos(2);
        }
    }

    public Moto cambiarAlSiguiente() {
        return (new Moto(this.movimientos));
    }
}

