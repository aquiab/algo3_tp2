package edu.fiuba.algo3.modelo.fabrica_obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.IObstaculo;

public class VacioObstaculo implements IObstaculo {
    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.aplicarVacio();
    }
}
