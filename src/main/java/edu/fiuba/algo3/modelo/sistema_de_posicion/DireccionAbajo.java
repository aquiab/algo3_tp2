package edu.fiuba.algo3.modelo.sistema_de_posicion;

import edu.fiuba.algo3.modelo.Vehiculo;

public class DireccionAbajo implements Direccion {

	public void mover(Posicion posicion, Vehiculo vehiculo) {
		posicion.moverAbajo(vehiculo);
	}
}