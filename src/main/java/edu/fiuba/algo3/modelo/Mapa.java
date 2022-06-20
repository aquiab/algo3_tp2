package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modificadores.Obstaculos;
import edu.fiuba.algo3.modelo.modificadores.Sorpresas;
import edu.fiuba.algo3.modelo.modificadores.Vacio;

import java.util.LinkedList;

public class Mapa {
	protected LinkedList<LinkedList<Calle>> callesHorizontales;
	protected LinkedList<LinkedList<Calle>> callesVerticales;
	//protected Generador generador;
	protected int cantidadObstaculos;
	protected int cantidadSorpresas;
	protected int dimension;

	private Obstaculos OBSTACULOS = new Obstaculos();
	private Sorpresas SORPRESAS = new Sorpresas();
	private Vacio VACIO = new Vacio();

	Mapa(int dimension) {
		this.dimension = dimension;
		callesHorizontales = new LinkedList<>();
		callesVerticales = new LinkedList<>();
		cantidadObstaculos = dimension * 2;
		cantidadSorpresas = dimension * 2;
		for (int i=0; i < dimension; i++) {
			callesHorizontales.add(new LinkedList<Calle>());
			callesVerticales.add(new LinkedList<Calle>());
			for (int j=0; j < dimension; j++) {
				callesHorizontales.get(i).add(new Calle());
				callesVerticales.get(i).add(new Calle());
			}
		}
		llenarDeObstaculos();
		llenarDeSorpresas();
		rellenarResto();
	}

	private void rellenarResto() {
		for (int i=0; i < dimension; i++ ){
			callesHorizontales.get(i).stream().filter(s -> s.obstaculo == null).forEach(s -> s.agregarObstaculo(VACIO));
			callesVerticales.get(i).stream().filter(s -> s.obstaculo == null).forEach(s -> s.agregarObstaculo(VACIO));
			callesHorizontales.get(i).stream().filter(s -> s.sorpresa == null).forEach(s -> s.agregarSorpresa(VACIO));
			callesVerticales.get(i).stream().filter(s -> s.sorpresa == null).forEach(s -> s.agregarSorpresa(VACIO));
		}
	}

	public Calle obtenerCalleHorizontal(int x, int y) {
		return callesHorizontales.get(x).get(y);
	}

	public Calle obtenerCalleVertical(int x, int y) {
		return callesVerticales.get(x).get(y);
	}

	public int dimension() {
		return dimension;
	}

	public void llenarDeObstaculos() {
		int obstaculosAgregados = 0;
		while (obstaculosAgregados < cantidadSorpresas) {
			Posicion posicion = obtenerPosicionAleatoria(dimension);
			this.obtenerCalleVertical(posicion.x, posicion.y).agregarObstaculo(this.OBSTACULOS.devolverObstaculo());
			posicion = obtenerPosicionAleatoria(dimension);
			this.obtenerCalleHorizontal(posicion.x, posicion.y).agregarObstaculo(this.OBSTACULOS.devolverObstaculo());
			obstaculosAgregados += 2;
		}
	}

	public void llenarDeSorpresas() {
		int sorpresasAgregadas = 0;
		while (sorpresasAgregadas < cantidadSorpresas) {
			Posicion posicion = obtenerPosicionAleatoria(dimension);
			this.obtenerCalleHorizontal(posicion.x, posicion.y).agregarSorpresa(this.SORPRESAS.devolverSorpresa());
			posicion = obtenerPosicionAleatoria(dimension);
			this.obtenerCalleVertical(posicion.x, posicion.y).agregarSorpresa(this.SORPRESAS.devolverSorpresa());
			sorpresasAgregadas += 2;
		}
	}

	private Posicion obtenerPosicionAleatoria(int dimension) {
		return new Posicion((int) (Math.random() * dimension), (int) (Math.random() * dimension), this);
	}
}
