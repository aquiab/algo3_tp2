package edu.fiuba.algo3.modelo;

import java.util.PriorityQueue;

public class Ranking {

    public PriorityQueue<Jugador> jugadores = new PriorityQueue<>();

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public Jugador devolverGanador(){
        return this.jugadores.poll();
    }

    public double devolverMayorPuntaje() {
        return this.jugadores.poll().obtenerPuntaje();
    }

    public String devolverNombreGanador() {
        return this.jugadores.poll().obtenerNombre();
    }
}
