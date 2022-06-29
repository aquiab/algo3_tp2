package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.Estado;
import edu.fiuba.algo3.modelo.Vehiculo;

public class SorpresaVehiculoV2 implements ISorpresa {

    public SorpresaVehiculoV2(SorpresaVehiculoConstructor constructor) {}

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarSorpresaCambioVehiculo();
    }
}
