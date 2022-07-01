package edu.fiuba.algo3.modelo.sistema_de_posicion;

import edu.fiuba.algo3.modelo.Vehiculo;

public class DireccionIzquierda implements Direccion {
	public void mover(Posicion posicion, Vehiculo vehiculo) {
		posicion.moverIzquierda(vehiculo);
	}
}