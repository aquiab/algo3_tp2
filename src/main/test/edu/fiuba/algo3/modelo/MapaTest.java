package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

public class MapaTest {
	@Test
	public void seCreaMapa() {
		Mapa mapa = new Mapa(10);
		System.out.print(mapa.filas);
		System.out.print(mapa.obtenerCalle(1, 1, "horizontal"));
	}
}
