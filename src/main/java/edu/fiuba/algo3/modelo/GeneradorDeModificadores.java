package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.constructores.Director;

public class GeneradorDeModificadores {

    private int mapSize;
    private Mapa mapa;

    public GeneradorDeModificadores(int longitudMapa, Mapa mapa) {
        this.mapa = mapa;
        this.mapSize = longitudMapa;
    }

    public void llenarMapa(Estado estado) {
        agregarSorpresas(mapSize);
        agregarObstaculos(mapSize, estado);
    }

    public void agregarSorpresas(Integer cantidadSorpresas) {
        Director director = new Director();
        int sorpresasAgregadas = 0;
        while (sorpresasAgregadas < cantidadSorpresas) {
            Posicion posicion = obtenerPosicionAleatoria(mapSize);
            mapa.obtenerCalleHorizontal(posicion.x, posicion.y).agregarSorpresa(director.generarSopresa(sorpresasAgregadas));
            posicion = obtenerPosicionAleatoria(mapSize);
            mapa.obtenerCalleVertical(posicion.x, posicion.y).agregarSorpresa(director.generarSopresa(sorpresasAgregadas));
            sorpresasAgregadas += 1;
        }
    }

    public void agregarObstaculos(Integer cantidadObstaculos, Estado estadoActual) {
        Director director = new Director();
        int obstaculosAgregados = 0;
        while (obstaculosAgregados < cantidadObstaculos) {
            Posicion posicion = obtenerPosicionAleatoria(mapSize);
            mapa.obtenerCalleVertical(posicion.x, posicion.y).agregarObstaculo(director.generarObstaculo(obstaculosAgregados, estadoActual));
            posicion = obtenerPosicionAleatoria(mapSize);
            mapa.obtenerCalleHorizontal(posicion.x, posicion.y).agregarObstaculo(director.generarObstaculo(obstaculosAgregados, estadoActual));
            obstaculosAgregados += 1;
        }
    }

    private Posicion obtenerPosicionAleatoria(int dimension) {
        return new Posicion((int) (Math.random() * (dimension - 1)), (int) (Math.random() * (dimension - 1)), mapa);
    }
}
