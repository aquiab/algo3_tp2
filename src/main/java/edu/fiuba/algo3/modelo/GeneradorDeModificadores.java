package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.constructores.Director;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.sorpresas.ISorpresa;
import edu.fiuba.algo3.modelo.sistema_de_posicion.Posicion;

import java.util.LinkedList;

public class GeneradorDeModificadores {

    private int mapSize;
    private Mapa mapa;

    private LinkedList<IObstaculo> obstaculosIniciales = new LinkedList<IObstaculo>();
    private LinkedList<ISorpresa> sorpresasIniciales = new LinkedList<ISorpresa>();

    public GeneradorDeModificadores(int longitudMapa, Mapa mapa) {
        this.mapa = mapa;
        this.mapSize = longitudMapa;
    }

    public void llenarMapa(Estado estado) {
        agregarSorpresas(mapSize, estado);
        agregarObstaculos(mapSize, estado);
    }

    public void agregarSorpresas(Integer cantidadSorpresas, Estado estadoActual) {
        Director director = new Director();
        int sorpresasAgregadas = 0;
        while (sorpresasAgregadas < cantidadSorpresas) {
            ISorpresa sorpresaActual = director.generarSopresa(sorpresasAgregadas, estadoActual);
            sorpresasIniciales.add(sorpresaActual);
            Posicion posicion = obtenerPosicionAleatoria(mapSize);
            mapa.obtenerCalleHorizontal(posicion.x, posicion.y).agregarSorpresa(sorpresaActual);
            posicion = obtenerPosicionAleatoria(mapSize);
            mapa.obtenerCalleVertical(posicion.x, posicion.y).agregarSorpresa(sorpresaActual);
            sorpresasAgregadas += 1;
        }
    }

    public void agregarObstaculos(Integer cantidadObstaculos, Estado estadoActual) {
        Director director = new Director();
        int obstaculosAgregados = 0;
        while (obstaculosAgregados < cantidadObstaculos) {
            IObstaculo obstaculoActual = director.generarObstaculo(obstaculosAgregados, estadoActual);
            obstaculosIniciales.add(obstaculoActual);
            Posicion posicion = obtenerPosicionAleatoria(mapSize);
            mapa.obtenerCalleVertical(posicion.x, posicion.y).agregarObstaculo(obstaculoActual);
            posicion = obtenerPosicionAleatoria(mapSize);
            mapa.obtenerCalleHorizontal(posicion.x, posicion.y).agregarObstaculo(obstaculoActual);
            obstaculosAgregados += 1;
        }
    }

    private Posicion obtenerPosicionAleatoria(int dimension) {
        return new Posicion((int) (Math.random() * (dimension - 1)), (int) (Math.random() * (dimension - 1)), mapa);
    }

    void actualizarObstaculos(Estado estadoActual) {
        int codigo = 0;
        for (IObstaculo obstaculo: this.obstaculosIniciales) {
            actualizar(codigo, obstaculo, estadoActual);
            codigo++;
        }
    }
    private void actualizar(int codigo, IObstaculo obstaculo, Estado estadoActual) {
        switch (codigo%3) {
            case 0:
                obstaculo.actualizar(estadoActual.obtenerPenalizacionPozo(), 0);
                break;
            case 1:
                obstaculo.actualizar(estadoActual.obtenerPenalizacionPiquete(), 0);
                break;
            default:
                obstaculo.actualizar(estadoActual.obtenerPenalizacionControl(), estadoActual.obtenerProbabilidadControl());
        }
    }

    void actualizarSorpresas(Estado estadoActual) {
        int codigo = 0;
        for (ISorpresa sorpresa: this.sorpresasIniciales) {
            actualizar(codigo, sorpresa, estadoActual);
            codigo++;
        }
    }

    private void actualizar(int codigo, ISorpresa sorpresa, Estado estadoActual) {
        switch (codigo%3) {
            case 0:
                sorpresa.actualizar(estadoActual.obtenerValorSorpresaFavorable(), null);
                break;
            case 1:
                sorpresa.actualizar(estadoActual.obtenerValorSorpresaDesfavorable(), null);
                break;
            default:
                sorpresa.actualizar(0, estadoActual.siguienteEstado());
        }
    }
}
