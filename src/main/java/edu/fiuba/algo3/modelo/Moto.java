package edu.fiuba.algo3.modelo;

public class Moto extends Vehiculo{

    public Moto(double movimientos, Posicion posicion) {
        super(movimientos, posicion);
    }

    public void pasarPozo() {
        this.movimientos += 3;
    }

    public void pasarPiquete() {
        this.movimientos += 2;
    }

    public Auto aplicarSorpresaCambioVehiculo() {
        return (new Auto(this.movimientos, this.posicion));
    }
}
