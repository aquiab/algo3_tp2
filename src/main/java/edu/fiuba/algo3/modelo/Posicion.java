package edu.fiuba.algo3.modelo;

public class Posicion {
	public int x;
	public int y;
	Paso paso = new PasoAbierto();
	Mapa mapa;
	Posicion(int x, int y, Mapa mapa) {
		this.x = x;
		this.y = y;
		this.mapa = mapa;

	}

	public boolean dentroDeLimites(Mapa mapa) {
		return true;
	}

	public void modificarPaso(Paso paso) {
		this.paso = paso;
	}

	public void modificarX(int x) {
		this.x = x;
	}

	public void modificarY(int y) {
		this.y = y;
	}

	public void moverArriba(Vehiculo vehiculo) {
		Calle calle = mapa.obtenerCalleVertical(x, y);
		calle.recorrer(vehiculo);
		paso.modificarPosicion(this, x, y-1);
	}
	public void moverAbajo(Vehiculo vehiculo) {
		Calle calle = mapa.obtenerCalleVertical(x, y+1);
		calle.recorrer(vehiculo);
		paso.modificarPosicion(this, x, y+1);
	}
	public void moverDerecha(Vehiculo vehiculo) {
		Calle calle = mapa.obtenerCalleHorizontal(x+1, y);
		calle.recorrer(vehiculo);
		paso.modificarPosicion(this, x+1, y);
	}
	public void moverIzquierda(Vehiculo vehiculo) {
		Calle calle = mapa.obtenerCalleHorizontal(x, y);
		calle.recorrer(vehiculo);
		paso.modificarPosicion(this, x, y+1);
	}

}
