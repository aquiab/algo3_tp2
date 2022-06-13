package edu.fiuba.algo3.modelo;

import java.util.HashMap;

import java.util.Random;

public class Moto extends Vehiculo{

    public Moto(Puntaje puntos) {
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
        this.movimientos.aumentarPuntos(2);
    }
    private void pasarPolicial(Obstaculo x) {
        Random rand = new Random();
        boolean val = rand.nextInt(10)<=7;
        if (val) {
            this.movimientos.aumentarPuntos(3);
        }
    }

    public Auto cambiarAlSiguiente() {
        return (new Auto(this.movimientos));
    }
}
