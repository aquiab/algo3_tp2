package edu.fiuba.algo3.modelo;

public class MotoEncuentraPozoTest1 {
	//Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
	//arrange
	Moto moto = new Moto();
	Calle calle = new Calle(null, new Pozo());
	Esquina esquina1 = new Esquina(null, null, null, null);
	Tuple tupla1 = new Tuple(esquina1, calle);
	Esquina esquina2 = new Esquina(tupla1, null, null, null);
	moto.asignarPosicionInicial(esquina);
}
