package edu.fiuba.algo3.modelo;

public class Posicion {
	public int x;
	public int y;
	Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean dentroDeLimites(Mapa mapa) {
		return true;
	}
}
