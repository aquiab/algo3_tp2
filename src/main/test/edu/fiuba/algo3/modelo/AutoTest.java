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
		juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(null);
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
		juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(null);
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
		juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(null);
		juego.mapa.callesHorizontales.get(2).get(0).agregarSorpresa(null);
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
		juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(null);
		//act
		juego.mover(new DireccionDerecha());
		//assert
		assert(juego.vehiculo.posicion.x == 1);
		assert(juego.vehiculo.posicion.y == 0);
		assert(juego.vehiculo.movimientos == 1);
		assert(juego.vehiculo.estado.getClass() == Camioneta.class);
	}
	@Test
	public void AutoEncuentraSorpresaFavorable() {
		//arrange
		Juego juego = new Juego();
		juego.aplicarEstado(new Auto(juego.vehiculo));
		juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new SorpresaFavorable());
		juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(null);
		//act
		juego.mover(new DireccionDerecha());
		//assert
		assert(juego.vehiculo.posicion.x == 1);
		assert(juego.vehiculo.posicion.y == 0);
		assert(juego.vehiculo.movimientos == 0.8);
		assert(juego.vehiculo.estado.getClass() == Auto.class);
	}
	@Test
	public void AutoEncuentraSorpresaDesavorable() {
		//arrange
		Juego juego = new Juego();
		juego.aplicarEstado(new Auto(juego.vehiculo));
		juego.mapa.callesVerticales.get(0).get(1).agregarSorpresa(new SorpresaDesfavorable());
		juego.mapa.callesVerticales.get(0).get(1).agregarObstaculo(null);
		//act
		juego.mover(new DireccionAbajo());
		//assert
		assert(juego.vehiculo.posicion.x == 0);
		assert(juego.vehiculo.posicion.y == 1);
		assert(juego.vehiculo.movimientos == 1.25);
		assert(juego.vehiculo.estado.getClass() == Auto.class);
	}
	@Test
	public void AutoEncuentraSorpresaCambioVehiculo3Veces() {
		//arrange
		Juego juego = new Juego();
		juego.aplicarEstado(new Auto(juego.vehiculo));
		juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new SorpresaVehiculo());
		juego.mapa.callesHorizontales.get(2).get(0).agregarSorpresa(new SorpresaVehiculo());
		juego.mapa.callesHorizontales.get(3).get(0).agregarSorpresa(new SorpresaVehiculo());
		juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(null);
		juego.mapa.callesHorizontales.get(2).get(0).agregarObstaculo(null);
		juego.mapa.callesHorizontales.get(3).get(0).agregarObstaculo(null);
		//act
		juego.mover(new DireccionDerecha());
		juego.mover(new DireccionDerecha());
		juego.mover(new DireccionDerecha());
		//assert
		assert(juego.vehiculo.posicion.x == 3);
		assert(juego.vehiculo.posicion.y == 0);
		assert(juego.vehiculo.movimientos == 3);
		assert(juego.vehiculo.estado.getClass() == Auto.class);
	}
	@Test
	public void AutoEncuentraSorpresaCambioVehiculo2veces() {
		//arrange
		Juego juego = new Juego();
		juego.aplicarEstado(new Auto(juego.vehiculo));
		juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new SorpresaVehiculo());
		juego.mapa.callesHorizontales.get(2).get(0).agregarSorpresa(new SorpresaVehiculo());
		juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(null);
		juego.mapa.callesHorizontales.get(2).get(0).agregarObstaculo(null);
		//act
		juego.mover(new DireccionDerecha());
		juego.mover(new DireccionDerecha());
		//assert
		assert(juego.vehiculo.posicion.x == 2);
		assert(juego.vehiculo.posicion.y == 0);
		assert(juego.vehiculo.movimientos == 2);
		assert(juego.vehiculo.estado.getClass() == Moto.class);
	}
}