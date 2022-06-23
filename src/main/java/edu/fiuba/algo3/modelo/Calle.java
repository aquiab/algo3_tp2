package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.Obstaculo;
import edu.fiuba.algo3.modelo.modificadores.Sorpresa;

public class Calle {
    public Obstaculo obstaculo;
    public Sorpresa sorpresa;

    public void recorrer(Vehiculo vehiculo) {
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