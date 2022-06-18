package edu.fiuba.algo3.modelo;

public class Calle {
    public Modificador obstaculo = new Vacio();
    public Modificador sorpresa = new Vacio();

    public void recorrer(Vehiculo vehiculo) {
        obstaculo.aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);
    }

    public void agregarObstaculo(Modificador obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void agregarSorpresa(Modificador sorpresa) {
        this.sorpresa = sorpresa;
    }


}