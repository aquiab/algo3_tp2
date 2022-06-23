package edu.fiuba.algo3.modelo;

public class Jugador implements Comparable<Jugador> {
    public double movimientos;
    public String nombre;
    public Ranking ranking;

    public Jugador(String nombre, Ranking ranking) {
        this.nombre = nombre;
        this.ranking = ranking;
    }

    public double getMovimientos() {
        return this.movimientos;
    }

    @Override
    public int compareTo(Jugador o) {
        int estado = -1;
        if (this.movimientos == o.getMovimientos()) {
            //Los objetos son iguales
            estado = 0;
        } else if( this.movimientos > o.getMovimientos()){ //asi anda
            //El objeto 1 es mejor que el pasado por parametro
            estado = 1;
        }
        return estado;
    }

    public void ingresarPuntaje(double movimientos) {
        this.movimientos = movimientos;
        this.ranking.agregarJugador(this);
    }
}