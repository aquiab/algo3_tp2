package edu.fiuba.algo3.modelo.constructor_juego;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ranking;

import java.util.Random;

public class JuegoDirector {

    public JuegoConstructor constructor = new JuegoConstructor();

    private int COORDENADA_META;
    private Ranking ranking;

    public JuegoDirector(Ranking ranking) {
        this.COORDENADA_META = valorAleatorio();
        this.ranking = ranking;
    }
    public static int valorAleatorio() {
        Random rand = new Random();
        return rand.nextInt(10 - 1);
    }

    public void configurarPartidaFacil() {
        constructor.asignarLongitudMapa(10)
                .agregarPozos(5)
                .agregarPiquetes(5)
                .agregarControlesPoliciales(5)
                .agregarSorpresasFavorables(10)
                .agregarSorpresasDesfavorables(5)
                .agregarSorpresasCambioDeVehiculo(5)
                .agregarMetaEn(COORDENADA_META)
                .asignarRanking(this.ranking)
                .asignarVehiculoInicial();
    }

    public void configurarPartidaNormal() {
        constructor.asignarLongitudMapa(10)
                .agregarPozos(10)
                .agregarPiquetes(10)
                .agregarControlesPoliciales(10)
                .agregarSorpresasFavorables(5)
                .agregarSorpresasDesfavorables(10)
                .agregarSorpresasCambioDeVehiculo(10)
                .agregarMetaEn(COORDENADA_META)
                .asignarRanking(this.ranking)
                .asignarVehiculoInicial();
    }

    public void configurarPartidaDificil() {
        constructor.asignarLongitudMapa(10)
                  .agregarPozos(15)
                .agregarPiquetes(15)
                .agregarControlesPoliciales(15)
                .agregarSorpresasFavorables(0)
                .agregarSorpresasDesfavorables(10)
                .agregarSorpresasCambioDeVehiculo(10)
                .agregarMetaEn(COORDENADA_META)
                .asignarRanking(this.ranking)
                .asignarVehiculoInicial();
    }

    public Juego obtenerPartida() {
        return constructor.construir();
    }
    public Ranking obtenerRanking() {return this.ranking;}
    public int obtenerCoordenadaMeta() {
        return this.COORDENADA_META;
    }
    public void asignarAutoInicial() {
        constructor.asignarAutoInicial();
    }
    public void asignarMotoInicial() {
        constructor.asignarMotoInicial();
    }
    public void asignarCamionetaInicial() {
        constructor.asignarCamionetaInicial();
    }

    public void refreshConstructor() {
        this.COORDENADA_META = valorAleatorio();
        this.constructor = new JuegoConstructor();}

    public void setearPartidaDefault() {
        configurarPartidaNormal();
        asignarAutoInicial();
    }
}
