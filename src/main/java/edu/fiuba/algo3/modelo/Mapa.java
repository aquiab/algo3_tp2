package edu.fiuba.algo3.modelo;
import java.util.LinkedList;

public class Mapa {
	protected LinkedList<LinkedList<Calle>> callesHorizontales;
	protected LinkedList<LinkedList<Calle>> callesVerticales;

	Mapa(int size) {
		callesHorizontales = new LinkedList<>();
		callesVerticales = new LinkedList<>();
		for (int i=0; i < size; i++) {
			callesHorizontales.add(new LinkedList<Calle>());
			callesVerticales.add(new LinkedList<Calle>());
			for (int j=0; j < size; j++) {
				callesHorizontales.get(i).add(new Calle());
				callesVerticales.get(i).add(new Calle());
			}
		}
	}

	public static Mapa generarMapa(int dimension) {
		Mapa mapa = new Mapa(dimension);
		Generador generador = new Generador();

		mapa.llenarDeObstaculos(dimension, generador);
		mapa.llenarDeSorpresas(dimension, generador);
		return mapa;
	}

	public Calle obtenerCalleHorizontal(Posicion posicion) {
		return callesHorizontales.get(posicion.x()).get(posicion.y());
	}

	public Calle obtenerCalleVertical(Posicion posicion) {
		return callesVerticales.get(posicion.x()).get(posicion.y());
	}


	public void llenarDeObstaculos(int dimension, Generador generador) {
		while (this.cantidadObstaculos(this.callesVerticales) < dimension) {
			int[] posiciones = obtenerPosicionesAleatorias(dimension);
			generador.generarObstaculo(this.obtenerCalleVertical(new Posicion(posiciones[0], posiciones[1])));
			posiciones = obtenerPosicionesAleatorias(dimension);
			generador.generarObstaculo(this.obtenerCalleHorizontal(new Posicion(posiciones[0], posiciones[1])));
		}
	}

	public void llenarDeSorpresas(int dimension, Generador generador) {
		while (this.cantidadSorpresas(this.callesVerticales) < dimension) {
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




	//-----------------
	public int cantidadObstaculos(LinkedList<LinkedList<Calle>> lista) {
		//saber cuantos hay.
		int cantidad = 0;
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.size(); j++) {
				if ((lista.get(i).get(j)).obstaculo != null){
					cantidad++;
				}
			}
		}
		return cantidad;
	}

	private int cantidadSorpresas(LinkedList<LinkedList<Calle>> lista) {
		int cantidad = 0;
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.size(); j++) {
				if ((lista.get(i).get(j)).sorpresa != null){
					cantidad++;
				}
			}
		}
		return cantidad;
	}

	public void printear(LinkedList<LinkedList<Calle>> lista) {
		//Borrar
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.size(); j++) {
				System.out.println("--");
				System.out.println(lista.get(i).get(j).obstaculo);
				System.out.println(lista.get(i).get(j).sorpresa);
			}
		}
	}
}
