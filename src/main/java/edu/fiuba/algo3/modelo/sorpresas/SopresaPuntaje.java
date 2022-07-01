package edu.fiuba.algo3.modelo.sorpresas;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.ISorpresaConstructor;

public class SopresaPuntaje implements ISorpresa {

    private double valorSorpresa;

    public SopresaPuntaje(ISorpresaConstructor constructor) {
        this.valorSorpresa = constructor.obtenerValor();
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarSorpresaPuntaje(this.valorSorpresa);
    }

    @Override
    public void actualizar(double valor, Estado siguienteEstado) {
        this.valorSorpresa = valor;
    }
}
