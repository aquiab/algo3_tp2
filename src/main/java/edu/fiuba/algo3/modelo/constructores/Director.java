package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.obstaculos.VacioObstaculo;
import edu.fiuba.algo3.modelo.sorpresas.ISorpresa;
import edu.fiuba.algo3.modelo.sorpresas.VacioSorpresa;

/**
 * Clase encargada de la construcción tanto de obstáculos como de sorpresas.
 */
public class Director {

    private static final int CANTIDAD_DE_SORPRESAS = 3;
    private static final int CANTIDAD_DE_OBSTACULOS = 3;

    /*----Sorpresas----*/

    public ISorpresa generarVacioSorpresa() {
        return new VacioSorpresa();
    }

    public ISorpresa generarSorpresaFavorable() {
        SorpresaPuntajeConstructor constructor = new SorpresaPuntajeConstructor();
        constructor.valorSopresa(0.8);
        return constructor.construir();
    }

    public ISorpresa generarSorpresaDesfavorable() {
        SorpresaPuntajeConstructor constructor = new SorpresaPuntajeConstructor();
        constructor.valorSopresa(1.25);
        return constructor.construir();
    }

    public ISorpresa generarSorpresaCambioDeVehiculo(Estado estadoActual) {
        SorpresaVehiculoConstructor constructor = new SorpresaVehiculoConstructor();
        constructor.siguienteEstado(estadoActual.siguienteEstado());
        return constructor.construir();
    }

    public ISorpresa generarSopresa(int codigo, Estado estadoActual) {
        switch (codigo % CANTIDAD_DE_SORPRESAS) {
            case 0:
                return generarSorpresaFavorable();
            case 1:
                return generarSorpresaDesfavorable();
        }
        return generarSorpresaCambioDeVehiculo(estadoActual);
    }

    /*----Obstáculos----*/

    public IObstaculo generarVacioObstaculo() {
        return new VacioObstaculo();
    }

    public IObstaculo generarPozo(Estado estadoActual) {
        PozoConstructor constructor = new PozoConstructor();
        constructor.penalizacion(estadoActual.obtenerPenalizacionPozo());
        return constructor.construir();
    }

    public IObstaculo generarPiquete(Estado estadoActual) {
        PiqueteConstructor constructor = new PiqueteConstructor();
        constructor.penalizacion(estadoActual.obtenerPenalizacionPiquete());
        return constructor.construir();
    }

    public IObstaculo generarControlPolicial(Estado estadoActual) {
        ControlPolicialConstructor constructor = new ControlPolicialConstructor();
        constructor.penalizacion(estadoActual.obtenerPenalizacionControl());
        constructor.probabilidad(estadoActual.obtenerProbabilidadControl());
        return constructor.construir();
    }

    public IObstaculo generarObstaculo(int codigo, Estado estadoActual) {
        switch (codigo % CANTIDAD_DE_OBSTACULOS) {
            case 0:
                return generarPozo(estadoActual);
            case 1:
                return generarPiquete(estadoActual);
        }
        return generarControlPolicial(estadoActual);
    }
}
