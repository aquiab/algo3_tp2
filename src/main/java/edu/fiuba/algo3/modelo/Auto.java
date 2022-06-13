package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class Auto extends Vehiculo{

    public Auto(Puntaje puntos) {
        this.movimientos = puntos;
    }

    @Override
    protected void initObsMap() {
        ObsMap = new HashMap<>();
        ObsMap.put(Pozo.class, this::pasarPozo);
        ObsMap.put(Piquete.class, this::pasarPiquete);
        ObsMap.put(Policial.class, this::pasarPolicial);
    }

    private void pasarPozo(Obstaculo x) {
        this.movimientos.aumentarPuntos(3);
    }

    private void pasarPiquete(Obstaculo x) {
        this.posicion_siguiente = posicion;
    }
    private void pasarPolicial(Obstaculo x) {
        Random rand = new Random();
        boolean val = rand.nextInt(10)<=4;
        if (val) {
            this.movimientos.aumentarPuntos(3);
        }
    }

    public Camioneta cambiarAlSiguiente() {
        return (new Camioneta(this.movimientos));
    }
}
