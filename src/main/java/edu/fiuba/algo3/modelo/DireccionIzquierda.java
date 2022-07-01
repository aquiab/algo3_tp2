package edu.fiuba.algo3.modelo;

public class DireccionIzquierda implements Direccion {
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		posicion.moverIzquierda(vehiculo);
	}
}