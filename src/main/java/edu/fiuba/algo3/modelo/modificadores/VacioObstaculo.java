package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.IObstaculo;

public class VacioObstaculo implements Obstaculo, IObstaculo {
    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.aplicarVacio();
    }
}
