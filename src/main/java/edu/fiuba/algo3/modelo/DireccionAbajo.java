package edu.fiuba.algo3.modelo;

public class DireccionAbajo extends Direccion {

	DireccionAbajo(Mapa mapa) {
		super(mapa);
	}
	
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		posicion.modificarY(1);
		Calle calle = mapa.obtenerCalleVertical(posicion);
		calle.recorrer(vehiculo);
	}
}