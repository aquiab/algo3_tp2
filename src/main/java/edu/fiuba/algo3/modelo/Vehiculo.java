package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public abstract class Vehiculo {

    protected HashMap<Class, Obshandler> ObsMap;
    protected abstract void initObsMap();
    protected Esquina posicion;
    protected Esquina posicion_siguiente;
    protected Integer movimientos;
    protected Vehiculo() {
        this.movimientos = 0;
        this.initObsMap();
    }

    void hacerMovimiento(String direccion) {
        Tuple nueva_pos = posicion.devolver_esquina_calle(direccion);
        posicion_siguiente = nueva_pos.devolverEsquina();
        Calle calle = nueva_pos.devolverCalle();
        pasarObstaculo(calle.devolverObstaculo());
        posicion = posicion_siguiente;
        this.movimientos++;
    }

    public Integer obtenerMovimientos() {
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
}
