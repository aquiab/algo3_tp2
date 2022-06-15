package edu.fiuba.algo3.modelo;

public class Pozo implements Obstaculo {

	public void aplicarObstaculo(Vehiculo vehiculo) {
		vehiculo.pasarPozo();
	}
}
