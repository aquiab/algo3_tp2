package edu.fiuba.algo3.modelo;
import java.util.Random;

public class ControlPolicial implements Obstaculo {
	Random rand = new Random();

    public void aplicarObstaculo(Vehiculo vehiculo) {
		aplicarObstaculo(vehiculo);
	}

	public void aplicarObstaculo(Auto auto) {
        if (rand.nextInt(10) <= 4) {
            auto.pasarControlPolicial();
        }
	}
	
	public void aplicarObstaculo(Moto moto) {
        if (rand.nextInt(10) <= 7) {
            moto.pasarControlPolicial();
        }
	}

	public void aplicarObstaculo(Camioneta camioneta) {
        if (rand.nextInt(10) <= 2) {
            camioneta.pasarControlPolicial();
        }
	}
}
