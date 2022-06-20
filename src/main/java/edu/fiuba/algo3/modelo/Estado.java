package edu.fiuba.algo3.modelo;

public abstract class Estado {

    protected Integer PENALIZACION_POZO;
    protected Integer PENALIZACION_POLICIAL;
    protected Integer PROBABILIDAD_CONTROL_POLICIAL;
    Vehiculo vehiculo;

    Estado(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public abstract Estado aplicarSorpresaCambioVehiculo();

    public abstract void pasarControlPolicial();

    public abstract void pasarPiquete();

    public abstract void pasarPozo();

    public void pasarVacio() {
        return;
    }
}

