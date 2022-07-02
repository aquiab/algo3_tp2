package edu.fiuba.algo3.modelo.constructor_juego;

import edu.fiuba.algo3.modelo.Juego;

public class JuegoDirector {

    public Juego crearPartidaNormal() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(10)
                .agregarPozos(5)
                .agregarPiquetes(5)
                .agregarControlesPoliciales(5)
                .agregarSorpresasFavorables(5)
                .agregarSorpresasDesfavorables(5)
                .agregarSorpresasCambioDeVehiculo(5)
                .asignarAutoInicial();
        return constructor.construir();
    }

    public Juego crearPartidaDificil() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(10)
                .agregarPozos(10)
                .agregarPiquetes(10)
                .agregarControlesPoliciales(10)
                .agregarSorpresasFavorables(5)
                .agregarSorpresasDesfavorables(10)
                .agregarSorpresasCambioDeVehiculo(10)
                .asignarAutoInicial();
        return constructor.construir();
    }
}
