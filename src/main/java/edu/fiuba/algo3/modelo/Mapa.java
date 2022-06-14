package edu.fiuba.algo3.modelo;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {
	public LinkedList<LinkedList<Calle>> filas;
	public LinkedList<LinkedList<Calle>> columnas;
	private int size;

	Mapa() {
		size = ThreadLocalRandom.current().nextInt(10, 20);
		filas = new LinkedList<LinkedList<Calle>>();
		columnas = new LinkedList<LinkedList<Calle>>();
		for (int i=0; i < size; i++) {
			filas.add(new LinkedList<Calle>());
			columnas.add(new LinkedList<Calle>());
			for (int j=0; j < size; j++) {
				filas.get(i).add(new Calle(null, null));
				columnas.get(i).add(new Calle(null, null));
			}
		}
	}
}
