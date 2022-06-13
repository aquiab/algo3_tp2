package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class Camioneta extends Vehiculo{

    public Camioneta(Puntaje puntos) {
        this.movimientos = puntos;
    }

    private Integer cantidadPozos;

    Camioneta() {
        cantidadPozos = 0;
    }
    @Override
    protected void initObsMap() {
        ObsMap = new HashMap<>();
        ObsMap.put(Pozo.class, this::pasarPozo);
        ObsMap.put(Piquete.class, this::pasarPiquete);
        ObsMap.put(Policial.class, this::pasarPolicial);
    }

    private void pasarPozo(Obstaculo x) {
        cantidadPozos++;
        if (cantidadPozos %3 == 0) {
            this.movimientos.aumentarPuntos(2);
        }
    }

    private void pasarPiquete(Obstaculo x) {
        this.posicion_siguiente = posicion;
    }
    private void pasarPolicial(Obstaculo x) {
        Random rand = new Random();
        boolean val = rand.nextInt(10)<=2;
        if (val) {
            this.movimientos.aumentarPuntos(3);
        }
    }
    public Moto cambiarAlSiguiente() {
        return (new Moto(this.movimientos));
    }
}

