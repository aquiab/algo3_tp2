package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.constructor_juego.JuegoConstructor;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.estado.Moto;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;

public class JuegoDirectorTest {

    private static final int LONGITUD_MAPA = 10;
    private static final double MOVIMIENTOS_INICIALES = 0;

    /**Creación de partida fácil**/

    @Test
    public void creoJuegoFacil() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaFacil();
        Juego juego = director.obtenerPartida();

        assert (director.obtenerCoordenadaMeta() >= 0);
        assert (director.obtenerCoordenadaMeta() <= LONGITUD_MAPA);
        assert (juego != null);
    }

    @Test
    public void creoJuegoFacilVerificoMeta() {
        Posicion pos = mock(Posicion.class);
        MockedStatic<ValoresAleatorios> valores = mockStatic(ValoresAleatorios.class);
        valores.when(() -> ValoresAleatorios.valorAleatorio()).thenReturn(5);
        valores.when(() -> ValoresAleatorios.obtenerPosicionAleatoria(anyInt(), any())).thenReturn(pos);

        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaFacil();

        Juego juego = director.obtenerPartida();
        assert (juego.obtenerCoordenadaMeta() == 5);
        valores.close();
    }

    @Test
    public void creoJuegoFacilVerificoLaCreacionDelMapa() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        JuegoConstructor constructor = spy(new JuegoConstructor());
        director.setConstructor(constructor);

        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).asignarLongitudMapa(10);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarPozos(5);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarPiquetes(5);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarControlesPoliciales(5);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarSorpresasFavorables(10);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarSorpresasDesfavorables(5);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarSorpresasCambioDeVehiculo(5);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarMetaEn(anyInt());
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).asignarRanking(any(Ranking.class));
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).asignarVehiculoInicial();

        director.configurarPartidaFacil();

        verify(director.obtenerConstructor(), times(1)).asignarLongitudMapa(10);
        verify(director.obtenerConstructor(), times(1)).agregarPozos(5);
        verify(director.obtenerConstructor(), times(1)).agregarPiquetes(5);
        verify(director.obtenerConstructor(), times(1)).agregarControlesPoliciales(5);
        verify(director.obtenerConstructor(), times(1)).agregarSorpresasFavorables(10);
        verify(director.obtenerConstructor(), times(1)).agregarSorpresasDesfavorables(5);
        verify(director.obtenerConstructor(), times(1)).agregarSorpresasCambioDeVehiculo(5);
        verify(director.obtenerConstructor(), times(1)).agregarMetaEn(anyInt());
        verify(director.obtenerConstructor(), times(1)).asignarRanking(any(Ranking.class));
        verify(director.obtenerConstructor(), times(1)).asignarVehiculoInicial();
    }

    @Test
    public void creoJuegoFacilConUnAuto() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaFacil();
        director.asignarAutoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.obtenerEstado().getClass() == Auto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoFacilConUnaCamioneta() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaFacil();
        director.asignarCamionetaInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoFacilConUnaMoto() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaFacil();
        director.asignarMotoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.obtenerEstado().getClass() == Moto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    /**Creación de partida normal**/

    @Test
    public void creoJuegoNormal() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();
        Juego juego = director.obtenerPartida();

        assert (director.obtenerCoordenadaMeta() >= 0);
        assert (director.obtenerCoordenadaMeta() <= LONGITUD_MAPA);
        assert (juego != null);
    }

    @Test
    public void creoJuegoNormalVerificoMeta() {
        Posicion pos = mock(Posicion.class);
        MockedStatic<ValoresAleatorios> valores = mockStatic(ValoresAleatorios.class);
        valores.when(() -> ValoresAleatorios.valorAleatorio()).thenReturn(5);
        valores.when(() -> ValoresAleatorios.obtenerPosicionAleatoria(anyInt(), any())).thenReturn(pos);

        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();

        Juego juego = director.obtenerPartida();
        assert (juego.obtenerCoordenadaMeta() == 5);
        valores.close();
    }

    @Test
    public void creoJuegoNormalVerificoLaCreacionDelMapa() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        JuegoConstructor constructor = spy(new JuegoConstructor());
        director.setConstructor(constructor);

        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).asignarLongitudMapa(12);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarPozos(10);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarPiquetes(10);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarControlesPoliciales(10);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarSorpresasFavorables(5);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarSorpresasDesfavorables(10);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarSorpresasCambioDeVehiculo(10);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarMetaEn(anyInt());
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).asignarRanking(any(Ranking.class));
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).asignarVehiculoInicial();

        director.configurarPartidaNormal();

        verify(director.obtenerConstructor(), times(1)).asignarLongitudMapa(12);
        verify(director.obtenerConstructor(), times(1)).agregarPozos(10);
        verify(director.obtenerConstructor(), times(1)).agregarPiquetes(10);
        verify(director.obtenerConstructor(), times(1)).agregarControlesPoliciales(10);
        verify(director.obtenerConstructor(), times(1)).agregarSorpresasFavorables(5);
        verify(director.obtenerConstructor(), times(1)).agregarSorpresasDesfavorables(10);
        verify(director.obtenerConstructor(), times(1)).agregarSorpresasCambioDeVehiculo(10);
        verify(director.obtenerConstructor(), times(1)).agregarMetaEn(anyInt());
        verify(director.obtenerConstructor(), times(1)).asignarRanking(any(Ranking.class));
        verify(director.obtenerConstructor(), times(1)).asignarVehiculoInicial();
    }

    @Test
    public void creoJuegoNormalConUnAuto() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();
        director.asignarAutoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.obtenerEstado().getClass() == Auto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoNormalConUnaCamioneta() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();
        director.asignarCamionetaInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoNormalConUnaMoto() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();
        director.asignarMotoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.obtenerEstado().getClass() == Moto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    /**Creación de partida díficil**/

    @Test
    public void creoJuegoDificil() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaDificil();
        Juego juego = director.obtenerPartida();

        assert (director.obtenerCoordenadaMeta() >= 0);
        assert (director.obtenerCoordenadaMeta() <= LONGITUD_MAPA);
        assert (juego != null);
    }

    @Test
    public void creoJuegoDificilVerificoMeta() {
        Posicion pos = mock(Posicion.class);
        MockedStatic<ValoresAleatorios> valores = mockStatic(ValoresAleatorios.class);
        valores.when(() -> ValoresAleatorios.valorAleatorio()).thenReturn(5);
        valores.when(() -> ValoresAleatorios.obtenerPosicionAleatoria(anyInt(), any())).thenReturn(pos);

        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaDificil();

        Juego juego = director.obtenerPartida();
        assert (juego.obtenerCoordenadaMeta() == 5);
        valores.close();
    }

    @Test
    public void creoJuegoDificilVerificoLaCreacionDelMapa() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        JuegoConstructor constructor = spy(new JuegoConstructor());
        director.setConstructor(constructor);

        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).asignarLongitudMapa(14);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarPozos(15);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarPiquetes(15);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarControlesPoliciales(15);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarSorpresasFavorables(0);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarSorpresasDesfavorables(10);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarSorpresasCambioDeVehiculo(10);
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).agregarMetaEn(anyInt());
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).asignarRanking(any(Ranking.class));
        doAnswer(i->director.obtenerConstructor()).when(director.obtenerConstructor()).asignarVehiculoInicial();

        director.configurarPartidaDificil();

        verify(director.obtenerConstructor(), times(1)).asignarLongitudMapa(14);
        verify(director.obtenerConstructor(), times(1)).agregarPozos(15);
        verify(director.obtenerConstructor(), times(1)).agregarPiquetes(15);
        verify(director.obtenerConstructor(), times(1)).agregarControlesPoliciales(15);
        verify(director.obtenerConstructor(), times(1)).agregarSorpresasFavorables(0);
        verify(director.obtenerConstructor(), times(1)).agregarSorpresasDesfavorables(10);
        verify(director.obtenerConstructor(), times(1)).agregarSorpresasCambioDeVehiculo(10);
        verify(director.obtenerConstructor(), times(1)).agregarMetaEn(anyInt());
        verify(director.obtenerConstructor(), times(1)).asignarRanking(any(Ranking.class));
        verify(director.obtenerConstructor(), times(1)).asignarVehiculoInicial();
    }

    @Test
    public void creoJuegoDificilConUnAuto() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaDificil();
        director.asignarAutoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.obtenerEstado().getClass() == Auto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoDificilConUnaCamioneta() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaDificil();
        director.asignarCamionetaInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

    @Test
    public void creoJuegoDificilConUnaMoto() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaDificil();
        director.asignarMotoInicial();
        Juego juego = director.obtenerPartida();
        Vehiculo vehiculo = juego.obtenerVehiculo();

        assert (vehiculo != null);
        assert (vehiculo.obtenerEstado().getClass() == Moto.class);
        assert (vehiculo.obtenerMovimientos() == MOVIMIENTOS_INICIALES);
    }

}
