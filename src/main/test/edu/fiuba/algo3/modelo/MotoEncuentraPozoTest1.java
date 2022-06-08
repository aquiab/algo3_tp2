package edu.fiuba.algo3.modelo;

public class MotoEncuentraPozoTest1 {
	//Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
	//arrange
	Moto moto = new Moto();
	Calle calle = new Calle(null, new Pozo());
	Esquina esquina1 = new Esquina();
	Esquina esquina2 = new Esquina();
	Tuple tupla1 = new Tuple(esquina1, calle);
	Tuple tupla2 = new Tuple(esquina2, calle);
	String str = "arr";
	esquina1.modificarDiccionario(str, tupla2);
	//moto.asignarPosicionInicial(esquina1);
}
