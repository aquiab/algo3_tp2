package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.Vehiculo;

public class SopresaPuntaje implements ISorpresa {

    private double valorSorpresa;

    public SopresaPuntaje(ISorpresaConstructor constructor) {
        this.valorSorpresa = constructor.obtenerValor();
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.multiplicarMovimientos(this.valorSorpresa);
    }
}
