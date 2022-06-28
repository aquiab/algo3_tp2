package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;

public class ControlPolicial implements Obstaculo {

	public void pasar(Vehiculo vehiculo) {
		vehiculo.pasarControlPolicial();
	}
}
