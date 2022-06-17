package edu.fiuba.algo3.modelo;

public class DireccionDerecha extends Direccion {

	DireccionDerecha(Mapa mapa) {
		super(mapa);
	}
	
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		posicion.modificarX(1);
		Calle calle = mapa.obtenerCalleHorizontal(posicion);
		calle.recorrer(vehiculo);
	}
}