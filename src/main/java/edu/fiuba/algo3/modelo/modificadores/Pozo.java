package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;

public class Pozo implements Obstaculo {

	public void aplicar(Vehiculo vehiculo) {
		vehiculo.pasarPozo();
	}
}