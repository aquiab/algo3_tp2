package edu.fiuba.algo3.modelo;

import java.util.PriorityQueue;

public class Ranking {

    private PriorityQueue<Jugador> jugadores = new PriorityQueue<>();

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public Jugador devolverGanador(){
        return this.jugadores.poll();
    }
}
