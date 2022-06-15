package edu.fiuba.algo3.modelo;
import java.util.LinkedList;

public class Mapa {
	protected LinkedList<LinkedList<Calle>> filas;
	protected LinkedList<LinkedList<Calle>> columnas;

	Mapa(int size) {
		filas = new LinkedList<>();
		columnas = new LinkedList<>();
		for (int i=0; i < size; i++) {
			filas.add(new LinkedList<Calle>());
			columnas.add(new LinkedList<Calle>());
			for (int j=0; j < size; j++) {
				filas.get(i).add(new Calle());
				columnas.get(i).add(new Calle());
			}
		}
	}

	public Calle obtenerCalle(int x, int y, String direccion) {
		if (direccion.equals("horizontal")) {
			return filas.get(x).get(y);
		} else {
			return columnas.get(x).get(y);
		}
	}
}
