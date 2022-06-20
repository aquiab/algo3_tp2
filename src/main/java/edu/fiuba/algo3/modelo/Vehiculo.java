package edu.fiuba.algo3.modelo;

public class Vehiculo {

    protected Posicion posicion;
    protected double movimientos;
    protected Estado estado;

    protected Vehiculo(double movimientos, Posicion posicion) {
        this.movimientos = movimientos;
        this.posicion = posicion;
    }

    public void mover(Direccion direccion) {
        //Si soy penalizado por un pozo solo me dan 3 de penalización.
        //movimientos += 0;
        direccion.mover(this.posicion, this);
    }
    public void aplicarEstado(Estado estado) {
        this.estado = estado;
    }

    public void incrementarMovimientos(int incremento) {
        movimientos += incremento;
    }

    public void aplicarSorpresaDesfavorable() {
        movimientos *= 1.25;
    }

    public void aplicarSorpresaFavorable() {
        movimientos *= 0.8;
    }

    public void pasarPiquete() {
        estado.pasarPiquete();
    }

    public void pasarPozo() {
        estado.pasarPozo();
    }

    public void pasarControlPolicial() {
        estado.pasarControlPolicial();
    }

    public void aplicarSorpresaCambioVehiculo() {
        estado = estado.aplicarSorpresaCambioVehiculo();
    }

    public void aplicarVacio() {
        estado.pasarVacio();
    }
}

