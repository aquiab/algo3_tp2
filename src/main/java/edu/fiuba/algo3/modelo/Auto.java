package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Auto extends Estado{
    Random rand = new Random();

    public Auto(Vehiculo vehiculo) {
        super(vehiculo);
        PENALIZACION_POLICIAL = 3;
        PENALIZACION_POZO = 3;
        PROBABILIDAD_CONTROL_POLICIAL = 5;
    }

    public void pasarControlPolicial() {
        if (rand.nextInt(10) <= PROBABILIDAD_CONTROL_POLICIAL) {
            vehiculo.incrementarMovimientos(PENALIZACION_POLICIAL);
        }
    }

    public void pasarPiquete() {
        Posicion posicion = vehiculo.devolverPosicion();
        posicion.defaultearSig();
    }

    @Override
    public Estado siguienteEstado() {
        return new Camioneta(vehiculo);
    }

    public Camioneta aplicarSorpresaCambioVehiculo() {
        return (new Camioneta(vehiculo));
    }
}
