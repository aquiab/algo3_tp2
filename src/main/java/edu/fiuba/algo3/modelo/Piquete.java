package edu.fiuba.algo3.modelo;

public class Piquete implements Obstaculo {

	public void aplicarObstaculo(Vehiculo vehiculo) {
		aplicarObstaculo(vehiculo);
	}

	public void aplicarObstaculo(Auto auto) {
		auto.pasarPiquete();
	}
	
	public void aplicarObstaculo(Moto moto) {
		moto.pasarPiquete();
	}

	public void aplicarObstaculo(Camioneta camioneta) {
		camioneta.pasarPiquete();
	}
}
