package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.*;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.*;

import java.util.LinkedList;

public class Mapa {
	public LinkedList<LinkedList<Calle>> callesHorizontales;
	public LinkedList<LinkedList<Calle>> callesVerticales;
	protected int dimension;

	private VacioObstaculo VACIO_OBSTACULO = new VacioObstaculo();
	private VacioSorpresa VACIO_SORPRESA = new VacioSorpresa();

	Mapa(int dimension) {
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
		incializarMapa();
	}

	private void incializarMapa() {
		for (int i=0; i < dimension; i++){
			callesHorizontales.get(i).stream().filter(calle -> calle.obstaculo == null).forEach(calle -> calle.agregarObstaculo(VACIO_OBSTACULO));
			callesVerticales.get(i).stream().filter(calle -> calle.obstaculo == null).forEach(calle -> calle.agregarObstaculo(VACIO_OBSTACULO));
			callesHorizontales.get(i).stream().filter(calle -> calle.sorpresa == null).forEach(calle -> calle.agregarSorpresa(VACIO_SORPRESA));
			callesVerticales.get(i).stream().filter(calle -> calle.sorpresa == null).forEach(calle -> calle.agregarSorpresa(VACIO_SORPRESA));
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

	public int obtenerMetaY() {
		for (int i = 0; i < dimension; i++) if (obtenerCalleHorizontal(dimension-1, i).sorpresa.getClass() == Meta.class) return i;
		return 0;
	}


	private Posicion obtenerPosicionAleatoria(int dimension) {
		return new Posicion((int) (Math.random() * (dimension - 1)), (int) (Math.random() * (dimension - 1)), this);
	}

    public int cantidadObstaculos() {
		int contador = 0;
		for (int i=0; i < dimension; i++){
			contador += callesHorizontales.get(i).stream().filter(calle -> calle.obstaculo.getClass() != VacioObstaculo.class).count();
			contador += callesVerticales.get(i).stream().filter(calle -> calle.obstaculo.getClass() != VacioObstaculo.class).count();
			}
		return contador;
    }

	public int cantidadSorpresa() {
		int contador = 0;
		for (int i=0; i < dimension; i++){
			contador += callesHorizontales.get(i).stream().filter(calle -> calle.sorpresa.getClass() != VacioSorpresa.class).count();
			contador += callesVerticales.get(i).stream().filter(calle -> calle.sorpresa.getClass() != VacioSorpresa.class).count();
		}
		return contador;
	}

	public int cantidadMeta() {
		int contador = 0;
		for (int i=0; i < dimension; i++){
			contador += callesHorizontales.get(i).stream().filter(calle -> calle.sorpresa.getClass() == Meta.class).count();
			contador += callesVerticales.get(i).stream().filter(calle -> calle.sorpresa.getClass() == Meta.class).count();
		}
		return contador;
	}

}