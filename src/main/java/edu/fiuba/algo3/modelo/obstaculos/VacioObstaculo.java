package edu.fiuba.algo3.modelo.obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.obstaculos.IObstaculo;

public class VacioObstaculo implements IObstaculo {
    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.aplicarVacio();
    }

    @Override
    public void actualizar(double penalizacion, double probabilidad) {

    }
}
