package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;


public class AutoTest {
	@Test
	public void AutoEncuentraPozoTest() {
		//Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
		//arrange
		Usuario usuario = new Usuario();
		Auto auto = new Auto();
		usuario.establecerVehiculo(auto);
		Calle calle = new Calle(null, new Pozo());
		Esquina esquina1 = new Esquina();
		Esquina esquina2 = new Esquina();
		Tuple tupla1 = new Tuple(esquina1, calle);
		Tuple tupla2 = new Tuple(esquina2, calle);
		esquina1.agregarEsquinaAdyacente(tupla2, "arr");
		esquina2.agregarEsquinaAdyacente(tupla1, "ab");
		auto.asignarPosicionInicial(esquina1);

		//act
		usuario.hacerMovimiento("arr");

		//assert
		assert(auto.obtenerMovimientos() == 4);
	}
}
