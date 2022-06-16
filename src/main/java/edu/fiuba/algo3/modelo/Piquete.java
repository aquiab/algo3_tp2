package edu.fiuba.algo3.modelo;

public class Piquete implements Modificador {

	public void aplicar(Vehiculo vehiculo) {
		vehiculo.pasarPiquete();
	}
}
