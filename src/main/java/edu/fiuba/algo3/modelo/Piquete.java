package edu.fiuba.algo3.modelo;

public class Piquete implements Obstaculo {

	public void aplicarObstaculo(Vehiculo vehiculo) {
		vehiculo.pasarPiquete();
	}
}
