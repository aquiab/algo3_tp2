package edu.fiuba.algo3.modelo;

public class Jugador implements Comparable<Jugador> {
    private double movimientos;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
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
        } else if(this.movimientos > o.getMovimientos()){ //asi anda
            //El objeto 1 es mejor que el pasado por parametro
            estado = 1;
        }
        return estado;
    }

    public void ingresarPuntaje(double movimientos) {
        this.movimientos = movimientos;
    }

    public double obtenerPuntaje() {
        return this.movimientos;
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}