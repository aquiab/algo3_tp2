package edu.fiuba.algo3.modelo;

import java.util.LinkedList;
import edu.fiuba.algo3.modelo.estado.*;

public class Juego {

	private Integer POSICION_INICIAL = 0;
	private Integer MOVIMIENTOS_INICIALES = 0;
	private Integer COORDENADA_META;
	private Boolean gano = false;
	private Ranking ranking;
	private Mapa mapa;
	private Vehiculo vehiculo;
	private Jugador jugador;
	
	public void mover(Direccion direccion) {
		vehiculo.mover(direccion);
	}

	public void aplicarJugador(String nombre) {
		this.jugador = new Jugador(nombre);
	}

	public void aplicarRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	public void aplicarEstadoInicial(Estado estado) {
		vehiculo.aplicarEstado(estado);
	}

	public void asignarMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	public void asignarVehiculoInicial() {
		this.vehiculo = new Vehiculo(MOVIMIENTOS_INICIALES, new Posicion(POSICION_INICIAL, POSICION_INICIAL, this.mapa), this);
	}

	public void asignarCoordenadaMeta(int coordenada) {
		this.COORDENADA_META = coordenada;
	}

	public Mapa obtenerMapa() {
		return this.mapa;
	}

	public int obtenerDimensionMapa() {
		return this.mapa.dimension();
	}

	public LinkedList<LinkedList<Calle>> obtenerCallesHorizontales() {
		return this.mapa.getCallesHorizontales();
	}

	public LinkedList<LinkedList<Calle>> obtenerCallesVerticales() {
		return this.mapa.getCallesVerticales();
	}

	public Vehiculo obtenerVehiculo() {
		return this.vehiculo;
	}

	public Estado obtenerEstadoVehiculo() {
		return this.vehiculo.obtenerEstado();
	}
	public int obtenerPosicionXVehiculo() {
		return this.vehiculo.obtenerPosicionX();
	}
	public int obtenerPosicionYVehiculo() {
		return this.vehiculo.obtenerPosicionY();
	}

	public int obtenerCoordenadaMeta() {
		return this.COORDENADA_META;
	}

	public double obtenerMovimientos() {
		return this.vehiculo.obtenerMovimientos();
	}

	public void ganar(double movimientos) {
		this.jugador.ingresarPuntaje(movimientos);
		this.ranking.agregarJugador(this.jugador);
		gano = true;
	}
	public Boolean gano() {
		return gano;
	}
}