package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public abstract class Vehiculo {

    protected int fila;
    protected int columna;

    protected HashMap<String, Obshandler> ObsMap;

    protected abstract void initObsMap();
    protected double movimientos;
    protected Vehiculo() {
        this.movimientos = 0;
        this.initObsMap();
    }

    public void pasarObstaculo(String obstaculo) {
        Obshandler handler = this.ObsMap.get(obstaculo);
        handler.pasarObstaculo(obstaculo);
    }

    interface Obshandler { //pozo policial piquete
        void pasarObstaculo(String obstaculo);
    }

    public Vehiculo cambiarAlSiguiente() {
        return null;
    }
}
