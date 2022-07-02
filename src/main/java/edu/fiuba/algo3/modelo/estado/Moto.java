package edu.fiuba.algo3.modelo.estado;
import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Estado;

import java.util.Random;

public class Moto extends Estado {
    Random rand = new Random();
    private Integer PENALIZACION_PIQUETE = 2;

    public Moto(Vehiculo vehiculo) {
        super(vehiculo);
        PENALIZACION_POLICIAL = 3;
        PENALIZACION_POZO = 3;
        PROBABILIDAD_CONTROL_POLICIAL = 7;
    }



    public void pasarPiquete() {
        vehiculo.incrementarMovimientos(PENALIZACION_PIQUETE);
    }

    public Auto aplicarSorpresaCambioVehiculo() {
        return (new Auto(vehiculo));
    }
}
