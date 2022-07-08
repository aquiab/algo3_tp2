package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.obstaculos.*;
import edu.fiuba.algo3.modelo.sorpresas.*;

import java.util.LinkedList;

public class Mapa {
	public LinkedList<LinkedList<Calle>> callesHorizontales;
	public LinkedList<LinkedList<Calle>> callesVerticales;
	protected int dimension;

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

	// eliminar

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