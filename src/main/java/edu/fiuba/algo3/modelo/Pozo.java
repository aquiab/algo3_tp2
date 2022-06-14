package edu.fiuba.algo3.modelo;

public class Pozo extends Obstaculo{

	private final float PENALIZACION_POR_PASAR_POZO = 3;

	@Override
	public void aplicar(Vehiculo vehiculo) {
		if (vehiculo.getClass() == Camioneta.class) {
			vehiculo.pasarPozo();
			return;
		}
		vehiculo.aumentarPuntos(PENALIZACION_POR_PASAR_POZO);
	}
}
