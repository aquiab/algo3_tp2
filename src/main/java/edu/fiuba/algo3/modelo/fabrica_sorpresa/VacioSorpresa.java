package edu.fiuba.algo3.modelo.fabrica_sorpresa;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.ISorpresa;

public class VacioSorpresa implements ISorpresa {

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarVacio();
    }

}
