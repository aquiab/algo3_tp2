package edu.fiuba.algo3.modelo;

public class SorpresaFavorable extends Sorpresa {
    private double DESCUENTO_SORPRESA = 0.8;

    public void aplicar(Usuario juego) {
        Vehiculo vehiculo = juego.devolverVehiculo();
        vehiculo.multiplicarPuntosPor(DESCUENTO_SORPRESA);
    }
}
