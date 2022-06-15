package edu.fiuba.algo3.modelo;

public class Piquete extends Obstaculo {

	public void aplicarObstaculo(Vehiculo vehiculo) {
		vehiculo.pasarPiquete();
	}
}
