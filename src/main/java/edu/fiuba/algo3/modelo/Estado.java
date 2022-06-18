package edu.fiuba.algo3.modelo;

public abstract class Estado {
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

