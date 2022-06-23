package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;

public class MetaFinal implements Meta{

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.ganar();
    }
}
