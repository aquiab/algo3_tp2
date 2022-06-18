package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

public class AutoTest {
	@Test
	public void AutoEncuentraPozoTest() {
		//Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
		//arrange
		Juego juego = new Juego();
		juego.aplicarEstado(new Auto(juego.vehiculo));
		juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Pozo());
		//act
		juego.mover(new DireccionDerecha());

		//assert
		assert(juego.vehiculo.movimientos == 4);
	}
	@Test
	public void AutoEncuentraPiqueteTest() {
		//arrange
		Juego juego = new Juego();
		juego.aplicarEstado(new Auto(juego.vehiculo));
		juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Piquete());
		//act
		juego.mover(new DireccionDerecha());
		//assert
		assert(juego.vehiculo.posicion.x == 0);
		assert(juego.vehiculo.posicion.y == 0);
		assert(juego.vehiculo.movimientos == 1);
	}
	@Test
	public void AutoEncuentraPiqueteYPozoTest() {
		//arrange
		Juego juego = new Juego();
		juego.aplicarEstado(new Auto(juego.vehiculo));
		juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Pozo());
		juego.mapa.callesHorizontales.get(2).get(0).agregarObstaculo(new Piquete());
		//act
		juego.mover(new DireccionDerecha());
		juego.mover(new DireccionDerecha());
		//assert
		assert(juego.vehiculo.posicion.x == 1);
		assert(juego.vehiculo.posicion.y == 0);
		assert(juego.vehiculo.movimientos == 5);
	}

	@Test
	public void AutoEncuentraSorpresaCambioVehiculo() {
		//arrange
		Juego juego = new Juego();
		juego.aplicarEstado(new Auto(juego.vehiculo));
		juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new SorpresaVehiculo());
		//act
		juego.mover(new DireccionDerecha());
		//assert
		assert(juego.vehiculo.posicion.x == 1);
		assert(juego.vehiculo.posicion.y == 0);
		assert(juego.vehiculo.movimientos == 1);
		assert(juego.vehiculo.estado.getClass() == Camioneta.class);
	}
}
