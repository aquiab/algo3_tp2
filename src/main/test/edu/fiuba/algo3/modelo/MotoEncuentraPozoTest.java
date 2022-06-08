package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

public class MotoEncuentraPozoTest {
	//Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
	
	@Test
	public void Test1() {
		//arrange
		Usuario usuario = new Usuario();
		Moto moto = new Moto();
		usuario.vehiculo = moto;
		Calle calle = new Calle(null, new Pozo());
		Esquina esquina1 = new Esquina();
		Esquina esquina2 = new Esquina();
		Tuple tupla1 = new Tuple(esquina1, calle);
		Tuple tupla2 = new Tuple(esquina2, calle);
		esquina1.modificarDiccionario(tupla2, "arr");
		esquina2.modificarDiccionario(tupla1, "ab");
		moto.asignarPosicionInicial(esquina1);
		usuario.hacerMovimiento("arr");
		assert(moto.movimientos == 3);
	}
	
}