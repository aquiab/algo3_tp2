package edu.fiuba.algo3.modelo;

public class Vehiculo {

    protected Posicion posicion;
    protected double movimientos;
    protected boolean paso;
    protected Estado estado;

    protected Vehiculo(double movimientos, Posicion posicion) {
        this.movimientos = movimientos;
        this.posicion = posicion;
        this.paso = true;
        this.estado = new Auto(this);
    }

    public void mover(Direccion direccion) {
        movimientos += 1;
        direccion.mover(posicion, this);
    }

    public void cambiarPosicion(Posicion posicion) {
        if (paso) {
            this.posicion = posicion;
        }
        paso = true;
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
        estado.aplicarSorpresaCambioVehiculo();
    }
}
