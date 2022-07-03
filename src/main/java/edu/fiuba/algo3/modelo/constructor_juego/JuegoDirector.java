package edu.fiuba.algo3.modelo.constructor_juego;

import edu.fiuba.algo3.modelo.Juego;

public class JuegoDirector {

    private JuegoConstructor constructor = new JuegoConstructor();

    public void configurarPartidaFacil() {
        constructor.asignarLongitudMapa(10)
                .agregarPozos(5)
                .agregarPiquetes(5)
                .agregarControlesPoliciales(5)
                .agregarSorpresasFavorables(10)
                .agregarSorpresasDesfavorables(5)
                .agregarSorpresasCambioDeVehiculo(5)
                .asignarAutoInicial();
    }

    public void configurarPartidaNormal() {
        constructor.asignarLongitudMapa(10)
                .agregarPozos(10)
                .agregarPiquetes(10)
                .agregarControlesPoliciales(10)
                .agregarSorpresasFavorables(5)
                .agregarSorpresasDesfavorables(10)
                .agregarSorpresasCambioDeVehiculo(10)
                .asignarAutoInicial();
    }

    public void configurarPartidaDificil() {
        constructor.asignarLongitudMapa(10)
                .agregarPozos(15)
                .agregarPiquetes(15)
                .agregarControlesPoliciales(15)
                .agregarSorpresasFavorables(0)
                .agregarSorpresasDesfavorables(10)
                .agregarSorpresasCambioDeVehiculo(10)
                .asignarAutoInicial();
    }

    public Juego obtenerPartida() {
        return constructor.construir();
    }
}
