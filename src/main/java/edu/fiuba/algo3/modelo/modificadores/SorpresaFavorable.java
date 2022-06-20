package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;

public class SorpresaFavorable implements Sorpresa {
	public void aplicar(Vehiculo vehiculo) {
		vehiculo.aplicarSorpresaFavorable();
	}
}
