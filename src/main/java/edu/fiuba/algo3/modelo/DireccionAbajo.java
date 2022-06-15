package edu.fiuba.algo3.modelo;

public class DireccionAbajo extends Direccion {

	DireccionAbajo(Mapa mapa) {
		super(mapa);
	}
	
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		Calle calle = this.obtenerCalle(posicion);
		calle.aplicarObstaculo(vehiculo);
		vehiculo.cambiarPosicion(new Posicion(posicion.x(), posicion.y() + 1));
	}

	public Calle obtenerCalle(Posicion posicion) {
		return mapa.obtenerCalleVertical(posicion);
	}
}