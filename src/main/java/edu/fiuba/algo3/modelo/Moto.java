package edu.fiuba.algo3.modelo;

import java.util.HashMap;

import java.util.Random;

public class Moto extends Vehiculo{
    @Override
    protected void initObsMap() {
        ObsMap = new HashMap<>();
        ObsMap.put(Pozo.class, this::pasarPozo);
        ObsMap.put(Piquete.class, this::pasarPiquete);
        ObsMap.put(Policial.class, this::pasarPolicial);
        ObsMap.put(Libre.class, this::pasarLibremente);
    }

    private void pasarPozo(Obstaculo x) {
        this.movimientos += 3;
    }

    private void pasarLibremente(Obstaculo x) {
    }
    private void pasarPiquete(Obstaculo x) {
        this.movimientos += 2;
    }
    private void pasarPolicial(Obstaculo x) {
        Random rand = new Random();
        boolean val = rand.nextInt(10)<=7;
        if (val) {
            this.movimientos += 3;
        }
    }

}
