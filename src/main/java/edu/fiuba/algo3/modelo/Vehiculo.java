package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estado.Estado;

public class Vehiculo {

    private double movimientos;
    private Estado estado;
    private Posicion posicion;
    private Integer PENALIZACION_POR_CADA_MOVIMENTO = 1;
    private Juego juego;

    protected Vehiculo(double movimientos, Posicion posicion, Juego juego) {
        this.movimientos = movimientos;
        this.posicion = posicion;
        this.juego = juego;
    }

    public void mover(Direccion direccion) {
        incrementarMovimientos(PENALIZACION_POR_CADA_MOVIMENTO);
        direccion.mover(this.posicion, this);
    }
    public void aplicarEstado(Estado estado) {
        this.estado = estado;
    }

    public void incrementarMovimientos(double incremento) {
        movimientos += incremento;
    }

    public void aplicarSorpresaPuntaje(double valorSorpresa) {
        this.movimientos *= valorSorpresa;
    }

    public void pasarPiquete() {
        estado.pasarPiquete();
    }

    public void pasarPozo() {
        estado.pasarPozo();
    }

    public void pasarControlPolicial(double valorActual) {
        estado.pasarControlPolicial(valorActual);
    }

    public void aplicarSorpresaCambioVehiculo() {
        estado = estado.aplicarSorpresaCambioVehiculo();
    }
    public void aplicarVacio() {
        estado.pasarVacio();
    }
    public Posicion devolverPosicion() {
        return this.posicion;
    }
    public void ganar() {
        this.juego.ganar(this.movimientos);
    }
    public double obtenerMovimientos() {
        return this.movimientos;
    }
    public Estado obtenerEstado() {
        return this.estado;
    }
    public int obtenerPosicionX() {
        return posicion.obtenerCoordenadaX();
    }
    public int obtenerPosicionY() {
        return posicion.obtenerCoordenadaY();
    }
}

