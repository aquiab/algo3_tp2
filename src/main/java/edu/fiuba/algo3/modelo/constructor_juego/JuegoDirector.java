package edu.fiuba.algo3.modelo.constructor_juego;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Mapa;

import java.util.Random;

public class JuegoDirector {

    private JuegoConstructor constructor = new JuegoConstructor();

    private int COORDENADA_META;

    public JuegoDirector() {
        this.COORDENADA_META = valorAleatorio();
    }

    public JuegoDirector(int codigo, int coordenadaMeta) {
        this.COORDENADA_META = coordenadaMeta;
        switch (codigo) {
            case 1:
                configurarPartidaFacil();
                break;
            case 2:
                configurarPartidaNormal();
                break;
            default:
                configurarPartidaDificil();
                break;
        }
    }

    public static Mapa reiniciarJuego(int codigo, int coordenadaMeta) {
        JuegoDirector aux = new JuegoDirector(codigo, coordenadaMeta);
        Juego juegoAuxiliar = aux.obtenerPartida();
        return juegoAuxiliar.obtenerMapa();
    }

    public static int valorAleatorio() {
        Random rand = new Random();
        return rand.nextInt(10 - 1);
    }

    public void configurarPartidaFacil() {
        constructor.asignarLongitudMapa(10)
                .asignarCodigo(1)
                .agregarPozos(5)
                .agregarPiquetes(5)
                .agregarControlesPoliciales(5)
                .agregarSorpresasFavorables(10)
                .agregarSorpresasDesfavorables(5)
                .agregarSorpresasCambioDeVehiculo(5)
                .agregarMetaEn(COORDENADA_META)
                .asignarAutoInicial();
    }

    public void configurarPartidaNormal() {
        constructor.asignarLongitudMapa(10)
                .asignarCodigo(2)
                .agregarPozos(10)
                .agregarPiquetes(10)
                .agregarControlesPoliciales(10)
                .agregarSorpresasFavorables(5)
                .agregarSorpresasDesfavorables(10)
                .agregarSorpresasCambioDeVehiculo(10)
                .agregarMetaEn(COORDENADA_META)
                .asignarAutoInicial();
    }

    public void configurarPartidaDificil() {
        constructor.asignarLongitudMapa(10)
                .asignarCodigo(3)
                .agregarPozos(15)
                .agregarPiquetes(15)
                .agregarControlesPoliciales(15)
                .agregarSorpresasFavorables(0)
                .agregarSorpresasDesfavorables(10)
                .agregarSorpresasCambioDeVehiculo(10)
                .agregarMetaEn(COORDENADA_META)
                .asignarAutoInicial();
    }

    public Juego obtenerPartida() {
        //pasamanos
        return constructor.construir();
    }

    public int obtenerCoordenadaMeta() {
        return this.COORDENADA_META;
    }
}
