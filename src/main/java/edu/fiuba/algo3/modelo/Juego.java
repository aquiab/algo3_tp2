package edu.fiuba.algo3.modelo;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {
	int mapSize = ThreadLocalRandom.current().nextInt(10, 20);
	public Mapa mapa = new Mapa(mapSize);

	Vehiculo vehiculo = new Vehiculo(0, new Posicion(0, 0, this.mapa));

	public void mover(Direccion direccion) {
		vehiculo.mover(direccion);
	}

	public void aplicarEstado(Estado estado) {
		vehiculo.aplicarEstado(estado);
	}
}