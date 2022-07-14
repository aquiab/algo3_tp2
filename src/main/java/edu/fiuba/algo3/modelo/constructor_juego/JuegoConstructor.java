package edu.fiuba.algo3.modelo.constructor_juego;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.estado.Moto;
import edu.fiuba.algo3.modelo.obstaculos.*;
import edu.fiuba.algo3.modelo.sorpresas.*;

import static edu.fiuba.algo3.modelo.ValoresAleatorios.obtenerPosicionAleatoria;

public class JuegoConstructor {

    public Juego juego = new Juego();
    public int dimensionMapa;
    private Mapa mapa;

    public JuegoConstructor asignarLongitudMapa(int dimension) {
        this.dimensionMapa = dimension;
        this.mapa = new Mapa(dimension);
        juego.asignarMapa(this.mapa);
        return this;
    }

    public JuegoConstructor asignarRanking(Ranking ranking) {
        this.juego.aplicarRanking(ranking);
        return this;
    }



    /*    Sorpresas    */

    public void agregarSorpresaEnCalleHorizontal(Mapa mapa, Posicion posicion, ISorpresa sorpresa) {
        mapa.obtenerCalleHorizontal(posicion.obtenerCoordenadaX(), posicion.obtenerCoordenadaY()).agregarSorpresa(sorpresa);
    }

    public void agregarSorpresaEnCalleVertical(Mapa mapa, Posicion posicion, ISorpresa sorpresa) {
        mapa.obtenerCalleVertical(posicion.obtenerCoordenadaX(), posicion.obtenerCoordenadaY()).agregarSorpresa(sorpresa);
    }

    public JuegoConstructor agregarSorpresasFavorables(double cantidad) {
        SorpresaFavorableFabrica fabrica = new SorpresaFavorableFabrica();
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleHorizontal(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), fabrica.crearSorpresa());
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleVertical(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), fabrica.crearSorpresa());
        return this;
    }

    public JuegoConstructor agregarSorpresasDesfavorables(double cantidad) {
        SorpresaDesfavorableFabrica fabrica = new SorpresaDesfavorableFabrica();
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleHorizontal(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), fabrica.crearSorpresa());
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleVertical(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), fabrica.crearSorpresa());
        return this;
    }

    public JuegoConstructor agregarSorpresasCambioDeVehiculo(double cantidad) {

        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleHorizontal(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), new SorpresaVehiculo());
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleVertical(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), new SorpresaVehiculo());
        return this;
    }

    /*    Obstáculos    */

    public void agregarObstaculoEnCalleHorizontal(Mapa mapa, Posicion posicion, IObstaculo obstaculo) {
        mapa.obtenerCalleHorizontal(posicion.obtenerCoordenadaX(), posicion.obtenerCoordenadaY()).agregarObstaculo(obstaculo);
    }

    public void agregarObstaculoEnCalleVertical(Mapa mapa, Posicion posicion, IObstaculo obstaculo) {
        mapa.obtenerCalleVertical(posicion.obtenerCoordenadaX(), posicion.obtenerCoordenadaY()).agregarObstaculo(obstaculo);
    }


    public JuegoConstructor agregarPozos(double cantidad) {
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleHorizontal(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), new Pozo());
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleVertical(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), new Pozo());
        return this;
    }

    public JuegoConstructor agregarPiquetes(double cantidad) {
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleHorizontal(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), new Piquete());
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleVertical(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), new Piquete());
        return this;
    }

    public JuegoConstructor agregarControlesPoliciales(double cantidad) {
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleHorizontal(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), new ControlPolicial());
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleVertical(mapa, obtenerPosicionAleatoria(dimensionMapa, mapa), new ControlPolicial());
        return this;
    }

    /*    Meta    */

    public JuegoConstructor agregarMetaEn(int y) {
        Calle calle = mapa.obtenerCalleHorizontal(dimensionMapa - 1, y);
        juego.asignarCoordenadaMeta(y);
        calle.agregarObstaculo(new VacioObstaculo());
        calle.agregarSorpresa(new Meta());
        return this;
    }

    public JuegoConstructor asignarVehiculoInicial() {
        juego.asignarVehiculoInicial();
        return this;
    }

    /*    Estados    */

    public void asignarAutoInicial() {
        juego.aplicarEstadoInicial(new Auto(juego.obtenerVehiculo()));
    }

    public void asignarMotoInicial() {
        juego.aplicarEstadoInicial(new Moto(juego.obtenerVehiculo()));
    }

    public void asignarCamionetaInicial() {
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
    }

    public Juego construir() {
        return juego;
    }
}
