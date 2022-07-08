package edu.fiuba.algo3.modelo.constructor_juego;

import edu.fiuba.algo3.modelo.Calle;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.estado.Moto;
import edu.fiuba.algo3.modelo.obstaculos.*;
import edu.fiuba.algo3.modelo.sorpresas.*;

public class JuegoConstructor {

    private Juego juego = new Juego();
    private int dimensionMapa;

    public JuegoConstructor asignarLongitudMapa(int dimension) {
        this.dimensionMapa = dimension;
        juego.asignarLongitudMapa(dimension);
        return this;
    }

    private Posicion obtenerPosicionAleatoria(int dimension) {
        return new Posicion((int) (Math.random() * (dimension - 1)), (int) (Math.random() * (dimension - 1)), juego.obtenerMapa());
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

        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), new SorpresaVehiculo());
        for (int i = 0; i < cantidad/2; i++) agregarSorpresaEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), new SorpresaVehiculo());
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
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), new Pozo());
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), new Pozo());
        return this;
    }

    public JuegoConstructor agregarPiquetes(double cantidad) {
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), new Piquete());
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), new Piquete());
        return this;
    }

    public JuegoConstructor agregarControlesPoliciales(double cantidad) {
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleHorizontal(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), new ControlPolicial());
        for (int i = 0; i < cantidad/2; i++) agregarObstaculoEnCalleVertical(juego.obtenerMapa(), obtenerPosicionAleatoria(dimensionMapa), new ControlPolicial());
        return this;
    }

    /*    Meta    */

    public JuegoConstructor agregarMetaEn(int y) {
        Calle calle = juego.obtenerMapa().obtenerCalleHorizontal(dimensionMapa - 1, y);
        juego.asignarCoordenadaMeta(y);
        calle.agregarObstaculo(new VacioObstaculo());
        calle.agregarSorpresa(new Meta());
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

    public JuegoConstructor asignarCodigo(int codigo) {
        this.juego.asignarCodigo(codigo);
        return this;
    }
}
