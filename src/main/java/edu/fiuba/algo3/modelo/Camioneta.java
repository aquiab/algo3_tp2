package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class Camioneta extends Vehiculo{

    Integer cantpozos;

    private void Camioneta() {
        cantpozos = 0;
    }
    @Override
    protected void initObsMap() {
        ObsMap = new HashMap<>();
        ObsMap.put(Pozo.class, this::pasarPozo);
        ObsMap.put(Piquete.class, this::pasarPiquete);
        ObsMap.put(Policial.class, this::pasarPolicial);
    }

    private void pasarPozo(Obstaculo x) {
        cantpozos++;
        if (cantpozos%3 == 0) {
            this.movimientos += 2;
        }
        this.movimientos += 0;
    }

    private void pasarPiquete(Obstaculo x) {
        this.posicion_siguiente = posicion;
    }
    private void pasarPolicial(Obstaculo x) {
        Random rand = new Random();
        boolean val = rand.nextInt(10)<=2;
        if (val) {
            this.movimientos += 3;
        }
    }

}

