package edu.fiuba.algo3.modelo;

public class SorpresaDesfavorable extends Sorpresa {

    private double PENALIZACION_SORPRESA = 1.25;
    @Override
    public void aplicar(Usuario juego) {
        Vehiculo vehiculo = juego.devolverVehiculo();
        vehiculo.multiplicarPuntosPor(PENALIZACION_SORPRESA);
    }
}
