package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Vehiculo;

public abstract class Estado {
    protected Integer PENALIZACION_POZO;
    protected Integer PENALIZACION_POLICIAL;
    protected Integer PROBABILIDAD_CONTROL_POLICIAL;
    protected Integer PENALIZACION_PIQUETE = 0;
    protected Vehiculo vehiculo;

    public Estado(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public abstract Estado aplicarSorpresaCambioVehiculo();

    public void pasarControlPolicial(double valorActual) {
        if (valorActual <= this.PROBABILIDAD_CONTROL_POLICIAL) vehiculo.incrementarMovimientos(this.PENALIZACION_POLICIAL);
    }

    public abstract void pasarPiquete();

    public void pasarPozo() {
        vehiculo.incrementarMovimientos(this.PENALIZACION_POZO);
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