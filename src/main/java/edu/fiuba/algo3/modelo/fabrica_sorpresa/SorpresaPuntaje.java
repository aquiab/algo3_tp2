package edu.fiuba.algo3.modelo.fabrica_sorpresa;

import edu.fiuba.algo3.modelo.Vehiculo;

public class SorpresaPuntaje implements ISorpresa {

    private double valorSorpresa;

    public SorpresaPuntaje(double valorSorpresa) {
        this.valorSorpresa = valorSorpresa;
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarSorpresaPuntaje(obtenerValor());
    }

    public double obtenerValor() {
        return this.valorSorpresa;
    }
}
