package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.obstaculos.Pozo;

public class PozoConstructor implements IConstructorObstaculo {

    private double penalizacionPozo;
    private double probabilidad;

    @Override
    public IConstructorObstaculo penalizacion(double penalizacion) {
        this.penalizacionPozo = penalizacion;
        return this;
    }

    @Override
    public IConstructorObstaculo probabilidad(double porcentaje) {
        this.probabilidad = porcentaje;
        return this;
    }

    public double obtenerProbabilidad() {
        return this.probabilidad;
    }

    public double obtenerPenalizacion() {
        return this.penalizacionPozo;
    }

    @Override
    public IObstaculo construir() {
        return new Pozo(this);
    }


}
