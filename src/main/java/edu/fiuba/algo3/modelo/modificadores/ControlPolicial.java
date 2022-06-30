package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.ControlPolicialConstructor;

import java.util.Random;

public class ControlPolicial implements IObstaculo {
    private final double penalizacionControl;
    private final double probabilidadControl;

    public ControlPolicial(ControlPolicialConstructor constructor) {
        this.penalizacionControl = constructor.obtenerPenalizacion();
        this.probabilidadControl = constructor.obtenerProbabilidad();
    }

    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.pasarControlPolicial(this.penalizacionControl, this.probabilidadControl, pasoControlAleatorio());
    }

    /** Generador de valores aleatorios para el paso del control policial
     * @return valor aleatorio (double) entre 0 y 10.
     */
    public double pasoControlAleatorio() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
}
