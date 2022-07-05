package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.estado.Moto;
import org.junit.jupiter.api.Test;

public class JuegoDirectorTest {

    private static final int LONGITUD_MAPA = 10;
    private static final int CANTIDAD_META = 1;
    private static final int OBSTACULOS = 0;
    private static final int SORPRESAS = 1;
    private static final double MOVIMIENTOS_INICIALES = 0;

    /**Creación de partida fácil**/

    @Test
    public void creoJuegoFacil() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaFacil();
        Juego juego = director.obtenerPartida();

        assert (director.obtenerCoordenadaMeta() >= 0);
        assert (director.obtenerCoordenadaMeta() <= LONGITUD_MAPA);
        assert (juego != null);
    }

    @Test
    public void creoJuegoFacilVerificoElMapaInterno() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaFacil();
        Juego juego = director.obtenerPartida();
        Mapa mapa = juego.obtenerMapa();
        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();

        assert (cantidadObstaculos != 0);
        assert (cantidadSorpresas != 0);
        assert (mapa.dimension() == LONGITUD_MAPA);
        assert (mapa.cantidadMeta() == CANTIDAD_META);
    }

    @Test
    public void creoJuegoFacilConUnAuto() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaFacil();
        director.asignarAutoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.estadoActual() == Auto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoFacilConUnaCamioneta() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaFacil();
        director.asignarCamionetaInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.estadoActual() == Camioneta.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoFacilConUnaMoto() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaFacil();
        director.asignarMotoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.estadoActual() == Moto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoPartidaFacilConCodigo() {
        JuegoDirector director = new JuegoDirector(1, 5);
        Juego juego = director.obtenerPartida();

        assert (director.obtenerCoordenadaMeta() == 5);
        assert (juego != null);
        assert (juego.obtenerMapa() != null);
    }

    @Test
    public void creoJuegoFacilConCodigoVerificoElMapaInterno() {
        JuegoDirector director = new JuegoDirector(1, 5);
        Juego juego = director.obtenerPartida();
        Mapa mapa = juego.obtenerMapa();
        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();

        assert (cantidadObstaculos != 0);
        assert (cantidadSorpresas != 0);
        assert (mapa.dimension() == LONGITUD_MAPA);
        assert (mapa.cantidadMeta() == CANTIDAD_META);
    }

    /**Creación de partida normal**/

    @Test
    public void creoJuegoNormal() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaNormal();
        Juego juego = director.obtenerPartida();

        assert (director.obtenerCoordenadaMeta() >= 0);
        assert (director.obtenerCoordenadaMeta() <= LONGITUD_MAPA);
        assert (juego != null);
    }

    @Test
    public void creoJuegoNormalVerificoElMapaInterno() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaNormal();
        Juego juego = director.obtenerPartida();
        Mapa mapa = juego.obtenerMapa();
        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();

        assert (cantidadObstaculos != 0);
        assert (cantidadSorpresas != 0);
        assert (mapa.dimension() == LONGITUD_MAPA);
        assert (mapa.cantidadMeta() == CANTIDAD_META);
    }

    @Test
    public void creoJuegoNormalConUnAuto() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaNormal();
        director.asignarAutoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.estadoActual() == Auto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoNormalConUnaCamioneta() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaNormal();
        director.asignarCamionetaInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.estadoActual() == Camioneta.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoNormalConUnaMoto() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaNormal();
        director.asignarMotoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.estadoActual() == Moto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoPartidaNormalConCodigo() {
        JuegoDirector director = new JuegoDirector(1, 5);
        Juego juego = director.obtenerPartida();

        assert (director.obtenerCoordenadaMeta() == 5);
        assert (juego != null);
        assert (juego.obtenerMapa() != null);
    }

    @Test
    public void creoJuegoNormalConCodigoVerificoElMapaInterno() {
        JuegoDirector director = new JuegoDirector(2, 5);
        Juego juego = director.obtenerPartida();
        Mapa mapa = juego.obtenerMapa();
        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();

        assert (cantidadObstaculos != 0);
        assert (cantidadSorpresas != 0);
        assert (mapa.dimension() == LONGITUD_MAPA);
        assert (mapa.cantidadMeta() == CANTIDAD_META);
    }

    /**Creación de partida díficil**/

    @Test
    public void creoJuegoDificil() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaDificil();
        Juego juego = director.obtenerPartida();

        assert (director.obtenerCoordenadaMeta() >= 0);
        assert (director.obtenerCoordenadaMeta() <= LONGITUD_MAPA);
        assert (juego != null);
    }

    @Test
    public void creoJuegoDificilVerificoElMapaInterno() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaDificil();
        Juego juego = director.obtenerPartida();
        Mapa mapa = juego.obtenerMapa();
        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();

        assert (cantidadObstaculos != 0);
        assert (cantidadSorpresas != 0);
        assert (mapa.dimension() == LONGITUD_MAPA);
        assert (mapa.cantidadMeta() == CANTIDAD_META);
    }

    @Test
    public void creoJuegoDificilConUnAuto() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaDificil();
        director.asignarAutoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.estadoActual() == Auto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoDificilConUnaCamioneta() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaDificil();
        director.asignarCamionetaInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.estadoActual() == Camioneta.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoDificilConUnaMoto() {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaDificil();
        director.asignarMotoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.estadoActual() == Moto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoPartidaDificilConCodigo() {
        JuegoDirector director = new JuegoDirector(3, 5);
        Juego juego = director.obtenerPartida();

        assert (director.obtenerCoordenadaMeta() == 5);
        assert (juego != null);
        assert (juego.obtenerMapa() != null);
    }

    @Test
    public void creoJuegoDificilConCodigoVerificoElMapaInterno() {
        JuegoDirector director = new JuegoDirector(3, 5);
        Juego juego = director.obtenerPartida();
        Mapa mapa = juego.obtenerMapa();
        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();

        assert (cantidadObstaculos != 0);
        assert (cantidadSorpresas != 0);
        assert (mapa.dimension() == LONGITUD_MAPA);
        assert (mapa.cantidadMeta() == CANTIDAD_META);
    }

}
