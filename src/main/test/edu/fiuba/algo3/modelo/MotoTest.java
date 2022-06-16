package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

public class MotoTest {
	@Test
    public void MotoEncuentraPozoTest() {
        Juego juego = new Juego();

        Modificador cambio = new SorpresaVehiculo();
        juego.mapa.callesHorizontales.get(1).get(0).sorpresa = cambio;
        juego.mover(new DireccionDerecha(juego.mapa));

        cambio = new SorpresaVehiculo();
        juego.mapa.callesHorizontales.get(2).get(0).sorpresa = cambio;
        juego.mover(new DireccionDerecha(juego.mapa));

        Modificador pozo = new Pozo();
        juego.mapa.callesHorizontales.get(3).get(0).obstaculo = pozo;
        juego.mover(new DireccionDerecha(juego.mapa));

        assert(juego.vehiculo.movimientos == 2 + 4);
    }
}
