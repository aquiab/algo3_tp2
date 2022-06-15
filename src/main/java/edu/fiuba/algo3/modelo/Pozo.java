package edu.fiuba.algo3.modelo;

public class Pozo implements Obstaculo {

	public void aplicarObstaculo(Vehiculo vehiculo) {
		aplicarObstaculo(vehiculo);
	}

	public void aplicarObstaculo(Auto auto) {
		auto.pasarPozo();
	}
	
	public void aplicarObstaculo(Moto moto) {
		moto.pasarPozo();
	}

	public void aplicarObstaculo(Camioneta camioneta) {
		camioneta.pasarPozo();
	}
}
