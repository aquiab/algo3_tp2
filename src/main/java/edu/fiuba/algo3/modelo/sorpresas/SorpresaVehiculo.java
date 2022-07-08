package edu.fiuba.algo3.modelo.sorpresas;

import edu.fiuba.algo3.modelo.Vehiculo;

public class SorpresaVehiculo implements ISorpresa {

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarSorpresaCambioVehiculo();
    }

}
