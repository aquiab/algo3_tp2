package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.sistema_de_posicion.Direccion;
import edu.fiuba.algo3.modelo.sistema_de_posicion.Posicion;

public class Vehiculo {

    public Posicion posicion;
    public double movimientos;
    public Estado estado;
    public Jugador jugador;
    private Integer PENALIZACION_POR_CADA_MOVIMENTO = 1;
    private Juego juego;

    protected Vehiculo(double movimientos, Posicion posicion, Juego juego) {
        this.movimientos = movimientos;
        this.posicion = posicion;
        this.juego = juego;
    }

    public void mover(Direccion direccion) {
        incrementarMovimientos(PENALIZACION_POR_CADA_MOVIMENTO);
        direccion.mover(this.posicion, this);
    }
    public void aplicarEstado(Estado estado) {
        this.estado = estado;
    }

    public void aplicarJugador(Jugador jugador) {this.jugador = jugador;}

    public void incrementarMovimientos(double incremento) {
        movimientos += incremento;
    }

    public void aplicarSorpresaPuntaje(double valorSorpresa) {
        this.movimientos *= valorSorpresa;
    }

    public void pasarPiquete(double penalizacion) {
        estado.pasarPiquete(penalizacion);
    }

    public void pasarPozo(double penalizacion) {
        estado.pasarPozo(penalizacion);
    }

    public void pasarControlPolicial(double penalizacion, double probabilidad, double valorActual) {
        estado.pasarControlPolicial(penalizacion, probabilidad, valorActual);
    }

    public void aplicarSorpresaCambioVehiculo(Estado siguienteEstado) {
        estado = siguienteEstado;
        juego.actualizarObstaculos();
    }

    public void aplicarVacio() {
        estado.pasarVacio();
    }

    public Posicion devolverPosicion() {
        return this.posicion;
    }

    public void ganar() {
        this.jugador.ingresarPuntaje(this.movimientos);
        this.juego.reiniciarJuego();
    }

    public Estado estadoActual() {
        return estado;
    }
}

