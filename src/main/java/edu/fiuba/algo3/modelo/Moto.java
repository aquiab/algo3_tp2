package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Moto extends Estado{
    Random rand = new Random();

    public Moto(Vehiculo vehiculo) {
        super(vehiculo);
    }

    public void pasarPozo() {
        vehiculo.incrementarMovimientos(3);
    }

    public void pasarPiquete() {
        vehiculo.incrementarMovimientos(2);
    }

    public void pasarControlPolicial() {
        if (rand.nextInt(10) <= 7) {
            vehiculo.incrementarMovimientos(3);
        }
    }

    public Auto aplicarSorpresaCambioVehiculo() {
        return (new Auto(vehiculo));
    }
}
