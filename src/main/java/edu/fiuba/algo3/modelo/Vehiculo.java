package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public abstract class Vehiculo {

    protected HashMap<Class, Obshandler> ObsMap;

    protected abstract void initObsMap();
    protected Esquina posicion;
    protected Esquina posicion_siguiente;
    protected Puntaje movimientos;
    protected Vehiculo() {
        this.movimientos = new Puntaje();
        this.initObsMap();
    }

    Sorpresa hacerMovimiento(String direccion) {
        this.movimientos.aumentarPuntos(1);
        Tuple nueva_pos = posicion.devolver_esquina_calle(direccion);
        posicion_siguiente = nueva_pos.devolverEsquina();
        Calle calle = nueva_pos.devolverCalle();
        //.......... if (obstaculoActual != null)?
        try {
            pasarObstaculo(calle.devolverObstaculo());
        } catch (Exception e) {}
        posicion = posicion_siguiente;
        return calle.devolverSorpresa();
    }

    public double obtenerMovimientos() {
        return this.movimientos.obtenerCantidadTotalMovimientos();
    }
    public Puntaje obtenerPuntos() {
        return this.movimientos;
    }
    public void pasarObstaculo(Obstaculo obstaculo) {
        Obshandler handler = this.ObsMap.get(obstaculo.getClass());
        handler.pasarObstaculo(obstaculo);
    }

    interface Obshandler { //pozo policial piquete
        void pasarObstaculo(Obstaculo obstaculo);
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

    public void descontarPuntosPor(double descuento) {
        this.movimientos.multiplicarPor(descuento);
    }
}
