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
		usuario.hacerMovimiento("arr");

		//Agregar supuesto al informe con cantidad total x+1 (y los piquetes que también suman movimiento).
		assert(moto.movimientos == 4);
	}
	
}
