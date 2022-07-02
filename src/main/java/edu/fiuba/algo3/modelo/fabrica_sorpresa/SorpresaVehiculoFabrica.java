package edu.fiuba.algo3.modelo.fabrica_sorpresa;

public class SorpresaVehiculoFabrica implements ISorpresaFabrica {

    @Override
    public ISorpresa crearSorpresa() {
        return new SorpresaVehiculo();
    }

}
