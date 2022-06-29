package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.constructores.Director;

import java.util.concurrent.ThreadLocalRandom;

public class Juego {

	private Integer POSICION_INICIAL = 0;
	private Integer MOVIMIENTOS_INICIALES = 0;

	public Ranking ranking = new Ranking();
	public int mapSize = ThreadLocalRandom.current().nextInt(10, 15);
	public Mapa mapa = new Mapa(mapSize);

	public Vehiculo vehiculo = new Vehiculo(MOVIMIENTOS_INICIALES, new Posicion(POSICION_INICIAL, POSICION_INICIAL, this.mapa));

	public Juego() {
		//agregarSorpresas(mapa.dimension());
	}

	public void mover(Direccion direccion) {
		vehiculo.mover(direccion);
	}

	public void reiniciarJuego() {
		this.mapa = new Mapa(mapSize);
		this.vehiculo = new Vehiculo(MOVIMIENTOS_INICIALES, new Posicion(POSICION_INICIAL, POSICION_INICIAL, this.mapa));
	}

	public void aplicarJugador(String nombre) {
		Jugador jugador = new Jugador(nombre, this.ranking);
		vehiculo.jugador = jugador;
	}

	public void aplicarEstado(Estado estado) {
		vehiculo.aplicarEstado(estado);
		//no debería ir acá
		agregarSorpresas(mapa.dimension());
	}

	public void agregarSorpresas(Integer cantidadSorpresas) {
		Director director = new Director();
		int sorpresasAgregadas = 0;
		while (sorpresasAgregadas < cantidadSorpresas/2) {
			Posicion posicion = obtenerPosicionAleatoria(mapa.dimension());
			mapa.obtenerCalleHorizontal(posicion.x, posicion.y).agregarSorpresa(director.generarSopresa(sorpresasAgregadas));
			posicion = obtenerPosicionAleatoria(mapa.dimension());
			mapa.obtenerCalleVertical(posicion.x, posicion.y).agregarSorpresa(director.generarSopresa(sorpresasAgregadas));
			sorpresasAgregadas += 1;
		}
	}

	private Posicion obtenerPosicionAleatoria(int dimension) {
		return new Posicion((int) (Math.random() * (dimension - 1)), (int) (Math.random() * (dimension - 1)), mapa);
	}
}