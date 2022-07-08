package edu.fiuba.algo3.modelo.sorpresas;

import edu.fiuba.algo3.modelo.Vehiculo;

public class SorpresaPuntaje implements ISorpresa {

    private double valorSorpresa;

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarSorpresaPuntaje(obtenerValor());
    }

    public double obtenerValor() {
        return this.valorSorpresa;
    }

    public void asignarValor(double valor) {
        this.valorSorpresa = valor;
    }
}
