package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.Obstaculo;
import edu.fiuba.algo3.modelo.modificadores.Sorpresa;
import edu.fiuba.algo3.modelo.modificadores.Vacio;

public class Calle {
    public Obstaculo obstaculo = null;
    public Sorpresa sorpresa = null;

    public void recorrer(Vehiculo vehiculo) {
        if (obstaculo.getClass() == Vacio.class) {vehiculo.incrementarMovimientos(1);}
        obstaculo.aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);
    }

    public void agregarObstaculo(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
    }


    public void agregarSorpresa(Sorpresa sorpresa) {
        this.sorpresa = sorpresa;
    }


}