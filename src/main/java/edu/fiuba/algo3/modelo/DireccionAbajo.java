package edu.fiuba.algo3.modelo;

public class DireccionAbajo implements Direccion {

	public void mover(Posicion posicion, Vehiculo vehiculo) {
		posicion.moverAbajo(vehiculo);
	}
}