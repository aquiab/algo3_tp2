package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Moto extends Vehiculo{
    Random rand = new Random();

    public Moto(double movimientos, Posicion posicion) {
        super(movimientos, posicion);
    }

    public void pasarPozo() {
        this.movimientos += 3;
    }

    public void pasarPiquete() {
        this.movimientos += 2;
    }

    public void pasarControlPolicial() {
        if (rand.nextInt(10) <= 7) {
            this.movimientos += 3;
        }
    }

    public Auto aplicarSorpresaCambioVehiculo() {
        return (new Auto(this.movimientos, this.posicion));
    }
}
