package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculos.IObstaculo;

public class ControlPolicialConstructor implements IConstructorObstaculo {

    private double penalizacion;
    private double probabilidad;

    @Override
    public IConstructorObstaculo penalizacion(double penalizacion) {
        this.penalizacion = penalizacion;
        return this;
    }

    @Override
    public IConstructorObstaculo probabilidad(double porcentaje) {
        this.probabilidad = porcentaje;
        return this;
    }

    @Override
    public double obtenerPenalizacion() {
        return this.penalizacion;
    }

    @Override
    public double obtenerProbabilidad() {
        return this.probabilidad;
    }

    @Override
    public IObstaculo construir() {
        return new ControlPolicial(this);
    }
}