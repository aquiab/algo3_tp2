package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.modificadores.Obstaculo;

public interface IConstructorObstaculo {

    public IConstructorObstaculo penalizacion(double penalizacion);
    public IConstructorObstaculo probabilidad(double porcentaje);
    public double obtenerPenalizacion();
    public double obtenerProbabilidad();
    public IObstaculo construir();
}
