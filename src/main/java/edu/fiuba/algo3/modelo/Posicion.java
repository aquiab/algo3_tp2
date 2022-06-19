package edu.fiuba.algo3.modelo;

public class Posicion {
	protected int x;
	protected int y;
	Paso paso = new PasoAbierto();
	Mapa mapa;
	Posicion(int x, int y, Mapa mapa) {
		this.x = x;
		this.y = y;
		this.mapa = mapa;
	}

	public void modificarPaso(Paso paso) {
		this.paso = paso;
	}

	private boolean dentroDeLimites(int coordenada) {
		return (coordenada >= 0 && coordenada < mapa.dimension() - 1);
	}

	public void modificarX(int x) {
		if (dentroDeLimites(x)) {
			this.x = x;
		}
	}

	public void modificarY(int y) {
		if (dentroDeLimites(y)) {
			this.y = y;
		}
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
		paso.modificarPosicion(this, x-1, y);
	}
}
