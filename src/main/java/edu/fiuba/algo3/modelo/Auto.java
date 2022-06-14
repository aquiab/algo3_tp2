package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class Auto extends Vehiculo{

    public Auto(double puntos) {
        this.movimientos = puntos;
    }

    @Override
    protected void initObsMap() {
        ObsMap = new HashMap<>();
        ObsMap.put("pozo", this::pasarPozo);
        ObsMap.put("piquete", this::pasarPiquete);
        ObsMap.put("policial", this::pasarPolicial);
    }

    private void pasarPozo(String x) {
        this.movimientos += 3;
    }

    private void pasarPiquete(String x) {
        this.posicion_siguiente = posicion;
    }
    private void pasarPolicial(String x) {
        Random rand = new Random();
        boolean val = rand.nextInt(10)<=4;
        if (val) {
            this.movimientos += 3;
        }
    }

    public Camioneta cambiarAlSiguiente() {
        return (new Camioneta(this.movimientos));
    }
}
