package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

public class MotoTest {
	@Test
	public void MotoEncuentraPozoTest() {
		//Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
		//arrange
		Usuario usuario = new Usuario();
		Moto moto = new Moto();
		usuario.establecerVehiculo(moto);
		Calle calle = new Calle(null, new Pozo());
		Esquina esquina1 = new Esquina();
		Esquina esquina2 = new Esquina();
		Tuple tupla1 = new Tuple(esquina1, calle);
		Tuple tupla2 = new Tuple(esquina2, calle);
		esquina1.agregarEsquinaAdyacente(tupla2, "arr");
		esquina2.agregarEsquinaAdyacente(tupla1, "ab");
		moto.asignarPosicionInicial(esquina1);

		//act
		usuario.hacerMovimiento("arr");

		//assert
		assert(moto.obtenerMovimientos() == 4);
	}

	@Test
	public void motoSeMueveLibrementeEntreCallesVaciasSumaUnMovimiento() {
		Usuario conductor = new Usuario();
		Moto moto = new Moto();
		conductor.establecerVehiculo(moto);
		Calle calle = new Calle(null, new Libre());

		Esquina esquinaA0 = new Esquina();
		Esquina esquinaA1 = new Esquina();
		Tuple direccionA0 = new Tuple(esquinaA0, calle);
		Tuple direccionA1 = new Tuple(esquinaA1, calle);

		//Enlazo las esquinas entre sí.
		esquinaA0.agregarEsquinaAdyacente(direccionA1, "a1");
		esquinaA1.agregarEsquinaAdyacente(direccionA0, "a0");

		//Ida
		moto.asignarPosicionInicial(esquinaA0);
		conductor.hacerMovimiento("a1");
		assert (moto.obtenerPosicionActual() == esquinaA1);
		assert (moto.obtenerMovimientos() == 1);

		//Vuelta
		conductor.hacerMovimiento("a0");
		assert (moto.obtenerPosicionActual() == esquinaA0);
		assert (moto.obtenerMovimientos() == 2);
	}
	
}
