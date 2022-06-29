package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.modificadores.*;

/*public class RankingTest {
    @Test
    public void DosJugadoresRankingTest() {
        //Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstado(new Auto(juego.vehiculo));
        juego.aplicarJugador("Pedro");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Pozo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new VacioSorpresa());
        //act
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();
        juego.reiniciarJuego();
        juego.aplicarEstado(new Camioneta(juego.vehiculo));
        juego.aplicarJugador("Aquiles");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Pozo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new VacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();

        //assert
        assert(juego.ranking.devolverGanador().nombre == "Aquiles" );
        assert(juego.ranking.devolverGanador().nombre == "Pedro");
    }
    @Test
    public void TresJugadoresRankingTest() {
        Juego juego = new Juego();
        juego.aplicarEstado(new Auto(juego.vehiculo));
        juego.aplicarJugador("Pedro");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Pozo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new VacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();
        //
        juego.reiniciarJuego();
        juego.aplicarEstado(new Camioneta(juego.vehiculo));
        juego.aplicarJugador("Aquiles");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Pozo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new VacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();
        //
        juego.reiniciarJuego();
        juego.aplicarEstado(new Camioneta(juego.vehiculo));
        juego.aplicarJugador("Campi");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Pozo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new SorpresaFavorable());
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();

        //assert
        assert(juego.ranking.devolverGanador().nombre == "Campi");
        assert(juego.ranking.devolverGanador().nombre == "Aquiles" );
        assert(juego.ranking.devolverGanador().nombre == "Pedro");
    }
}*/
