package edu.fiuba.algo3.modelo;

public class DireccionArriba implements Direccion {
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		posicion.moverArriba(vehiculo);
	}
}
