package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.sorpresas.ISorpresa;
import edu.fiuba.algo3.modelo.sorpresas.SorpresaVehiculo;

public class SorpresaVehiculoConstructor implements ISorpresaConstructor {

    private double valorSorpresa;
    private Estado siguienteEstado;

    @Override
    public ISorpresaConstructor valorSopresa(double valor) {
        this.valorSorpresa = valor;
        return this;
    }

    @Override
    public ISorpresaConstructor siguienteEstado(Estado estado) {
        this.siguienteEstado = estado;
        return this;
    }

    @Override
    public double obtenerValor() {
        return this.valorSorpresa;
    }

    @Override
    public Estado obtenerSiguienteEstado() {
        return this.siguienteEstado;
    }

    @Override
    public ISorpresa construir() {
        return new SorpresaVehiculo(this);
    }
}
