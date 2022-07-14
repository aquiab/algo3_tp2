package edu.fiuba.algo3.modelo.obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo;

public class Impuesto implements IObstaculo { //agregado
    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.pasarImpuesto();
    }
}
