package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.constructor_juego.JuegoConstructor;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.estado.Moto;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.Pozo;
import org.junit.jupiter.api.Test;

public class JuegoConstructorTest {

    private static final int OBSTACULO = 0;
    private static final int SORPRESA = 1;

    @Test
    public void creoJuegoNoEsNulo() {
        JuegoConstructor constructor = new JuegoConstructor();

        assert (constructor.construir() != null);
        assert (constructor.construir().getClass() == Juego.class);
    }

    @Test
    public void creoJuegoSeteandoLongitudMapa() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5);

        Juego juego = constructor.construir();
        Mapa mapa = juego.obtenerMapa();

        assert (mapa != null);
        assert (mapa.dimension() == 5);
    }

    @Test
    public void creoJuegoSeteandoAuto() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .asignarAutoInicial();

        Juego juego = constructor.construir();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo!= null);
        assert (vehiculo.estadoActual() == Auto.class);
    }

    @Test
    public void creoJuegoSeteandoCamioneta() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .asignarCamionetaInicial();

        Juego juego = constructor.construir();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo!= null);
        assert (vehiculo.estadoActual() == Camioneta.class);
    }

    @Test
    public void creoJuegoSeteandoMoto() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .asignarMotoInicial();

        Juego juego = constructor.construir();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo!= null);
        assert (vehiculo.estadoActual() == Moto.class);
    }

    @Test
    public void creoJuegoSeteandoCantidadDePozos() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .agregarPozos(10);
        Juego juego = constructor.construir();
        Mapa mapa = juego.obtenerMapa();

        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();
        assert (cantidadObstaculos != 0);
        assert (cantidadSorpresas == 0);
    }

    @Test
    public void creoJuegoSeteandoCantidadDePiquetes() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .agregarPiquetes(10);
        Juego juego = constructor.construir();
        Mapa mapa = juego.obtenerMapa();

        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();
        assert (cantidadObstaculos != 0);
        assert (cantidadSorpresas == 0);
    }

    @Test
    public void creoJuegoSeteandoCantidadDeControles() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .agregarControlesPoliciales(10);
        Juego juego = constructor.construir();
        Mapa mapa = juego.obtenerMapa();

        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();
        assert (cantidadObstaculos != 0);
        assert (cantidadSorpresas == 0);
    }

    @Test
    public void creoJuegoSeteandoCantidadDeSorpresasFavorables() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .agregarSorpresasFavorables(10);
        Juego juego = constructor.construir();
        Mapa mapa = juego.obtenerMapa();

        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();
        assert (cantidadObstaculos == 0);
        assert (cantidadSorpresas != 0);
    }

    @Test
    public void creoJuegoSeteandoCantidadDeSorpresasDesfavorables() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .agregarSorpresasDesfavorables(10);
        Juego juego = constructor.construir();
        Mapa mapa = juego.obtenerMapa();

        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();
        assert (cantidadObstaculos == 0);
        assert (cantidadSorpresas != 0);
    }

    @Test
    public void creoJuegoSeteandoCantidadDeSorpresasDeVehiculo() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .agregarSorpresasCambioDeVehiculo(10);
        Juego juego = constructor.construir();
        Mapa mapa = juego.obtenerMapa();

        int cantidadObstaculos = mapa.cantidadObstaculos();
        int cantidadSorpresas = mapa.cantidadSorpresa();
        assert (cantidadObstaculos == 0);
        assert (cantidadSorpresas != 0);
    }

    @Test
    public void creoJuegoSeteandoLugarDeMeta() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(5)
                .agregarMetaEn(2);
        Juego juego = constructor.construir();

        assert (juego.obtenerCoordenadaMeta() == 2);
    }

}
