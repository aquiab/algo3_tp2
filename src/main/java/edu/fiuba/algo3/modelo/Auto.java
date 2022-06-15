package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Auto extends Vehiculo{
    Random rand = new Random();

    public Auto(double movimientos, Posicion posicion) {
        super(movimientos, posicion);
    }

    public void pasarPozo() {
        this.movimientos += 3;
    }

    public void pasarControlPolicial() {
        if (rand.nextInt(10) <= 4) {
            this.movimientos += 3;
        }
    }

    public void pasarPiquete() {

    }
    
    public Camioneta aplicarSorpresaCambioVehiculo() {
        return (new Camioneta(this.movimientos, this.posicion));
    }
}
