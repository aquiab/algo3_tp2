package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.Vehiculo;

public abstract class Estado {

    protected Integer PENALIZACION_POZO;
    protected Integer PENALIZACION_POLICIAL = 3;
    protected Integer PROBABILIDAD_CONTROL_POLICIAL;
    protected Integer PENALIZACION_PIQUETE = 0;
    protected Vehiculo vehiculo;

    public Estado(Vehiculo vehiculo) {
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

    public void pasarVacio() {}

    public double obtenerPenalizacionControl() {
        return this.PENALIZACION_POLICIAL;
    }

    public abstract double obtenerProbabilidadControl();

    public abstract double obtenerPenalizacionPozo();

    public abstract double obtenerPenalizacionPiquete();

    public abstract Estado siguienteEstado();

    public double obtenerValorSorpresaFavorable() {
        return 0.8;
    }

    public double obtenerValorSorpresaDesfavorable() {
        return 1.25;
    }
}

