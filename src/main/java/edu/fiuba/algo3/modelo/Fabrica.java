package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.fabrica_obstaculos.*;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.*;

/**
 * Clase encargada de la construcción tanto de obstáculos como de sorpresas.
 */
public class Fabrica {

    private static final int CANTIDAD_DE_SORPRESAS = 3;
    private static final int CANTIDAD_DE_OBSTACULOS = 3;

    /*----Sorpresas----*/

    public ISorpresa generarVacioSorpresa() {
        return new VacioSorpresa();
    }

    public ISorpresa generarSorpresaFavorable() {
        SorpresaFavorableFabrica fabrica = new SorpresaFavorableFabrica();
        return fabrica.crearSorpresa();
    }

    public ISorpresa generarSorpresaDesfavorable() {
        SorpresaDesfavorableFabrica fabrica = new SorpresaDesfavorableFabrica();
        return fabrica.crearSorpresa();
    }

    public ISorpresa generarSorpresaCambioDeVehiculo() {
        SorpresaVehiculoFabrica fabrica = new SorpresaVehiculoFabrica();
        return fabrica.crearSorpresa();
    }

    public ISorpresa generarSopresa(int codigo) {
        switch (codigo % CANTIDAD_DE_SORPRESAS) {
            case 0:
                return generarSorpresaFavorable();
            case 1:
                return generarSorpresaDesfavorable();
        }
        return generarSorpresaCambioDeVehiculo();
    }

    /*----Obstáculos----*/

    public IObstaculo generarVacioObstaculo() {
        return new VacioObstaculo();
    }

    public IObstaculo generarPozo() {
        PozoFabrica fabrica = new PozoFabrica();
        return fabrica.crearObstaculo();
    }

    public IObstaculo generarPiquete() {
        PiqueteFabrica fabrica = new PiqueteFabrica();
        return fabrica.crearObstaculo();
    }

    public IObstaculo generarControlPolicial() {
        ControlPolicialFabrica fabrica = new ControlPolicialFabrica();
        return fabrica.crearObstaculo();
    }

    public IObstaculo generarObstaculo(int codigo) {
        switch (codigo % CANTIDAD_DE_OBSTACULOS) {
            case 0:
                return generarPozo();
            case 1:
                return generarPiquete();
        }
        return generarControlPolicial();
    }
}
