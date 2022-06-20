package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Camioneta extends Estado{
    Random rand = new Random();

    public Camioneta(Vehiculo vehiculo) {
        super(vehiculo);
    }
    protected int cantidadPozos = 0;

    public void pasarPozo() {
        this.cantidadPozos++;
        if (this.cantidadPozos % 3 == 0) {
            vehiculo.incrementarMovimientos(2);
            return;
        }
        vehiculo.incrementarMovimientos(1);
    }

    public void pasarControlPolicial() {
        if (rand.nextInt(10) <= 2) {
            vehiculo.incrementarMovimientos(3);
            return;
        }
        vehiculo.incrementarMovimientos(1);
    }

    public void pasarPiquete() {
        vehiculo.posicion.modificarPaso(new PasoBloqueado());
        vehiculo.incrementarMovimientos(1);
    }

    public Moto aplicarSorpresaCambioVehiculo() {
        return (new Moto(vehiculo));
    }
}

