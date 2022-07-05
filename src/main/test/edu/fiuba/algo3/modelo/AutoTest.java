package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.estado.Moto;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.ControlPolicialFabrica;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.PiqueteFabrica;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.PozoFabrica;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.VacioObstaculo;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.SorpresaDesfavorableFabrica;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.SorpresaFavorableFabrica;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.SorpresaVehiculoFabrica;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.VacioSorpresa;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AutoTest {
    
    private PozoFabrica pozoFabrica = new PozoFabrica();
    private PiqueteFabrica piqueteFabrica = new PiqueteFabrica();
    private ControlPolicialFabrica controlFabrica = new ControlPolicialFabrica();

    private SorpresaVehiculoFabrica sorpresaVehiculoFabrica = new SorpresaVehiculoFabrica();
    private SorpresaFavorableFabrica sorpresaFavFabrica =  new SorpresaFavorableFabrica();
    private SorpresaDesfavorableFabrica sorpresaDesfavFabrica = new SorpresaDesfavorableFabrica();

    @Test
    public void AutoEncuentraPozoTest() {
        //Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        Mapa mapa = mock(Mapa.class);
        juego.obtenerVehiculo().devolverPosicion().setearMapa(mapa);
        Calle calle = new Calle();
        calle.agregarObstaculo(pozoFabrica.crearObstaculo());
        calle.agregarSorpresa(new VacioSorpresa());
        when(mapa.obtenerCalleHorizontal(1, 0)).thenReturn(calle);

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 4);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 1);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
    }
    @Test
    public void AutoEncuentraPiqueteTest() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        Mapa mapa = mock(Mapa.class);
        juego.obtenerVehiculo().devolverPosicion().setearMapa(mapa);
        Calle calle = new Calle();
        calle.agregarObstaculo(piqueteFabrica.crearObstaculo());
        calle.agregarSorpresa(new VacioSorpresa());
        when(mapa.obtenerCalleHorizontal(1, 0)).thenReturn(calle);

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 0);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 1);
    }
    @Test
    public void AutoEncuentraPolicialTest() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        Mapa mapa = mock(Mapa.class);
        juego.obtenerVehiculo().devolverPosicion().setearMapa(mapa);
        Calle calle = new Calle();
        calle.agregarObstaculo(controlFabrica.crearObstaculo());
        calle.agregarSorpresa(new VacioSorpresa());
        when(mapa.obtenerCalleHorizontal(1, 0)).thenReturn(calle);

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 4 || juego.obtenerVehiculo().obtenerMovimientos() == 1);
    }
    @Test
    public void AutoEncuentraPiqueteYPozoTest() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        Mapa mapa = mock(Mapa.class);
        juego.obtenerVehiculo().devolverPosicion().setearMapa(mapa);
        Calle calle1 = new Calle();
        calle1.agregarObstaculo(pozoFabrica.crearObstaculo());
        calle1.agregarSorpresa(new VacioSorpresa());
        Calle calle2 = new Calle();
        calle2.agregarObstaculo(piqueteFabrica.crearObstaculo());
        calle2.agregarSorpresa(new VacioSorpresa());
        when(mapa.obtenerCalleHorizontal(1, 0)).thenReturn(calle1);
        when(mapa.obtenerCalleHorizontal(2, 0)).thenReturn(calle2);

        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 1);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 5);
    }

    @Test
    public void AutoEncuentraSorpresaCambioVehiculo() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        Mapa mapa = mock(Mapa.class);
        juego.obtenerVehiculo().devolverPosicion().setearMapa(mapa);
        Calle calle = new Calle();
        calle.agregarObstaculo(new VacioObstaculo());
        calle.agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());
        when(mapa.obtenerCalleHorizontal(1, 0)).thenReturn(calle);

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 1);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 1);
        assert(juego.obtenerVehiculo().estadoActual() == Camioneta.class);
    }
    @Test
    public void AutoEncuentraSorpresaFavorable() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        Mapa mapa = mock(Mapa.class);
        juego.obtenerVehiculo().devolverPosicion().setearMapa(mapa);
        Calle calle = new Calle();
        calle.agregarObstaculo(new VacioObstaculo());
        calle.agregarSorpresa(sorpresaFavFabrica.crearSorpresa());
        when(mapa.obtenerCalleHorizontal(1, 0)).thenReturn(calle);

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 1);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 0.8);
        assert(juego.obtenerVehiculo().estadoActual() == Auto.class);
    }
    @Test
    public void AutoEncuentraSorpresaDesfavorable() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        Mapa mapa = mock(Mapa.class);
        juego.obtenerVehiculo().devolverPosicion().setearMapa(mapa);
        Calle calle = new Calle();
        calle.agregarObstaculo(new VacioObstaculo());
        calle.agregarSorpresa(sorpresaDesfavFabrica.crearSorpresa());
        when(mapa.obtenerCalleVertical(0, 1)).thenReturn(calle);

        //act
        juego.mover(new DireccionAbajo());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 0);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 1);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 1.25);
        assert(juego.obtenerVehiculo().estadoActual() == Auto.class);
    }
    @Test
    public void AutoEncuentraSorpresaCambioVehiculo3Veces() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        Mapa mapa = mock(Mapa.class);
        juego.obtenerVehiculo().devolverPosicion().setearMapa(mapa);
        Calle calle1 = new Calle();
        calle1.agregarObstaculo(new VacioObstaculo());
        calle1.agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());
        Calle calle2 = new Calle();
        calle2.agregarObstaculo(new VacioObstaculo());
        calle2.agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());
        Calle calle3 = new Calle();
        calle3.agregarObstaculo(new VacioObstaculo());
        calle3.agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());
        when(mapa.obtenerCalleHorizontal(1, 0)).thenReturn(calle1);
        when(mapa.obtenerCalleHorizontal(2, 0)).thenReturn(calle2);
        when(mapa.obtenerCalleHorizontal(3, 0)).thenReturn(calle3);

        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 3);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 3);
        assert(juego.obtenerVehiculo().estadoActual() == Auto.class);
    }
    @Test
    public void AutoEncuentraSorpresaCambioVehiculo2veces() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        Mapa mapa = mock(Mapa.class);
        juego.obtenerVehiculo().devolverPosicion().setearMapa(mapa);
        Calle calle1 = new Calle();
        calle1.agregarObstaculo(new VacioObstaculo());
        calle1.agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());
        Calle calle2 = new Calle();
        calle2.agregarObstaculo(new VacioObstaculo());
        calle2.agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());
        when(mapa.obtenerCalleHorizontal(1, 0)).thenReturn(calle1);
        when(mapa.obtenerCalleHorizontal(2, 0)).thenReturn(calle2);

        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 2);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 2);
        assert(juego.obtenerVehiculo().estadoActual() == Moto.class);
    }
    @Test
    public void AutoVisitaCalleEnLimiteDelMapaYSigueEnElMismoLugar() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));

        //act
        juego.mover(new DireccionIzquierda());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 0);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
    }
}