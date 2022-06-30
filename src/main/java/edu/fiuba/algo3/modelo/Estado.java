package edu.fiuba.algo3.modelo;

import java.util.Random;

public abstract class Estado {

    protected Integer PENALIZACION_POZO;
    protected Integer PENALIZACION_POLICIAL;
    protected Integer PROBABILIDAD_CONTROL_POLICIAL;
    protected Integer PENALIZACION_PIQUETE = 0;
    protected Vehiculo vehiculo;

    Estado(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public abstract Estado aplicarSorpresaCambioVehiculo();

    public void pasarControlPolicial(double penalizacion, double probabilidad, double valorActual) {
        if (valorActual <= probabilidad) vehiculo.incrementarMovimientos(penalizacion);
    }

    public abstract void pasarPiquete(double penalizacion);

    public void pasarPozo(double penalizacion) {
        vehiculo.incrementarMovimientos(penalizacion);
    }

    public void pasarVacio() {
    }

    public double obtenerPenalizacionPozo() {
        return PENALIZACION_POZO;
    }
    public double obtenerPenalizacionControl() {
        return PENALIZACION_POLICIAL;
    }
    public double obtenerProbabilidadControl() {
        return PROBABILIDAD_CONTROL_POLICIAL;
    }
    public double obtenerPenalizacionPiquete() {
        return PENALIZACION_PIQUETE;
    }


}

