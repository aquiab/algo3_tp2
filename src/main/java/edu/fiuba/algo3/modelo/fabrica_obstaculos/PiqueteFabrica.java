package edu.fiuba.algo3.modelo.fabrica_obstaculos;

public class PiqueteFabrica implements IObstaculoFabrica {


    @Override
    public IObstaculo crearObstaculo() {
        return new Piquete();
    }
}
