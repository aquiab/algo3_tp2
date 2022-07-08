package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.estado.*;
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
        Jugador primeraPartida = spy(new Jugador("Cosme Fulanito", ranking));
        primeraPartida.ingresarPuntaje(100);

        when(primeraPartida.obtenerPuntaje()).thenReturn((double)100);
        when(primeraPartida.getMovimientos()).thenReturn((double)100);

        Jugador segundaPartida = spy(new Jugador("Cosme Fulanito", ranking));
        segundaPartida.ingresarPuntaje(120);

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
        Jugador primeraPartida = spy(new Jugador("Cosme Fulanito", ranking));
        primeraPartida.ingresarPuntaje(100);

        when(primeraPartida.obtenerPuntaje()).thenReturn((double)100);
        when(primeraPartida.getMovimientos()).thenReturn((double)100);

        Jugador segundaPartida = spy(new Jugador("El Gordo Tony", ranking));
        segundaPartida.ingresarPuntaje(100);

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
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        juego.aplicarJugador("Pedro");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());

        //act
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();
        juego.reiniciarJuego();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.aplicarJugador("Aquiles");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();

        //assert
        assert(juego.ranking.devolverGanador().obtenerNombre().equals("Aquiles"));
        assert(juego.ranking.devolverGanador().obtenerNombre().equals("Pedro"));
    }

    @Test
    public void TresJugadoresRankingTest() {
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        juego.aplicarJugador("Pedro");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();
        //
        juego.reiniciarJuego();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.aplicarJugador("Aquiles");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();
        //
        juego.reiniciarJuego();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.aplicarJugador("Campi");
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(sorpresaFavFabrica.crearSorpresa());
        juego.mover(new DireccionDerecha());
        juego.obtenerVehiculo().ganar();

        //assert
        assert(juego.ranking.devolverGanador().obtenerNombre().equals("Campi"));
        assert(juego.ranking.devolverGanador().obtenerNombre().equals("Aquiles"));
        assert(juego.ranking.devolverGanador().obtenerNombre().equals("Pedro"));
    }
}