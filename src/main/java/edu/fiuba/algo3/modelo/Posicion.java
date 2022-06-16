package edu.fiuba.algo3.modelo;

public class Posicion {
	private int x;
	private int y;
	Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean dentroDeLimites(Mapa mapa) {
		return true;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

}
