package edu.fiuba.algo3.modelo;

public class ControlPolicial implements Modificador {

	public void aplicar(Vehiculo vehiculo) {
		vehiculo.pasarControlPolicial();
	}
}
