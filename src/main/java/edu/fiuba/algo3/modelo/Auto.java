package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Auto extends Vehiculo{

    public Auto(double movimientos, Posicion posicion) {
        super(movimientos, posicion);
    }

    public void pasarPozo() {
        this.movimientos += 3;
    }

    public void pasarPiquete() {
        
    }
    public void pasarControlPolicial() {
        Random rand = new Random();
        if (rand.nextInt(10) <= 4) {
            this.movimientos += 3;
        }
    }
    
    public Camioneta aplicarSorpresaCambioVehiculo() {
        return (new Camioneta(this.movimientos, this.posicion));
    }
}
