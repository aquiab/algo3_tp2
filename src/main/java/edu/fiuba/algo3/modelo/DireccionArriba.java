package edu.fiuba.algo3.modelo;

public class DireccionArriba extends Direccion {

	DireccionArriba(Mapa mapa) {
		super(mapa);
	}
	
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		Calle calle = mapa.obtenerCalleVertical(posicion);
		posicion.modificarY(-1);
		calle.recorrer(vehiculo);
	}
}
