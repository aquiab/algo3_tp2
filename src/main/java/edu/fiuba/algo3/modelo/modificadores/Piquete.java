package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;

public class Piquete implements Obstaculo {

	public void aplicar(Vehiculo vehiculo) {
		vehiculo.pasarPiquete();
	}
}