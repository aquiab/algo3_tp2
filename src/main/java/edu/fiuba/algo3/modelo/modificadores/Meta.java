package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.IConstructorObstaculo;
import edu.fiuba.algo3.modelo.constructores.ISorpresa;

public class Meta implements Sorpresa, ISorpresa {
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.ganar();
    }
}
