package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Auto extends Estado{
    Random rand = new Random();

    public Auto(Vehiculo vehiculo) {
        super(vehiculo);
    }

    public void pasarPozo() {
        vehiculo.incrementarMovimientos(3);
    }

    public void pasarControlPolicial() {
        if (rand.nextInt(10) <= 4) {
            vehiculo.incrementarMovimientos(3);
        }
    }

    public void pasarPiquete() {
        vehiculo.posicion.modificarPaso(new PasoBloqueado());
    }

    public Camioneta aplicarSorpresaCambioVehiculo() {
        return (new Camioneta(vehiculo));
    }
}
