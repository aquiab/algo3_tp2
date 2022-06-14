package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class Camioneta extends Vehiculo{

    public Camioneta(double puntos) {
        this.movimientos = puntos;
    }

    private Integer cantidadPozos;

    Camioneta() {
        cantidadPozos = 0;
    }
    @Override
    protected void initObsMap() {
        ObsMap = new HashMap<>();
        ObsMap.put("pozo", this::pasarPozo);
        ObsMap.put("piquete", this::pasarPiquete);
        ObsMap.put("policial", this::pasarPolicial);
    }

    private void pasarPozo(String x) {
        cantidadPozos++;
        if (cantidadPozos %3 == 0) {
            this.movimientos += 2;
        }
    }

    private void pasarPiquete(String x) {
        this.posicion_siguiente = posicion;
    }
    private void pasarPolicial(String x) {
        Random rand = new Random();
        boolean val = rand.nextInt(10)<=2;
        if (val) {
            this.movimientos += 3;
        }
    }
    public Moto cambiarAlSiguiente() {
        return (new Moto(this.movimientos));
    }
}

