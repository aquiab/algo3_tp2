package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {

    protected Posicion posicion;
    protected double movimientos;

    protected Vehiculo(double movimientos, Posicion posicion) {
        this.movimientos = movimientos;
        this.posicion = posicion;
    }

    public void mover(Direccion direccion) {
        direccion.mover(this.posicion, this);
        this.movimientos += 1;
    }

    public void cambiarPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void aplicarSorpresaDesfavorable() {
        this.movimientos *= 1.25;
    }

    public void aplicarSorpresaFavorable() {
        this.movimientos *= 0.8;
    }

    public abstract Vehiculo aplicarSorpresaCambioVehiculo();

    public abstract void pasarControlPolicial();

    public abstract void pasarPiquete();

    public abstract void pasarPozo();
}
