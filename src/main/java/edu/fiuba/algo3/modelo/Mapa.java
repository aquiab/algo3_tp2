package edu.fiuba.algo3.modelo;
import java.util.LinkedList;

public class Mapa {
	protected LinkedList<LinkedList<Calle>> callesHorizontales;
	protected LinkedList<LinkedList<Calle>> callesVerticales;
	protected Generador generador;
	protected int cantidadObstaculos;
	protected int cantidadSorpresas;

	Mapa(int dimension) {
		callesHorizontales = new LinkedList<>();
		callesVerticales = new LinkedList<>();
		cantidadObstaculos = dimension * 2;
		cantidadSorpresas = dimension * 2;
		generador = new Generador();
		for (int i=0; i < dimension; i++) {
			callesHorizontales.add(new LinkedList<Calle>());
			callesVerticales.add(new LinkedList<Calle>());
			for (int j=0; j < dimension; j++) {
				callesHorizontales.get(i).add(new Calle());
				callesVerticales.get(i).add(new Calle());
			}
		}
		llenarDeObstaculos(dimension, generador);
		llenarDeSorpresas(dimension, generador);
	}

	public Calle obtenerCalleHorizontal(Posicion posicion) {
		return callesHorizontales.get(posicion.x).get(posicion.y);
	}

	public Calle obtenerCalleVertical(Posicion posicion) {
		return callesVerticales.get(posicion.x).get(posicion.y);
	}


	public void llenarDeObstaculos(int dimension, Generador generador) {
		int obstaculosAgregados = 0;
		while (obstaculosAgregados < cantidadSorpresas) {
			Posicion posicion = obtenerPosicionAleatoria(dimension);
			generador.generarObstaculo(this.obtenerCalleVertical(posicion));
			posicion = obtenerPosicionAleatoria(dimension);
			generador.generarObstaculo(this.obtenerCalleHorizontal(posicion));
			obstaculosAgregados += 2;
		}
	}

	public void llenarDeSorpresas(int dimension, Generador generador) {
		int sorpresasAgregadas = 0;
		while (sorpresasAgregadas < cantidadSorpresas) {
			Posicion posicion = obtenerPosicionAleatoria(dimension);
			generador.generarSorpresa(this.obtenerCalleVertical(posicion));
			posicion = obtenerPosicionAleatoria(dimension);
			generador.generarSorpresa(this.obtenerCalleHorizontal(posicion));
			sorpresasAgregadas += 2;
		}
	}

	private static Posicion obtenerPosicionAleatoria(int dimension) {
		return new Posicion((int) Math.random()*dimension, (int) Math.random()*dimension);
	}
}
