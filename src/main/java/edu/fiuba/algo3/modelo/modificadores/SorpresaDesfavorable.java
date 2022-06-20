package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;

public class SorpresaDesfavorable implements Sorpresa {
	public void aplicar(Vehiculo vehiculo) {
		vehiculo.aplicarSorpresaDesfavorable();
	}
}

