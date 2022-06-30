package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.constructores.Director;
import org.junit.jupiter.api.Test;

public class RankingTest {
    
    private Director director = new Director();
    @Test
    public void DosJugadoresRankingTest() {
        //Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        juego.aplicarJugador("Pedro");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(director.generarPozo(juego.obtenerEstadoActual()));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(director.generarVacioSorpresa());
        //act
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();
        juego.reiniciarJuego();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.aplicarJugador("Aquiles");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(director.generarPozo(juego.obtenerEstadoActual()));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(director.generarVacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();

        //assert
        assert(juego.ranking.devolverGanador().nombre == "Aquiles" );
        assert(juego.ranking.devolverGanador().nombre == "Pedro");
    }
    @Test
    public void TresJugadoresRankingTest() {
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        juego.aplicarJugador("Pedro");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(director.generarPozo(juego.obtenerEstadoActual()));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(director.generarVacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();
        //
        juego.reiniciarJuego();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.aplicarJugador("Aquiles");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(director.generarPozo(juego.obtenerEstadoActual()));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(director.generarVacioSorpresa());
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();
        //
        juego.reiniciarJuego();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.aplicarJugador("Campi");
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(director.generarPozo(juego.obtenerEstadoActual()));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(director.generarSorpresaFavorable());
        juego.mover(new DireccionDerecha());
        juego.vehiculo.ganar();

        //assert
        assert(juego.ranking.devolverGanador().nombre == "Campi");
        assert(juego.ranking.devolverGanador().nombre == "Aquiles" );
        assert(juego.ranking.devolverGanador().nombre == "Pedro");
    }
}
