package edu.fiuba.algo3.modelo;

public class DireccionDerecha implements Direccion {
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		posicion.moverDerecha(vehiculo);
	}
}