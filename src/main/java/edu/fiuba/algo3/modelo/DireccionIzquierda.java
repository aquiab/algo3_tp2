package edu.fiuba.algo3.modelo;

public class DireccionIzquierda implements Direccion {
	
	public Posicion mover(Posicion posicion) {
		return new Posicion(posicion.x - 1, posicion.y);
	}
}