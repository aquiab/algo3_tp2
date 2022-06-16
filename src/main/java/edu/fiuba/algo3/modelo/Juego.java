package edu.fiuba.algo3.modelo;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {
	int mapSize = ThreadLocalRandom.current().nextInt(10, 20);
	public Mapa mapa = new Mapa(mapSize);
	Vehiculo vehiculo = new Vehiculo(0, new Posicion(0, 0));

	//Juego(Vehiculo vehiculo) {
	//	this.vehiculo = vehiculo;
	//}

	public void mover(Direccion direccion) {
		this.vehiculo.mover(direccion);
	}
}