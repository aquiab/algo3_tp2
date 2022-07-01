package edu.fiuba.algo3.modelo.sorpresas;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.Vehiculo;

public interface ISorpresa {
    void aplicar(Vehiculo vehiculo);

    void actualizar(double valor, Estado siguienteEstado);
}
