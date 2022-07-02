package edu.fiuba.algo3.modelo.estado;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculo;

import java.util.Random;

public class Camioneta extends Estado {
    Random rand = new Random();

    public Camioneta(Vehiculo vehiculo) {
        super(vehiculo);
        PENALIZACION_POLICIAL = 3;
        PENALIZACION_POZO = 2;
        PROBABILIDAD_CONTROL_POLICIAL = 2;
    }
    protected int cantidadPozos = 0;

    @Override
    public void pasarPozo() {
        this.cantidadPozos++;
        if (this.cantidadPozos % 3 == 0) {
            vehiculo.incrementarMovimientos(PENALIZACION_POZO);
        }
    }

    public void pasarPiquete() {
        Posicion posicion = vehiculo.devolverPosicion();
        posicion.defaultearSig();
    }

    public Moto aplicarSorpresaCambioVehiculo() {
        return (new Moto(vehiculo));
    }
}

