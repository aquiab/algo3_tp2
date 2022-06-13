package edu.fiuba.algo3.modelo;

public class SorpresaCambioVehiculo extends Sorpresa {

    @Override
    public void aplicar(Usuario juego, Vehiculo vehiculo) {
        Esquina posicionActual = vehiculo.obtenerPosicionActual();
        juego.establecerVehiculo(vehiculo.cambiarAlSiguiente());
        juego.asignarPosicionInicial(posicionActual);
    }
}
