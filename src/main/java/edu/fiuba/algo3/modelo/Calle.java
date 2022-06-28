package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.*;

public class Calle {
    public Obstaculo obstaculo;
    public Sorpresa sorpresa;
    public void recorrer(Vehiculo vehiculo) {
        obstaculo.pasar(vehiculo);
        sorpresa.aplicar(vehiculo);
        borrarSorpresa();
    }

    public void agregarObstaculo(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void agregarSorpresa(Sorpresa sorpresa) {
        this.sorpresa = sorpresa;
    }

    public void borrarSorpresa() {
        this.sorpresa = new VacioSorpresa();
    }
}