package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.modelo.estado.*;

public class Juego {

	private Integer POSICION_INICIAL = 0;
	private Integer MOVIMIENTOS_INICIALES = 0;
	private Integer COORDENADA_META;

	private int CODIGO;
	private Boolean gano = false;
	public Ranking ranking = new Ranking();
	public int mapSize;
	public Mapa mapa;
	public Vehiculo vehiculo;
	
	public void mover(Direccion direccion) {
		vehiculo.mover(direccion);
	}

	public void reiniciarJuego() {
		this.COORDENADA_META = JuegoDirector.valorAleatorio();
		this.mapa = JuegoDirector.reiniciarJuego(this.CODIGO, this.COORDENADA_META);
		Jugador aux = vehiculo.jugador;
		this.vehiculo = new Vehiculo(MOVIMIENTOS_INICIALES, new Posicion(POSICION_INICIAL, POSICION_INICIAL, this.mapa), this);
		aplicarEstadoInicial(new Auto(this.vehiculo));
		aplicarJugador(aux.nombre);
		//gano = false;
	}

	public void aplicarJugador(String nombre) {
		Jugador jugador = new Jugador(nombre, this.ranking);
		vehiculo.aplicarJugador(jugador);
	}

	public void aplicarEstadoInicial(Estado estado) {
		vehiculo.aplicarEstado(estado);
	}

	public void asignarLongitudMapa(int dimension) {
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

	public void asignarCodigo(int codigo) {
		this.CODIGO = codigo;
	}

	public void asignarCoordenadaMeta(int coordeanda) {
		this.COORDENADA_META = coordeanda;
	}

	public int obtenerCoordenadaMeta() {
		return this.COORDENADA_META;
	}
	public double obtenerMovimientos() {
		return this.vehiculo.movimientos;
	}
	public void ganar() {
		gano = true;
	}
	public Boolean gano() {
		return gano;
	}
}