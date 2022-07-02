package edu.fiuba.algo3.modelo.constructor_juego;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.estado.Moto;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.ControlPolicialFabrica;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.PiqueteFabrica;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.PozoFabrica;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.*;

public class JuegoConstructor {

    private Juego juego = new Juego();
    private int dimensionMapa;

    public JuegoConstructor asignarLongitudMapa(int dimension) {
        this.dimensionMapa = dimension;
        juego.asginarLongitudMapa(dimension);
        return this;
    }

    private Posicion obtenerPosicionAleatoria(int dimension) {
        return new Posicion((int) (Math.random() * (dimension - 1)), (int) (Math.random() * (dimension - 1)), juego.obtenerMapa());
    }

    /*    Sorpresas    */

    public void agregarSorpresaEnCalleHorizontal(Mapa mapa, Posicion posicion, ISorpresa sorpresa) {
        mapa.obtenerCalleVertical(posicion.obtenerCoordenadaX(), posicion.obtenerCoordenadaY()).agregarSorpresa(sorpresa);
    }

    public void agregarSorpresaEnCalleVertical(Mapa mapa, Posicion posicion, ISorpresa sorpresa) {
        mapa.obtenerCalleVertical(posicion.obtenerCoordenadaX(), posicion.obtenerCoordenadaY()).agregarSorpresa(sorpresa);
    }

    public JuegoConstructor agregarSorpresasFavorables(double cantidad) {
        SorpresaFavorableFabrica fabrica = new SorpresaFavorableFabrica();
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearSorpresa());
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearSorpresa());
        return this;
    }

    public JuegoConstructor agregarSorpresasDesfavorables(double cantidad) {
        SorpresaDesfavorableFabrica fabrica = new SorpresaDesfavorableFabrica();
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearSorpresa());
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearSorpresa());
        return this;
    }

    public JuegoConstructor agregarSorpresasCambioDeVehiculo(double cantidad) {
        SorpresaVehiculoFabrica fabrica = new SorpresaVehiculoFabrica();
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearSorpresa());
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearSorpresa());
        return this;
    }

    /*    Obstáculos    */

    public void agregarObstaculoEnCalleHorizontal(Mapa mapa, Posicion posicion, IObstaculo obstaculo) {
        mapa.obtenerCalleVertical(posicion.obtenerCoordenadaX(), posicion.obtenerCoordenadaY()).agregarObstaculo(obstaculo);
    }

    public void agregarObstaculoEnCalleVertical(Mapa mapa, Posicion posicion, IObstaculo obstaculo) {
        mapa.obtenerCalleVertical(posicion.obtenerCoordenadaX(), posicion.obtenerCoordenadaY()).agregarObstaculo(obstaculo);
    }


    public JuegoConstructor agregarPozos(double cantidad) {
        PozoFabrica fabrica = new PozoFabrica();
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearObstaculo());
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearObstaculo());
        return this;
    }

    public JuegoConstructor agregarPiquetes(double cantidad) {
        PiqueteFabrica fabrica = new PiqueteFabrica();
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearObstaculo());
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearObstaculo());
        return this;
    }

    public JuegoConstructor agregarControlesPoliciales(double cantidad) {
        ControlPolicialFabrica fabrica = new ControlPolicialFabrica();
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearObstaculo());
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), fabrica.crearObstaculo());
        return this;
    }

    /*    Estados    */

    public void asignarAutoInicial() {
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.obtenerVehiculo()));
    }

    public void asignarMotoInicial() {
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Moto(juego.obtenerVehiculo()));
    }

    public void asignarCamionetaInicial() {
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
    }

    public Juego construir() {
        return juego;
    }
}
