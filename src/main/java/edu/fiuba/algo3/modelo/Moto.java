package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Moto extends Estado{
    Random rand = new Random();

    public Moto(Vehiculo vehiculo) {
        super(vehiculo);
    }

    public void pasarPozo() {
        vehiculo.movimientos += 3;
    }

    public void pasarPiquete() {
        vehiculo.movimientos += 2;
    }

    public void pasarControlPolicial() {
        if (rand.nextInt(10) <= 7) {
            vehiculo.movimientos += 3;
        }
    }

    public Auto aplicarSorpresaCambioVehiculo() {
        return (new Auto(vehiculo));
    }
}
