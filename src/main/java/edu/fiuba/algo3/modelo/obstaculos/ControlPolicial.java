package edu.fiuba.algo3.modelo.obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo;

import java.util.Random;

public class ControlPolicial implements IObstaculo {

    /** Generador de valores aleatorios para el paso del control policial
     * @return valor aleatorio (double) entre 0 y 10.
     */
    public double pasoControlAleatorio() {
        Random rand = new Random();
        return rand.nextInt(10);
    }

    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.pasarControlPolicial(pasoControlAleatorio());
    }

}
