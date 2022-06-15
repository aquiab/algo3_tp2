package edu.fiuba.algo3.modelo;

public class Camioneta extends Vehiculo{

    public Camioneta(double movimientos) {
        super(movimientos);
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
        return (new Moto(this.movimientos));
    }
}

