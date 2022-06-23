package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.*;

public class Calle {
    public Obstaculo obstaculo;
    public Sorpresa sorpresa;

    public Meta meta = new Vacio();
    public void recorrer(Vehiculo vehiculo) {
        obstaculo.aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);
        meta.aplicar(vehiculo);
    }

    public void agregarObstaculo(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void agregarSorpresa(Sorpresa sorpresa) {
        this.sorpresa = sorpresa;
    }

    public void agregarMeta(MetaFinal meta) {this.meta = meta;}
}