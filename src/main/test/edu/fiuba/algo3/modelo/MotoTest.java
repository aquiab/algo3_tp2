package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modificadores.*;
import org.junit.jupiter.api.Test;

public class MotoTest {
    @Test
    public void MotoEncuentraPozoTest() {
        //Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstado(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Pozo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new Vacio());
        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.vehiculo.movimientos == 3);
    }
    @Test
    public void MotoEncuentraPiqueteTest() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstado(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Piquete());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new Vacio());
        //act
        juego.mover(new DireccionDerecha());
        //assert
        assert(juego.vehiculo.posicion.x == 1);
        assert(juego.vehiculo.posicion.y == 0);
        assert(juego.vehiculo.movimientos == 2);
    }
    @Test
    public void MotoEncuentraPolicialTest() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstado(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new ControlPolicial());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new Vacio());
        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.vehiculo.movimientos == 3 || juego.vehiculo.movimientos == 1);
    }
    @Test
    public void MotoEncuentraPiqueteYPozoTest() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstado(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Pozo());
        juego.mapa.callesHorizontales.get(2).get(0).agregarObstaculo(new Piquete());
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new Vacio());
        juego.mapa.callesHorizontales.get(2).get(0).agregarSorpresa(new Vacio());
        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());
        //assert
        assert(juego.vehiculo.posicion.x == 2);
        assert(juego.vehiculo.posicion.y == 0);
        assert(juego.vehiculo.movimientos == 5);
    }

    @Test
    public void MotoEncuentraSorpresaCambioVehiculo() {
        //arrange
        Juego juego = new Juego();
        juego.aplicarEstado(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new SorpresaVehiculo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Vacio());
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
        juego.aplicarEstado(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new SorpresaFavorable());
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Vacio());
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
        juego.aplicarEstado(new Moto(juego.vehiculo));
        juego.mapa.callesVerticales.get(0).get(1).agregarSorpresa(new SorpresaDesfavorable());
        juego.mapa.callesVerticales.get(0).get(1).agregarObstaculo(new Vacio());
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
        juego.aplicarEstado(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new SorpresaVehiculo());
        juego.mapa.callesHorizontales.get(2).get(0).agregarSorpresa(new SorpresaVehiculo());
        juego.mapa.callesHorizontales.get(3).get(0).agregarSorpresa(new SorpresaVehiculo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Vacio());
        juego.mapa.callesHorizontales.get(2).get(0).agregarObstaculo(new Vacio());
        juego.mapa.callesHorizontales.get(3).get(0).agregarObstaculo(new Vacio());
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
        juego.aplicarEstado(new Moto(juego.vehiculo));
        juego.mapa.callesHorizontales.get(1).get(0).agregarSorpresa(new SorpresaVehiculo());
        juego.mapa.callesHorizontales.get(2).get(0).agregarSorpresa(new SorpresaVehiculo());
        juego.mapa.callesHorizontales.get(1).get(0).agregarObstaculo(new Vacio());
        juego.mapa.callesHorizontales.get(2).get(0).agregarObstaculo(new Vacio());
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
