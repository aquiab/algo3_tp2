package edu.fiuba.algo3.modelo;

public class SorpresaVehiculo implements Modificador {
	public void aplicar(Vehiculo vehiculo) {
		vehiculo.aplicarSorpresaCambioVehiculo();
	}
}
