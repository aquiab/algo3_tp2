package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;


public class AutoTest {
	@Test
	public void AutoEncuentraPozoTest() {
		//Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
		//arrange
		Juego juego = new Juego(new Auto(0, new Posicion(0,0)));
		//act
		juego.mover(new DireccionDerecha(juego.mapa));

		//assert
		assert(juego.vehiculo.movimientos == 4);
	}
}
