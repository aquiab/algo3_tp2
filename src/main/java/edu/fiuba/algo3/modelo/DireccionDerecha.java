package edu.fiuba.algo3.modelo;

public class DireccionDerecha extends Direccion {

	DireccionDerecha(Mapa mapa) {
		super(mapa);
	}
	
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		Posicion posicionNueva = new Posicion(posicion.x() + 1, posicion.y());
		Calle calle = mapa.obtenerCalleHorizontal(posicionNueva);
		calle.recorrer(vehiculo);
		vehiculo.cambiarPosicion(posicionNueva);
	}
}