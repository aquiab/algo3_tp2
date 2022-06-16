package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Auto extends Estado{
    Random rand = new Random();

    public Auto(Vehiculo vehiculo) {
        super(vehiculo);
    }

    public void pasarPozo() {
        vehiculo.movimientos += 3;
    }

    public void pasarControlPolicial() {
        if (rand.nextInt(10) <= 4) {
            vehiculo.movimientos += 3;
        }
    }

    public void pasarPiquete() {
        vehiculo.paso = false;
    }
    
    public Camioneta aplicarSorpresaCambioVehiculo() {
        return (new Camioneta(vehiculo));
    }
}
