package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.constructor_juego.JuegoConstructor;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Estado;

public class Juego {

	private Integer POSICION_INICIAL = 0;
	private Integer MOVIMIENTOS_INICIALES = 0;
	public Ranking ranking = new Ranking();
	public int mapSize;//ThreadLocalRandom.current().nextInt(10, 15);
	public Mapa mapa;
	public Vehiculo vehiculo;

	public void mover(Direccion direccion) {
		vehiculo.mover(direccion);
	}

	public void reiniciarJuego() {
		this.mapa = new Mapa(mapSize);
		Jugador aux = vehiculo.jugador;
		this.vehiculo = new Vehiculo(MOVIMIENTOS_INICIALES, new Posicion(POSICION_INICIAL, POSICION_INICIAL, this.mapa), this);
		aplicarEstadoInicial(new Auto(this.vehiculo));
		aplicarJugador(aux.nombre);
	}

	public void aplicarJugador(String nombre) {
		Jugador jugador = new Jugador(nombre, this.ranking);
		vehiculo.jugador = jugador;
	}

	public void aplicarEstadoInicial(Estado estado) {
		vehiculo.aplicarEstado(estado);
	}

	public void asginarLongitudMapa(int dimension) {
		this.mapSize = dimension;
		this.mapa = new Mapa(dimension);
	}

	public void asignarVehiculoInicial() {
		this.vehiculo = new Vehiculo(MOVIMIENTOS_INICIALES, new Posicion(POSICION_INICIAL, POSICION_INICIAL, this.mapa), this);
	}

	public Mapa obtenerMapa() {
		return this.mapa;
	}

	public Vehiculo obtenerVehiculo() {
		return this.vehiculo;
	}
}