package edu.fiuba.algo3.modelo;

public class PasoAbierto implements Paso{
    @Override
    public void modificarPosicion(Posicion posicion, int x, int y) {
        posicion.modificarX(x);
        posicion.modificarY(y);
    }
}
