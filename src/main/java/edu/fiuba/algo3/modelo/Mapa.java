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
		return callesHorizontales.get(posicion.x()).get(posicion.y());
	}

	public Calle obtenerCalleVertical(Posicion posicion) {
		return callesVerticales.get(posicion.x()).get(posicion.y());
	}


	public void llenarDeObstaculos(int dimension, Generador generador) {
		int obstaculosAgregados = 0;
		while (obstaculosAgregados < cantidadObstaculos) {
			int[] posiciones = obtenerPosicionesAleatorias(dimension);
			generador.generarObstaculo(this.obtenerCalleVertical(new Posicion(posiciones[0], posiciones[1])));
			posiciones = obtenerPosicionesAleatorias(dimension);
			generador.generarObstaculo(this.obtenerCalleHorizontal(new Posicion(posiciones[0], posiciones[1])));
		}
	}

	public void llenarDeSorpresas(int dimension, Generador generador) {
		int sorpresasAgregadas = 0;
		while (sorpresasAgregadas < cantidadSorpresas) {
			int[] posiciones = obtenerPosicionesAleatorias(dimension);
			generador.generarSorpresa(this.obtenerCalleVertical(new Posicion(posiciones[0], posiciones[1])));
			posiciones = obtenerPosicionesAleatorias(dimension);
			generador.generarSorpresa(this.obtenerCalleHorizontal(new Posicion(posiciones[0], posiciones[1])));
		}
	}

	private static int[] obtenerPosicionesAleatorias(int dimension) {
		int[] res = {0, 0};
		res[0] = (int)(Math.random()*dimension);
		res[1] = (int)(Math.random()*dimension);
		return res;
	}

	public void insertarEn(int fil, int col, Modificador mod) {
        obtenerCalleHorizontal(new Posicion(fil, col)).agregarObstaculo(mod);
    }
}
