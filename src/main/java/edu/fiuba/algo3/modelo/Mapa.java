package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modificadores.MetaFinal;
import edu.fiuba.algo3.modelo.modificadores.Obstaculos;
import edu.fiuba.algo3.modelo.modificadores.Sorpresas;
import edu.fiuba.algo3.modelo.modificadores.Vacio;
import java.util.Random;

import javafx.geometry.Pos;

import java.util.LinkedList;

public class Mapa {
	public LinkedList<LinkedList<Calle>> callesHorizontales;
	public LinkedList<LinkedList<Calle>> callesVerticales;
	private int cantidadModificadoresIniciales;
	protected int dimension;

	private Obstaculos OBSTACULOS = new Obstaculos();
	private Sorpresas SORPRESAS = new Sorpresas();
	private Vacio VACIO = new Vacio();

	Mapa(int dimension) {
		this.dimension = dimension;
		callesHorizontales = new LinkedList<>();
		callesVerticales = new LinkedList<>();
		cantidadModificadoresIniciales = dimension * 2;
		for (int i=0; i < dimension; i++) {
			callesHorizontales.add(new LinkedList<Calle>());
			callesVerticales.add(new LinkedList<Calle>());
			for (int j=0; j < dimension; j++) {
				callesHorizontales.get(i).add(new Calle());
				callesVerticales.get(i).add(new Calle());
			}
		}
		agregarObstaculos(cantidadModificadoresIniciales);
		agregarSorpresas(cantidadModificadoresIniciales);
		agregarMeta();
		liberarElRestoDelMapa();
	}

	private void liberarElRestoDelMapa() {
		for (int i=0; i < dimension; i++){
			callesHorizontales.get(i).stream().filter(calle -> calle.obstaculo == null).forEach(calle -> calle.agregarObstaculo(VACIO));
			callesVerticales.get(i).stream().filter(calle -> calle.obstaculo == null).forEach(calle -> calle.agregarObstaculo(VACIO));
			callesHorizontales.get(i).stream().filter(calle -> calle.sorpresa == null).forEach(calle -> calle.agregarSorpresa(VACIO));
			callesVerticales.get(i).stream().filter(calle -> calle.sorpresa == null).forEach(calle -> calle.agregarSorpresa(VACIO));
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

	public void agregarObstaculos(Integer cantidadObstaculos) {
		int obstaculosAgregados = 0;
		while (obstaculosAgregados < cantidadObstaculos) {
			Posicion posicion = obtenerPosicionAleatoria(dimension);
			this.obtenerCalleVertical(posicion.x, posicion.y).agregarObstaculo(this.OBSTACULOS.devolverObstaculo());
			posicion = obtenerPosicionAleatoria(dimension);
			this.obtenerCalleHorizontal(posicion.x, posicion.y).agregarObstaculo(this.OBSTACULOS.devolverObstaculo());
			obstaculosAgregados += 2;
		}
	}

	public void agregarSorpresas(Integer cantidadSorpresas) {
		int sorpresasAgregadas = 0;
		while (sorpresasAgregadas < cantidadSorpresas) {
			Posicion posicion = obtenerPosicionAleatoria(dimension);
			this.obtenerCalleHorizontal(posicion.x, posicion.y).agregarSorpresa(this.SORPRESAS.devolverSorpresa());
			posicion = obtenerPosicionAleatoria(dimension);
			this.obtenerCalleVertical(posicion.x, posicion.y).agregarSorpresa(this.SORPRESAS.devolverSorpresa());
			sorpresasAgregadas += 2;
		}
	}

	public void agregarMeta() {
		Random rand = new Random();
		this.obtenerCalleHorizontal(dimension-1, rand.nextInt(dimension)).agregarMeta(new MetaFinal());
	}

	private Posicion obtenerPosicionAleatoria(int dimension) {
		return new Posicion((int) (Math.random() * dimension), (int) (Math.random() * dimension), this);
	}
}
