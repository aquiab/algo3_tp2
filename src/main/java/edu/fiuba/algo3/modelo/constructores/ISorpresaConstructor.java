package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.Estado;

public interface ISorpresaConstructor {

    public ISorpresaConstructor valorSopresa(double valor);
    public ISorpresaConstructor siguienteEstado(Estado estado);
    public double obtenerValor();
    public Estado obtenerSiguienteEstado();
    public ISorpresa construir();

}
