package edu.fiuba.algo3.modelo;

public class DireccionIzquierda extends Direccion {

	DireccionIzquierda(Mapa mapa) {
		super(mapa);
	}
	
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		Calle calle = this.obtenerCalle(posicion);
		calle.aplicarObstaculo(vehiculo);
		vehiculo.cambiarPosicion(new Posicion(posicion.x() - 1, posicion.y()));
	}

	public Calle obtenerCalle(Posicion posicion) {
		return mapa.obtenerCalleHorizontal(posicion);
	}
}