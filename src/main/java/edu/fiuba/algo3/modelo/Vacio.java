package edu.fiuba.algo3.modelo;

public class Vacio implements Modificador{
    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarVacio();
    }
}
