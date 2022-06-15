package edu.fiuba.algo3.modelo;

public class Camioneta extends Vehiculo{

    public Camioneta(double movimientos, Posicion posicion) {
        super(movimientos, posicion);
    }
    protected int cantidadPozos = 0;

    public void pasarPozo() {
        this.cantidadPozos++;
        if (this.cantidadPozos % 3 == 0) {
            this.movimientos += 2;
        }
    }

    public void pasarPiquete() {

    }

    public Moto aplicarSorpresaCambioVehiculo() {
        return (new Moto(this.movimientos, this.posicion));
    }
}

