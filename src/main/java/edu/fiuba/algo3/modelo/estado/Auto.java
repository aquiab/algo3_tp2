package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculo;

public class Auto extends Estado {

    public Auto(Vehiculo vehiculo) {
        super(vehiculo);
        PENALIZACION_POLICIAL = 3;
        PENALIZACION_POZO = 3;
        PROBABILIDAD_CONTROL_POLICIAL = 5;
    }

    public void pasarPiquete() {
        Posicion posicion = vehiculo.devolverPosicion();
        posicion.defaultearSig();
    }

    public Camioneta aplicarSorpresaCambioVehiculo() {
        return (new Camioneta(vehiculo));
    }
}
