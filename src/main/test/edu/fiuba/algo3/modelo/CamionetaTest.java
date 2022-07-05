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

public class CamionetaTest {

    private PozoFabrica pozoFabrica = new PozoFabrica();
    private PiqueteFabrica piqueteFabrica = new PiqueteFabrica();
    private ControlPolicialFabrica controlFabrica = new ControlPolicialFabrica();

    private SorpresaVehiculoFabrica sorpresaVehiculoFabrica = new SorpresaVehiculoFabrica();
    private SorpresaFavorableFabrica sorpresaFavFabrica =  new SorpresaFavorableFabrica();
    private SorpresaDesfavorableFabrica sorpresaDesfavFabrica = new SorpresaDesfavorableFabrica();
    
    @Test
    public void CamionetaEncuentraPozoTest() {
        //Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizado en tres movimientos.
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(pozoFabrica.crearObstaculo());
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
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(pozoFabrica.crearObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarObstaculo(pozoFabrica.crearObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(3, 0).agregarObstaculo(pozoFabrica.crearObstaculo());
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
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(piqueteFabrica.crearObstaculo());
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
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(controlFabrica.crearObstaculo());
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
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(pozoFabrica.crearObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarObstaculo(piqueteFabrica.crearObstaculo());
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
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 1);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 1);
        assert(juego.obtenerVehiculo().estadoActual() == Moto.class);
    }
    @Test
    public void CamionetaEncuentraSorpresaFavorable() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(sorpresaFavFabrica.crearSorpresa());

        //act
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 1);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 0.8);
        assert(juego.obtenerVehiculo().estadoActual() == Camioneta.class);
    }
    @Test
    public void CamionetaEncuentraSorpresaDesavorable() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleVertical(0, 1).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleVertical(0, 1).agregarSorpresa(sorpresaDesfavFabrica.crearSorpresa());

        //act
        juego.mover(new DireccionAbajo());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 0);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 1);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 1.25);
        assert(juego.obtenerVehiculo().estadoActual() == Camioneta.class);
    }
    @Test
    public void CamionetaEncuentraSorpresaCambioVehiculo3Veces() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());
        juego.obtenerMapa().obtenerCalleHorizontal(3, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(3, 0).agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());

        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 3);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 3);
        assert(juego.obtenerVehiculo().estadoActual() == Camioneta.class);
    }
    @Test
    public void CamionetaEncuentraSorpresaCambioVehiculo2veces() {
        //arrange
        Juego juego = new Juego();
        juego.asignarLongitudMapa(5);
        juego.asignarVehiculoInicial();
        juego.aplicarEstadoInicial(new Camioneta(juego.vehiculo));
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(1, 0).agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarObstaculo(new VacioObstaculo());
        juego.obtenerMapa().obtenerCalleHorizontal(2, 0).agregarSorpresa(sorpresaVehiculoFabrica.crearSorpresa());

        //act
        juego.mover(new DireccionDerecha());
        juego.mover(new DireccionDerecha());

        //assert
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaX() == 2);
        assert(juego.obtenerVehiculo().devolverPosicion().obtenerCoordenadaY() == 0);
        assert(juego.obtenerVehiculo().obtenerMovimientos() == 2);
        assert(juego.obtenerVehiculo().estadoActual() == Auto.class);
    }
}