package edu.fiuba.algo3.modelo;

public class DireccionAbajo extends Direccion {

	DireccionAbajo(Mapa mapa) {
		super(mapa);
	}
	
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		Posicion posicionNueva = new Posicion(posicion.x(), posicion.y() + 1);
		Calle calle = mapa.obtenerCalleVertical(posicionNueva);
		calle.recorrer(vehiculo);
		vehiculo.cambiarPosicion(posicionNueva);
	}
}