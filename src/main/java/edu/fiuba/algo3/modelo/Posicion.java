package edu.fiuba.algo3.modelo;

public class Posicion {
	public int x;
	public int y;
	boolean bloqueo = false;
	Mapa mapa;
	Posicion(int x, int y, Mapa mapa) {
		this.x = x;
		this.y = y;
		this.mapa = mapa;

	}

	public boolean dentroDeLimites(Mapa mapa) {
		return true;
	}

	public void moverArriba(Vehiculo vehiculo) {
		Calle calle = this.mapa.obtenerCalleVertical(x, y);
		calle.recorrer(vehiculo);
		if (!bloqueo) {y -= 1;}
		bloqueo = false;
	}
	public void moverAbajo(Vehiculo vehiculo) {
		Calle calle = this.mapa.obtenerCalleVertical(x, y+1);
		calle.recorrer(vehiculo);
		if (!bloqueo) {y += 1;}
		bloqueo = false;
	}
	public void moverDerecha(Vehiculo vehiculo) {
		Calle calle = this.mapa.obtenerCalleHorizontal(x+1, y);
		calle.recorrer(vehiculo);
		if (!bloqueo) {x += 1;}
		bloqueo = false;
	}
	public void moverIzquierda(Vehiculo vehiculo) {
		Calle calle = this.mapa.obtenerCalleHorizontal(x, y);
		calle.recorrer(vehiculo);
		if (!bloqueo) {x -= 1;}
		bloqueo = false;
	}

}
