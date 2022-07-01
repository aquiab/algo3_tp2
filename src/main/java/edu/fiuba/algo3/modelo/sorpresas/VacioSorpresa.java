package edu.fiuba.algo3.modelo.sorpresas;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.Vehiculo;

public class VacioSorpresa implements ISorpresa {
    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarVacio();
    }

    @Override
    public void actualizar(double v, Estado estadoActual) {
    }
}