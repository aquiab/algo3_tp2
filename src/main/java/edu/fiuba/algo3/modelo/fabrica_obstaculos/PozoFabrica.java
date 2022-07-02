package edu.fiuba.algo3.modelo.fabrica_obstaculos;

public class PozoFabrica implements IObstaculoFabrica {
    @Override
    public IObstaculo crearObstaculo() {
        return new Pozo();
    }
}
