package edu.fiuba.algo3.modelo.fabrica_obstaculos;

public class ControlPolicialFabrica implements IObstaculoFabrica {

    @Override
    public IObstaculo crearObstaculo() {
        return new ControlPolicial();
    }
}
