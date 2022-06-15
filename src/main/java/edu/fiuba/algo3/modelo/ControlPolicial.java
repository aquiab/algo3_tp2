package edu.fiuba.algo3.modelo;

public class ControlPolicial implements Obstaculo {

	public void aplicarObstaculo(Vehiculo vehiculo) {
        vehiculo.pasarControlPolicial();
	}
}
