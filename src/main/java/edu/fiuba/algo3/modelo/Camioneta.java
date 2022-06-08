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
        ObsMap.put(Pozo.class, (x) -> pasarPozo(x));
        ObsMap.put(Piquete.class, (x) -> pasarPiquete(x));
        ObsMap.put(Policial.class, (x) -> pasarPolicial(x));
    }

    private void pasarPozo(Obstaculo x) {
        cantpozos++;
        if (cantpozos%3 == 0) {
            this.movimientos += 2;
        }
        this.movimientos += 0;
    }

    private void pasarPiquete(Obstaculo x) {
    }
    private void pasarPolicial(Obstaculo x) {
        Random rand = new Random();
        boolean val = rand.nextInt(10)<=2;
        if (val) {
            this.movimientos += 3;
        }
    }

}

