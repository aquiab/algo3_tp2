package edu.fiuba.algo3.modelo;

public class Pozo implements Modificador {

	public void aplicar(Vehiculo vehiculo) {
		vehiculo.pasarPozo();
	}
}
