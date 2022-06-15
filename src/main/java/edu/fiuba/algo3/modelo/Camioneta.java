package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Camioneta extends Vehiculo{
    Random rand = new Random();

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

    public void pasarControlPolicial() {
        if (rand.nextInt(10) <= 2) {
            this.movimientos += 3;
        }
    }

    public void pasarPiquete() {
        this.paso = false;
    }

    public Moto aplicarSorpresaCambioVehiculo() {
        return (new Moto(this.movimientos, this.posicion));
    }
}

