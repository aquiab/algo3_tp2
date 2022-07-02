package edu.fiuba.algo3.modelo.fabrica_sorpresa;

import edu.fiuba.algo3.modelo.Vehiculo;

public class SopresaPuntaje implements ISorpresa {

    private double valorSorpresa;

    public SopresaPuntaje(double valorSorpresa) {
        this.valorSorpresa = valorSorpresa;
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarSorpresaPuntaje(this.valorSorpresa);
    }
}
