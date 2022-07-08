package edu.fiuba.algo3.modelo.obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo;

public class VacioObstaculo implements IObstaculo {
    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.aplicarVacio();
    }
}
