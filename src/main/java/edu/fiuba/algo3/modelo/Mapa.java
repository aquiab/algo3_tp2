package edu.fiuba.algo3.modelo;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {
	public LinkedList<LinkedList<Calle>> callesHorizontales;
	public LinkedList<LinkedList<Calle>> callesVerticales;
	Mapa() {
		int size = ThreadLocalRandom.current().nextInt(10, 20);
		callesHorizontales = new LinkedList<LinkedList<Calle>>();
		callesVerticales = new LinkedList<LinkedList<Calle>>();
		for (int i=0; i < size; i++) {
			callesHorizontales.add(new LinkedList<Calle>());
			callesVerticales.add(new LinkedList<Calle>());
			for (int j=0; j < size; j++) {
				callesHorizontales.get(i).add(new Calle(null, null));
				callesVerticales.get(i).add(new Calle(null, null));
			}
		}
	}
}
