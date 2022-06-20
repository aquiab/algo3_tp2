package edu.fiuba.algo3.modelo;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {

	private Integer POSICION_INICIAL = 0;
	private Integer MOVIMIENTOS_INICIALES = 0;
	private int mapSize = ThreadLocalRandom.current().nextInt(10, 20);
	public Mapa mapa = new Mapa(mapSize);

	Vehiculo vehiculo = new Vehiculo(MOVIMIENTOS_INICIALES, new Posicion(POSICION_INICIAL, POSICION_INICIAL, this.mapa));

	public void mover(Direccion direccion) {
		vehiculo.mover(direccion);
	}

	public void aplicarEstado(Estado estado) {
		vehiculo.aplicarEstado(estado);
	}
}