package edu.fiuba.algo3.modelo;

public class DireccionIzquierda extends Direccion {

	DireccionIzquierda(Mapa mapa) {
		super(mapa);
	}
	
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		Calle calle = mapa.obtenerCalleHorizontal(posicion);
		posicion.modificarX(-1);
		calle.recorrer(vehiculo);
	}
}