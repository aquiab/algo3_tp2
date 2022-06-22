package edu.fiuba.algo3.modelo;

public class Vehiculo {

    public Posicion posicion;
    protected double movimientos;
    protected Estado estado;

    private double SOPRESA_DESFAVORABLE = 1.25;
    private double SORPRESA_FAVORABLE = 0.8;
    private Integer PENALIZACION_POR_CADA_MOVIMENTO = 1;

    protected Vehiculo(double movimientos, Posicion posicion) {
        this.movimientos = movimientos;
        this.posicion = posicion;
    }

    public void mover(Direccion direccion) {
        incrementarMovimientos(PENALIZACION_POR_CADA_MOVIMENTO);
        direccion.mover(this.posicion, this);
    }
    public void aplicarEstado(Estado estado) {
        this.estado = estado;
    }

    public void incrementarMovimientos(int incremento) {
        movimientos += incremento;
    }

    public void aplicarSorpresaDesfavorable() {
        movimientos *= SOPRESA_DESFAVORABLE;
    }

    public void aplicarSorpresaFavorable() {
        movimientos *= SORPRESA_FAVORABLE;
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

