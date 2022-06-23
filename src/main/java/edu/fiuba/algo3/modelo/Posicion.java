package edu.fiuba.algo3.modelo;

public class Posicion {

	//El mapa es un cuadrado, por lo tanto comparte los límites izq/sup y los der/inf.
	private static final Integer LIMITE_IZQUIERDO_O_SUPERIOR_MAPA = 0;
	private Integer limiteDerechoInferiorMapa;
	public int x;
	public int y;
	Paso paso = new PasoAbierto();
	Mapa mapa;
	Posicion(int x, int y, Mapa mapa) {
		this.limiteDerechoInferiorMapa = mapa.dimension() - 1;
		this.x = x;
		this.y = y;
		this.mapa = mapa;
	}

	public void modificarPaso(Paso paso) {
		this.paso = paso;
	}

	private boolean dentroDeLimites(int coordenada) {
		return (coordenada >= LIMITE_IZQUIERDO_O_SUPERIOR_MAPA && coordenada < limiteDerechoInferiorMapa);
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
