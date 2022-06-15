package edu.fiuba.algo3.modelo;
import java.util.Random;

public class ControlPolicial extends Obstaculo {
	Random rand = new Random();

    public void aplicarObstaculo(Vehiculo vehiculo) {
		vehiculo.pasarControlPolicial();
	}

}
