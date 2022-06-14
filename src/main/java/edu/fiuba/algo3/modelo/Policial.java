package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Policial extends Obstaculo {

    private final Integer PENALIZACION_POLICIAL = 3;
    @Override
    public void aplicar(Vehiculo vehiculo) {
        Random rand = new Random();
        boolean val = rand.nextInt(10)<=(vehiculo.probabilidadEncontrarControl());
        if (val) {
            vehiculo.aumentarPuntos(this.PENALIZACION_POLICIAL);
        }
    }
}
