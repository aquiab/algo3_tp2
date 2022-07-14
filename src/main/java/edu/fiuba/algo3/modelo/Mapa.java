package edu.fiuba.algo3.modelo;
import java.util.LinkedList;

public class Mapa {
	private LinkedList<LinkedList<Calle>> callesHorizontales;
	private LinkedList<LinkedList<Calle>> callesVerticales;
	protected int dimension;

	public Mapa(int dimension) {
		this.dimension = dimension;
		callesHorizontales = new LinkedList<>();
		callesVerticales = new LinkedList<>();
		for (int i=0; i < dimension; i++) {
			callesHorizontales.add(new LinkedList<Calle>());
			callesVerticales.add(new LinkedList<Calle>());
			for (int j=0; j < dimension; j++) {
				callesHorizontales.get(i).add(new Calle());
				callesVerticales.get(i).add(new Calle());
			}
		}
	}

	public Calle obtenerCalleHorizontal(int x, int y) {
		return callesHorizontales.get(x).get(y);
	}

	public Calle obtenerCalleVertical(int x, int y) {
		return callesVerticales.get(x).get(y);
	}

	public LinkedList<LinkedList<Calle>> getCallesHorizontales() {
		return callesHorizontales;
	}

	public LinkedList<LinkedList<Calle>> getCallesVerticales() {
		return callesVerticales;
	}

	public int dimension() {
		return dimension;
	}

}