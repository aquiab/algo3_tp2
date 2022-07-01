package edu.fiuba.algo3.modelo.sorpresas;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.sorpresas.ISorpresa;

public class Meta implements ISorpresa {
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.ganar();
    }

    @Override
    public void actualizar(double v, Estado estadoActual) {

    }
}
