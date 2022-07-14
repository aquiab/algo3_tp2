package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.estado.*;
import edu.fiuba.algo3.modelo.obstaculos.*;
import edu.fiuba.algo3.modelo.sorpresas.*;

import org.junit.jupiter.api.Test;

public class CamionetaTest {

    private SorpresaFavorableFabrica sorpresaFavFabrica =  new SorpresaFavorableFabrica();
    private SorpresaDesfavorableFabrica sorpresaDesfavFabrica = new SorpresaDesfavorableFabrica();
    
    @Test
    public void CamionetaEncuentraPozoTest() {
        //Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 1);
    }
    @Test
    public void CamionetaEncuentra3PozosTest() {
        //Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(3, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarSorpresa(new VacioSorpresa());
        juego.obtenerMapa().obtenerCalleHorizontal(3, 0).agregarSorpresa(new VacioSorpresa());

        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 3);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 5);
    }
    @Test
    public void CamionetaEncuentraPiqueteTest() {
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Piquete());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 0);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 1);
    }
    @Test
    public void CamionetaEncuentraPolicialTest() {
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new ControlPolicial());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 4 || juego.obtenerVehiculo().obtenerMovimientos() == 1);
    }
    @Test
    public void CamionetaEncuentraPiqueteYPozoTest() {
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new Pozo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarObstaculo(new Piquete());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new VacioSorpresa());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarSorpresa(new VacioSorpresa());

        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 1);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 2);
    }

    @Test
    public void CamionetaEncuentraSorpresaCambioVehiculo() {
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new SorpresaVehiculo());

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 1);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 1);
        assert(juego.obtenerVehiculo().obtenerEstado().getClass() == Moto.class);
    }
    @Test
    public void CamionetaEncuentraSorpresaFavorable() {
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(sorpresaFavFabrica.crearSorpresa());

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 1);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 0.8);
        assert(juego.obtenerVehiculo().obtenerEstado().getClass() == Camioneta.class);
    }
    @Test
    public void CamionetaEncuentraSorpresaDesavorable() {
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleVertical(0, 1).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleVertical(0, 1).agregarSorpresa(sorpresaDesfavFabrica.crearSorpresa());

        //act
        juego.mover(new DireccionAbajo());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 0);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 1);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 1.25);
        assert(juego.obtenerVehiculo().obtenerEstado().getClass() == Camioneta.class);
    }
    @Test
    public void CamionetaEncuentraSorpresaCambioVehiculo3Veces() {
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new SorpresaVehiculo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarSorpresa(new SorpresaVehiculo());
        juego.obtenerMapa().obtenerCalleHorizontal(3, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(3, 0).agregarSorpresa(new SorpresaVehiculo());

        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 3);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 3);
        assert(juego.obtenerVehiculo().obtenerEstado().getClass() == Camioneta.class);
    }
    @Test
    public void CamionetaEncuentraSorpresaCambioVehiculo2veces() {
        //arrange
        Juego juego = new Juego();
        juego.asignarMapa(new Mapa(5));
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.obtenerVehiculo()));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(new SorpresaVehiculo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarSorpresa(new SorpresaVehiculo());

        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 2);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 2);
        assert(juego.obtenerVehiculo().obtenerEstado().getClass() == Auto.class);
    }
}