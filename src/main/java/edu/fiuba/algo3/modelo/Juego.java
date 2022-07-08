package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

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
	private Mapa mapa;
	public Vehiculo vehiculo;
	public Jugador jugador;
	
	public void mover(Direccion direccion) {
		vehiculo.mover(direccion);
	}

	public void reiniciarJuego() {
		this.COORDENADA_META = JuegoDirector.valorAleatorio();
		this.mapa = JuegoDirector.reiniciarJuego(this.CODIGO, this.COORDENADA_META);
		this.mapSize = mapa.dimension();
		this.vehiculo = new Vehiculo(MOVIMIENTOS_INICIALES, new Posicion(POSICION_INICIAL, POSICION_INICIAL, this.mapa), this);
		aplicarEstadoInicial(new Auto(this.vehiculo));
		aplicarJugador(this.jugador.nombre);
		gano = false;
	}

	public void aplicarJugador(String nombre) {
		this.jugador = new Jugador(nombre);
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

	public void asignarCodigo(int codigo) {
		this.CODIGO = codigo;
	}

	public void asignarCoordenadaMeta(int coordenada) {
		this.COORDENADA_META = coordenada;
	}


	public Mapa obtenerMapa() {
		return this.mapa;
	}

	public LinkedList<LinkedList<Calle>> obtenerCallesHorizontales() {
		return this.mapa.callesHorizontales;
	}

	public LinkedList<LinkedList<Calle>> obtenerCallesVerticales() {
		return this.mapa.callesVerticales;
	}

	public Vehiculo obtenerVehiculo() {
		return this.vehiculo;
	}

	public Estado obtenerEstadoVehiculo() {
		return this.vehiculo.estado;
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
		return this.vehiculo.movimientos;
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