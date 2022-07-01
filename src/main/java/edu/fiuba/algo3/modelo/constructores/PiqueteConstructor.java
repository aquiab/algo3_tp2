package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.obstaculos.Piquete;

public class PiqueteConstructor implements IConstructorObstaculo {

    private double penalizacionPiquete;
    private double probabilidad;

    @Override
    public IConstructorObstaculo penalizacion(double penalizacion) {
        this.penalizacionPiquete = penalizacion;
        return this;
    }

    @Override
    public IConstructorObstaculo probabilidad(double porcentaje) {
        this.probabilidad = porcentaje;
        return this;
    }

    @Override
    public double obtenerPenalizacion() {
        return this.penalizacionPiquete;
    }

    @Override
    public double obtenerProbabilidad() {
        return this.probabilidad;
    }

    @Override
    public IObstaculo construir() {
        return new Piquete(this);
    }
}
