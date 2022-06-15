package edu.fiuba.algo3.modelo;

public abstract class Direccion {
	public abstract void mover(Posicion posicion, Vehiculo vehiculo);
	public abstract Calle obtenerCalle(Posicion posicion);
	Mapa mapa;
	Direccion (Mapa mapa) {
		this.mapa = mapa;
	}
}
