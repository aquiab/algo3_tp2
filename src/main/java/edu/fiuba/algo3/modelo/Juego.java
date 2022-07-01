package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estados.Auto;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.sistema_de_posicion.Direccion;
import edu.fiuba.algo3.modelo.sistema_de_posicion.Posicion;

public class Juego {

	private Integer POSICION_INICIAL = 0;
	private Integer MOVIMIENTOS_INICIALES = 0;
	public Ranking ranking = new Ranking();
	public int mapSize = 10;//ThreadLocalRandom.current().nextInt(10, 15);
	public Mapa mapa = new Mapa(mapSize);
	public Vehiculo vehiculo = new Vehiculo(MOVIMIENTOS_INICIALES, new Posicion(POSICION_INICIAL, POSICION_INICIAL, this.mapa), this);
	private GeneradorDeModificadores generador = new GeneradorDeModificadores(mapSize, mapa);
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
		generador.llenarMapa(estado);
	}

	public Estado obtenerEstadoActual() {
		return vehiculo.estadoActual();
	}

    public void actualizarObstaculos() {
		generador.actualizarObstaculos(vehiculo.estado);
		generador.actualizarSorpresas(vehiculo.estado);
    }
}