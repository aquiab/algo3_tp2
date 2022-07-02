package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.estado.Moto;
import org.junit.jupiter.api.Test;

public class MotoTest {
    
    private Fabrica fabrica = new Fabrica();
    @Test
    public void MotoEncuentraPozoTest() {
        //Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(fabrica.generarPozo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(fabrica.generarVacioSorpresa());
        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.vehiculo.movimientos == 4);
    }
    @Test
    public void MotoEncuentraPiqueteTest() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(fabrica.generarPiquete());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(fabrica.generarVacioSorpresa());
        //act
        juego.mover(new DireccionDerecha());
        //assert
        assert(juego.vehiculo.posicion.x == 1);
        assert(juego.vehiculo.posicion.y == 0);
        assert(juego.vehiculo.movimientos == 3);
    }
    @Test
    public void MotoEncuentraPolicialTest() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(fabrica.generarControlPolicial());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(fabrica.generarVacioSorpresa());
        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.vehiculo.movimientos == 4 || juego.vehiculo.movimientos == 1);
    }
    @Test
    public void MotoEncuentraPiqueteYPozoTest() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(fabrica.generarPozo());
        juego.mapa.callesHorizontales.get(2).get(0).agregarObstaculo(fabrica.generarPiquete());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(fabrica.generarVacioSorpresa());
        juego.mapa.callesHorizontales.get(2).get(0).agregarSorpresa(fabrica.generarVacioSorpresa());
        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());
        //assert
        assert(juego.vehiculo.posicion.x == 2);
        assert(juego.vehiculo.posicion.y == 0);
        assert(juego.vehiculo.movimientos == 7);
    }

    @Test
    public void MotoEncuentraSorpresaCambioVehiculo() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(fabrica.generarSorpresaCambioDeVehiculo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(fabrica.generarVacioObstaculo());
        //act
        juego.mover(new DireccionDerecha());
        //assert
        assert(juego.vehiculo.posicion.x == 1);
        assert(juego.vehiculo.posicion.y == 0);
        assert(juego.vehiculo.movimientos == 1);
        assert(juego.vehiculo.estado.getClass() == Auto.class);
    }
    @Test
    public void MotoEncuentraSorpresaFavorable() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(fabrica.generarSorpresaFavorable());
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(fabrica.generarVacioObstaculo());
        //act
        juego.mover(new DireccionDerecha());
        //assert
        assert(juego.vehiculo.posicion.x == 1);
        assert(juego.vehiculo.posicion.y == 0);
        assert(juego.vehiculo.movimientos == 0.8);
        assert(juego.vehiculo.estado.getClass() == Moto.class);
    }
    @Test
    public void MotoEncuentraSorpresaDesavorable() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Moto(juego.vehiculo));
        juego.mapa.callesVerticales.get(0).get(1).agregarSorpresa(fabrica.generarSorpresaDesfavorable());
        juego.mapa.callesVerticales.get(0).get(1).agregarObstaculo(fabrica.generarVacioObstaculo());
        //act
        juego.mover(new DireccionAbajo());
        //assert
        assert(juego.vehiculo.posicion.x == 0);
        assert(juego.vehiculo.posicion.y == 1);
        assert(juego.vehiculo.movimientos == 1.25);
        assert(juego.vehiculo.estado.getClass() == Moto.class);
    }
    @Test
    public void MotoEncuentraSorpresaCambioVehiculo3Veces() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(fabrica.generarSorpresaCambioDeVehiculo());
        juego.mapa.callesHorizontales.get(2).get(0).agregarSorpresa(fabrica.generarSorpresaCambioDeVehiculo());
        juego.mapa.callesHorizontales.get(3).get(0).agregarSorpresa(fabrica.generarSorpresaCambioDeVehiculo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(fabrica.generarVacioObstaculo());
        juego.mapa.callesHorizontales.get(2).get(0).agregarObstaculo(fabrica.generarVacioObstaculo());
        juego.mapa.callesHorizontales.get(3).get(0).agregarObstaculo(fabrica.generarVacioObstaculo());
        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());
        //assert
        assert(juego.vehiculo.posicion.x == 3);
        assert(juego.vehiculo.posicion.y == 0);
        assert(juego.vehiculo.movimientos == 3);
        assert(juego.vehiculo.estado.getClass() == Moto.class);
    }
    @Test
    public void MotoEncuentraSorpresaCambioVehiculo2veces() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(fabrica.generarSorpresaCambioDeVehiculo());
        juego.mapa.callesHorizontales.get(2).get(0).agregarSorpresa(fabrica.generarSorpresaCambioDeVehiculo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(fabrica.generarVacioObstaculo());
        juego.mapa.callesHorizontales.get(2).get(0).agregarObstaculo(fabrica.generarVacioObstaculo());
        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());
        //assert
        assert(juego.vehiculo.posicion.x == 2);
        assert(juego.vehiculo.posicion.y == 0);
        assert(juego.vehiculo.movimientos == 2);
        assert(juego.vehiculo.estado.getClass() == Camioneta.class);
    }
}
