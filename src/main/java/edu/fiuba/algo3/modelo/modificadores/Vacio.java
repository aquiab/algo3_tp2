package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;

public class Vacio implements Obstaculo, Sorpresa {

    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarVacio();
    }

}
