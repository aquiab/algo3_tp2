package edu.fiuba.algo3.modelo.obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.ControlPolicialConstructor;

import java.util.Random;

public class ControlPolicial implements IObstaculo {
    private double penalizacion;
    private double probabilidad;

    public ControlPolicial(ControlPolicialConstructor constructor) {
        this.penalizacion = constructor.obtenerPenalizacion();
        this.probabilidad = constructor.obtenerProbabilidad();
    }

    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.pasarControlPolicial(this.penalizacion, this.probabilidad, pasoControlAleatorio());
    }

    /** Generador de valores aleatorios para el paso del control policial
     * @return valor aleatorio (double) entre 0 y 10.
     */
    public double pasoControlAleatorio() {
        Random rand = new Random();
        return rand.nextInt(10);
    }

    @Override
    public void actualizar(double penalizacion, double probabilidad) {
        this.penalizacion = penalizacion;
        this.probabilidad = probabilidad;
    }
}
