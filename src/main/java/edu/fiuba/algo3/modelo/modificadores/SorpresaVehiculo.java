package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.SorpresaVehiculoConstructor;

public class SorpresaVehiculo implements ISorpresa {

    public SorpresaVehiculo(SorpresaVehiculoConstructor constructor) {}

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarSorpresaCambioVehiculo();
    }
}
