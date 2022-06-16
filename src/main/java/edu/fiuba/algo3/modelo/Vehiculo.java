package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {

    protected Posicion posicion;
    protected double movimientos;
    protected boolean paso;

    protected Vehiculo(double movimientos, Posicion posicion) {
        this.movimientos = movimientos;
        this.posicion = posicion;
        this.paso = true;
    }

    public void mover(Direccion direccion) {
        this.movimientos += 1;
        direccion.mover(this.posicion, this);
    }

    public void cambiarPosicion(Posicion posicion) {
        if (this.paso) {
            this.posicion = posicion;
        }
        this.paso = true;
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
