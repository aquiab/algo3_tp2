package edu.fiuba.algo3.modelo;

public class Posicion {

	//El mapa es un cuadrado, por lo tanto comparte los límites izq/sup y los der/inf.
	private static final Integer LIMITE_IZQUIERDO_O_SUPERIOR_MAPA = 0;
	private Integer limiteDerechoInferiorMapa;
	private int x;
	private int y;
	private int sigX;
	private int sigY;
	private Mapa mapa;
	public Posicion(int x, int y, Mapa mapa) {
		this.limiteDerechoInferiorMapa = mapa.dimension() - 1;
		this.x = x;
		this.y = y;
		this.mapa = mapa;
	}

	private boolean dentroDeLimites(int coordenada) {
		return (coordenada >= LIMITE_IZQUIERDO_O_SUPERIOR_MAPA && coordenada < limiteDerechoInferiorMapa);
	}
	public void establecerSig(int x, int y) {
		this.sigX = this.x + x;
		this.sigY = this.y + y;
	}
	public void defaultearSig() {
		this.sigX = x;
		this.sigY = y;
	}
	public void modificarPosicion() {
		if (dentroDeLimites(this.sigX) && dentroDeLimites(this.sigY)) {
			this.x = this.sigX;
			this.y = this.sigY;
		}
	}
	public void moverArriba(Vehiculo vehiculo) {
		establecerSig(0, -1);
		Calle calle = mapa.obtenerCalleVertical(x, y);
		calle.recorrer(vehiculo);
		modificarPosicion();
	}
	public void moverAbajo(Vehiculo vehiculo) {
		establecerSig(0, 1);
		Calle calle = mapa.obtenerCalleVertical(x, y+1);
		calle.recorrer(vehiculo);
		modificarPosicion();
	}
	public void moverDerecha(Vehiculo vehiculo) {
		establecerSig(1, 0);
		Calle calle = mapa.obtenerCalleHorizontal(x+1, y);
		calle.recorrer(vehiculo);
		modificarPosicion();
	}
	public void moverIzquierda(Vehiculo vehiculo) {
		establecerSig(-1, 0);
		Calle calle = mapa.obtenerCalleHorizontal(x, y);
		calle.recorrer(vehiculo);
		modificarPosicion();
	}

	public int obtenerCoordenadaX() {
		return this.x;
	}

	public int obtenerCoordenadaY() {
		return this.y;
	}
}
