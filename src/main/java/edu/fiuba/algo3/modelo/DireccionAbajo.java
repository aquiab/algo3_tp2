package edu.fiuba.algo3.modelo;

public class DireccionAbajo implements Direccion {
	
	public Posicion mover(Posicion posicion) {
		return new Posicion(posicion.x, posicion.y + 1);
	}
}