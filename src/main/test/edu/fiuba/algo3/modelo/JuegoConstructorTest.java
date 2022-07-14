package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.constructor_juego.JuegoConstructor;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.modelo.estado.*;
import edu.fiuba.algo3.modelo.obstaculos.*;
import edu.fiuba.algo3.modelo.sorpresas.*;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;

public class JuegoConstructorTest {

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
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();
        director.asignarAutoInicial();

        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo!= null);
        assert (vehiculo.obtenerEstado().getClass() == Auto.class);
    }

    @Test
    public void creoJuegoSeteandoCamioneta() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();
        director.asignarCamionetaInicial();

        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo!= null);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);
    }

    @Test
    public void creoJuegoSeteandoMoto() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();
        director.asignarMotoInicial();

        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo!= null);
        assert (vehiculo.obtenerEstado().getClass() == Moto.class);
    }

    @Test
    public void creoJuegoSeteandoCantidadDePozos() {
        JuegoConstructor constructor = spy(new JuegoConstructor());
        Juego juego = mock(Juego.class);
        Posicion pos = mock(Posicion.class);
        MockedStatic<ValoresAleatorios> valores = mockStatic(ValoresAleatorios.class);
        valores.when(() -> ValoresAleatorios.obtenerPosicionAleatoria(anyInt(), any())).thenReturn(pos);

        doAnswer(i -> {
            juego.asignarMapa(new Mapa(5));
            return constructor;
        }).when(constructor).asignarLongitudMapa(5);
        doNothing().when(constructor).agregarObstaculoEnCalleHorizontal(any(), any(Posicion.class), any(Pozo.class));
        doNothing().when(constructor).agregarObstaculoEnCalleVertical(any(), any(Posicion.class), any(Pozo.class));

        constructor.asignarLongitudMapa(5)
                .agregarPozos(10);

        verify(constructor, times(1)).agregarPozos(10);
        verify(constructor, times(5)).agregarObstaculoEnCalleHorizontal(any(), any(Posicion.class), any(Pozo.class));
        verify(constructor, times(5)).agregarObstaculoEnCalleVertical(any(), any(Posicion.class), any(Pozo.class));
        valores.close();
    }

    @Test
    public void creoJuegoSeteandoCantidadDePiquetes() {
        JuegoConstructor constructor = spy(new JuegoConstructor());
        Juego juego = mock(Juego.class);
        Posicion pos = mock(Posicion.class);
        MockedStatic<ValoresAleatorios> valores = mockStatic(ValoresAleatorios.class);
        valores.when(() -> ValoresAleatorios.obtenerPosicionAleatoria(anyInt(), any())).thenReturn(pos);

        doAnswer(i -> {
            juego.asignarMapa(new Mapa(5));
            return constructor;
        }).when(constructor).asignarLongitudMapa(5);
        doNothing().when(constructor).agregarObstaculoEnCalleHorizontal(any(), any(Posicion.class), any(Piquete.class));
        doNothing().when(constructor).agregarObstaculoEnCalleVertical(any(), any(Posicion.class), any(Piquete.class));

        constructor.asignarLongitudMapa(5)
                .agregarPiquetes(20);

        verify(constructor, times(1)).agregarPiquetes(20);
        verify(constructor, times(10)).agregarObstaculoEnCalleHorizontal(any(), any(Posicion.class), any(Piquete.class));
        verify(constructor, times(10)).agregarObstaculoEnCalleVertical(any(), any(Posicion.class), any(Piquete.class));
        valores.close();
    }

    @Test
    public void creoJuegoSeteandoCantidadDeControles() {
        JuegoConstructor constructor = spy(new JuegoConstructor());
        Juego juego = mock(Juego.class);
        Posicion pos = mock(Posicion.class);
        MockedStatic<ValoresAleatorios> valores = mockStatic(ValoresAleatorios.class);
        valores.when(() -> ValoresAleatorios.obtenerPosicionAleatoria(anyInt(), any())).thenReturn(pos);

        doAnswer(i -> {
            juego.asignarMapa(new Mapa(5));
            return constructor;
        }).when(constructor).asignarLongitudMapa(5);
        doNothing().when(constructor).agregarObstaculoEnCalleHorizontal(any(), any(Posicion.class), any(ControlPolicial.class));
        doNothing().when(constructor).agregarObstaculoEnCalleVertical(any(), any(Posicion.class), any(ControlPolicial.class));

        constructor.asignarLongitudMapa(5)
                .agregarControlesPoliciales(10);

        verify(constructor, times(1)).agregarControlesPoliciales(10);
        verify(constructor, times(5)).agregarObstaculoEnCalleHorizontal(any(), any(Posicion.class), any(ControlPolicial.class));
        verify(constructor, times(5)).agregarObstaculoEnCalleVertical(any(), any(Posicion.class), any(ControlPolicial.class));
        valores.close();
    }

    @Test
    public void creoJuegoSeteandoCantidadDeSorpresasFavorables() {
        JuegoConstructor constructor = spy(new JuegoConstructor());
        Juego juego = mock(Juego.class);
        Posicion pos = mock(Posicion.class);
        SorpresaFavorableFabrica fabrica = mock(SorpresaFavorableFabrica.class);
        SorpresaPuntaje sorpresa = mock(SorpresaPuntaje.class);
        MockedStatic<ValoresAleatorios> valores = mockStatic(ValoresAleatorios.class);
        valores.when(() -> ValoresAleatorios.obtenerPosicionAleatoria(anyInt(), any())).thenReturn(pos);

        when(fabrica.crearSorpresa()).thenReturn(sorpresa);

        doAnswer(i -> {
            juego.asignarMapa(new Mapa(5));
            return constructor;
        }).when(constructor).asignarLongitudMapa(5);
        doNothing().when(constructor).agregarSorpresaEnCalleHorizontal(any(), any(Posicion.class), any(SorpresaPuntaje.class));
        doNothing().when(constructor).agregarSorpresaEnCalleVertical(any(), any(Posicion.class), any(SorpresaPuntaje.class));

        constructor.asignarLongitudMapa(5)
                .agregarSorpresasFavorables(10);

        verify(constructor, times(1)).agregarSorpresasFavorables(10);
        verify(constructor, never()).agregarSorpresasDesfavorables(10);
        verify(constructor, times(5)).agregarSorpresaEnCalleHorizontal(any(), any(Posicion.class), any(SorpresaPuntaje.class));
        verify(constructor, times(5)).agregarSorpresaEnCalleHorizontal(any(), any(Posicion.class), any(SorpresaPuntaje.class));

        valores.close();
    }

    @Test
    public void creoJuegoSeteandoCantidadDeSorpresasDesfavorables() {
        JuegoConstructor constructor = spy(new JuegoConstructor());
        Juego juego = mock(Juego.class);
        Posicion pos = mock(Posicion.class);
        SorpresaDesfavorableFabrica fabrica = mock(SorpresaDesfavorableFabrica.class);
        SorpresaPuntaje sorpresa = mock(SorpresaPuntaje.class);

        MockedStatic<ValoresAleatorios> valores = mockStatic(ValoresAleatorios.class);
        valores.when(() -> ValoresAleatorios.obtenerPosicionAleatoria(anyInt(), any())).thenReturn(pos);

        when(fabrica.crearSorpresa()).thenReturn(sorpresa);

        doAnswer(i -> {
            juego.asignarMapa(new Mapa(5));
            return constructor;
        }).when(constructor).asignarLongitudMapa(5);
        doNothing().when(constructor).agregarSorpresaEnCalleHorizontal(any(), any(Posicion.class), any(SorpresaPuntaje.class));
        doNothing().when(constructor).agregarSorpresaEnCalleVertical(any(), any(Posicion.class), any(SorpresaPuntaje.class));

        constructor.asignarLongitudMapa(5)
                .agregarSorpresasDesfavorables(10);

        verify(constructor, times(1)).agregarSorpresasDesfavorables(10);
        verify(constructor, never()).agregarSorpresasFavorables(10);
        verify(constructor, times(5)).agregarSorpresaEnCalleHorizontal(any(), any(Posicion.class), any(SorpresaPuntaje.class));
        verify(constructor, times(5)).agregarSorpresaEnCalleHorizontal(any(), any(Posicion.class), any(SorpresaPuntaje.class));
        valores.close();
    }

    @Test
    public void creoJuegoSeteandoCantidadDeSorpresasDeVehiculo() {
        JuegoConstructor constructor = spy(new JuegoConstructor());
        Juego juego = mock(Juego.class);
        Posicion pos = mock(Posicion.class);
        MockedStatic<ValoresAleatorios> valores = mockStatic(ValoresAleatorios.class);
        valores.when(() -> ValoresAleatorios.obtenerPosicionAleatoria(anyInt(), any())).thenReturn(pos);

        doAnswer(i -> {
            juego.asignarMapa(new Mapa(5));
            return constructor;
        }).when(constructor).asignarLongitudMapa(5);
        doNothing().when(constructor).agregarSorpresaEnCalleHorizontal(any(), any(Posicion.class), any(SorpresaVehiculo.class));
        doNothing().when(constructor).agregarSorpresaEnCalleVertical(any(), any(Posicion.class), any(SorpresaVehiculo.class));

        constructor.asignarLongitudMapa(5)
                .agregarSorpresasCambioDeVehiculo(10);

        verify(constructor, times(1)).agregarSorpresasCambioDeVehiculo(10);
        verify(constructor, never()).agregarSorpresasFavorables(10);
        verify(constructor, never()).agregarSorpresasDesfavorables(10);
        verify(constructor, times(5)).agregarSorpresaEnCalleHorizontal(any(), any(Posicion.class), any(SorpresaVehiculo.class));
        verify(constructor, times(5)).agregarSorpresaEnCalleHorizontal(any(), any(Posicion.class), any(SorpresaVehiculo.class));
        valores.close();
    }

    @Test
    public void creoJuegoSeteandoLugarDeMeta() {
        JuegoConstructor constructor = new JuegoConstructor();
        constructor.asignarLongitudMapa(10)
                .agregarMetaEn(2);

        Juego juego = constructor.construir();
        assert (juego.obtenerCoordenadaMeta() == 2);
    }
}
