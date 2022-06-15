package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {

    protected int fila;
    protected int columna;
    protected double movimientos;

    protected Vehiculo(double movimientos) {
        this.movimientos = movimientos;
    }

    public void aplicarSorpresaDesfavorable() {
        this.movimientos *= 1.25;
    }

    public void aplicarSorpresaFavorable() {
        this.movimientos *= 0.8;
    }

    public abstract Vehiculo aplicarSorpresaCambioVehiculo();

    public void pasarControlPolicial() {
        this.movimientos += 3;
    }

    public abstract void pasarPiquete();

    public abstract void pasarPozo();
}
