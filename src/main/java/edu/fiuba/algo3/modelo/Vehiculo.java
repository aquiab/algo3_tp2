package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public abstract class Vehiculo {

    protected int PROBABILIDAD_DE_ENCONTRAR_CONTROL;

    protected Esquina posicion;
    protected Esquina posicion_siguiente;
    protected Puntaje movimientos;

    protected Vehiculo() {
        this.movimientos = new Puntaje();
    }

    Sorpresa hacerMovimiento(String direccion) {
        this.movimientos.aumentarPuntos(1);
        Tuple nueva_pos = posicion.devolver_esquina_calle(direccion);
        posicion_siguiente = nueva_pos.devolverEsquina();
        Calle calle = nueva_pos.devolverCalle();
        //.......... if (obstaculoActual != null)?
        Obstaculo obstaculo = calle.devolverObstaculo();
        try {
            obstaculo.aplicar(this);
        } catch (CaminoCortado error) {
            posicion_siguiente = posicion;
        } catch (Exception error) {}
        posicion = posicion_siguiente;
        return calle.devolverSorpresa();
    }

    public double obtenerMovimientos() {
        return this.movimientos.obtenerCantidadTotalMovimientos();
    }
    public Puntaje obtenerPuntos() {
        return this.movimientos;
    }

    public void aumentarPuntos(float cantidad) {
        this.movimientos.aumentarPuntos(cantidad);
    }




    public int probabilidadEncontrarControl() {
        return PROBABILIDAD_DE_ENCONTRAR_CONTROL;
    }


    public void asignarPosicionInicial(Esquina esquina) {
        this.posicion = esquina;
    }

    public Esquina obtenerPosicionActual() {
        return this.posicion;
    }

    public Vehiculo cambiarAlSiguiente() {
        return null;
    }

    public void multiplicarPuntosPor(double multiplicador) {
        this.movimientos.multiplicarPor(multiplicador);
    }


    public void pasarPozo() {
    }
}
