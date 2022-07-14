package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.modelo.obstaculos.*;
import edu.fiuba.algo3.modelo.sorpresas.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class RankingTest {

    private SorpresaFavorableFabrica sorpresaFavFabrica = new SorpresaFavorableFabrica();

    @Test
    public void rankingInicialmenteEstaVacio() {
        Ranking ranking = new Ranking();

        Jugador primerLugar = ranking.devolverGanador();
        assert (primerLugar == null);
    }

    @Test
    public void unUnicoJugadorAnotaDosPuntajesDiferentsTest() {
        Ranking ranking = new Ranking();
        Jugador primeraPartida = spy(new Jugador("Cosme Fulanito"));
        primeraPartida.ingresarPuntaje(100);
        ranking.agregarJugador(primeraPartida);

        when(primeraPartida.obtenerPuntaje()).thenReturn((double)100);
        when(primeraPartida.getMovimientos()).thenReturn((double)100);

        Jugador segundaPartida = spy(new Jugador("Cosme Fulanito"));
        segundaPartida.ingresarPuntaje(120);
        ranking.agregarJugador(segundaPartida);

        when(segundaPartida.obtenerPuntaje()).thenReturn((double)120);
        when(segundaPartida.getMovimientos()).thenReturn((double)120);

        Jugador primerLugar = ranking.devolverGanador();
        assert(primerLugar == primeraPartida);
        assert(primerLugar.obtenerNombre() == "Cosme Fulanito");
        assert(primerLugar.obtenerPuntaje() == 100);
    }

    @Test
    public void DosJugadoresAnotanIgualPrimerLugarPrimeraPartidaTest() {
        Ranking ranking = new Ranking();
        Jugador primeraPartida = spy(new Jugador("Cosme Fulanito"));
        primeraPartida.ingresarPuntaje(100);
        ranking.agregarJugador(primeraPartida);

        when(primeraPartida.obtenerPuntaje()).thenReturn((double)100);
        when(primeraPartida.getMovimientos()).thenReturn((double)100);

        Jugador segundaPartida = spy(new Jugador("El Gordo Tony"));
        segundaPartida.ingresarPuntaje(100);
        ranking.agregarJugador(segundaPartida);

        when(segundaPartida.obtenerPuntaje()).thenReturn((double)100);
        when(segundaPartida.getMovimientos()).thenReturn((double)100);

        Jugador primerLugar = ranking.devolverGanador();
        assert(primerLugar == primeraPartida);
        assert(primerLugar.obtenerNombre() == "Cosme Fulanito");
        assert(primerLugar.obtenerPuntaje() == 100);
    }

    @Test
    public void DosJugadoresRankingTest() {
        //Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
        //arrange
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();
        Juego juego = director.obtenerPartida();
        director.asignarAutoInicial();
        juego.aplicarJugador("Pedro");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());

        //act
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();

        director.configurarPartidaNormal();
        juego = director.obtenerPartida();
        director.asignarCamionetaInicial();
        juego.aplicarJugador("Aquiles");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();

        //assert
        assert(director.obtenerRanking().devolverGanador().obtenerNombre().equals("Aquiles"));
        assert(director.obtenerRanking().devolverGanador().obtenerNombre().equals("Pedro"));
    }

    @Test
    public void TresJugadoresRankingTest() {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.configurarPartidaNormal();
        director.asignarAutoInicial();
        Juego juego = director.obtenerPartida();
        juego.aplicarJugador("Pedro");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());

        //act
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();

        director.configurarPartidaNormal();
        juego = director.obtenerPartida();
        director.asignarCamionetaInicial();
        juego.aplicarJugador("Aquiles");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();
        //
        director.configurarPartidaNormal();
        juego = director.obtenerPartida();
        director.asignarCamionetaInicial();
        juego.aplicarJugador("Campi");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(sorpresaFavFabrica.crearSorpresa());
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();

        //assert
        assert(director.obtenerRanking().devolverGanador().obtenerNombre().equals("Campi"));
        assert(director.obtenerRanking().devolverGanador().obtenerNombre().equals("Aquiles"));
        assert(director.obtenerRanking().devolverGanador().obtenerNombre().equals("Pedro"));
    }
}