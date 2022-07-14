package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.estado.Moto;
import edu.fiuba.algo3.modelo.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.obstaculos.VacioObstaculo;
import edu.fiuba.algo3.modelo.sorpresas.SorpresaPuntaje;
import edu.fiuba.algo3.modelo.sorpresas.SorpresaVehiculo;
import edu.fiuba.algo3.modelo.sorpresas.VacioSorpresa;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AutoUnitariasTest {

    private Juego juegoMock = mock(Juego.class);
    private Posicion posicionMock = mock(Posicion.class);

    /**Interacciones con obstáculos***/

    @Test
    public void AutoEncuentraVacioDeTipoObstaculoTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        VacioObstaculo vacio = mock(VacioObstaculo.class);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);

        doAnswer(i -> null).when(vacio).pasar(vehiculo);
        vacio.pasar(vehiculo);

        verify(vacio, times(1)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 0);
    }

    @Test
    public void AutoEncuentraPozoTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Pozo pozo = mock(Pozo.class);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);

        doAnswer(i -> {
            vehiculo.pasarPozo();
            return null;
        }).when(pozo).pasar(vehiculo);
        pozo.pasar(vehiculo);

        verify(pozo, times(1)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 3);
    }

    @Test
    public void AutoInteractuaConControlPolicialTest() {
        Vehiculo vehiculo =  new Vehiculo(0, posicionMock, juegoMock);
        ControlPolicial control = mock(ControlPolicial.class);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);

        when(control.pasoControlAleatorio()).thenReturn((double)0);
        doAnswer(i -> {
            vehiculo.pasarControlPolicial(control.pasoControlAleatorio());
            return null;
        }).when(control).pasar(vehiculo);
        control.pasar(vehiculo);

        verify(control, times(1)).pasoControlAleatorio();
        assert(vehiculo.obtenerMovimientos() == 3);
    }

    @Test
    public void AutoInteractuaConPiqueteTest() {
        //Auto no presenta penalizacion alguna al chocar con un piquete.
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Piquete piquete = mock(Piquete.class);
        Auto auto = new Auto(vehiculo);

        vehiculo.aplicarEstado(auto);
        doAnswer(i -> {
            vehiculo.pasarPiquete();
            return null;
        }).when(piquete).pasar(vehiculo);
        piquete.pasar(vehiculo);

        verify(piquete, times(1)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 0);
    }

    @Test
    public void AutoEncuentraPiqueteYPozoTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Piquete piquete = mock(Piquete.class);
        Pozo pozo = mock(Pozo.class);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);

        doAnswer(i -> {
            vehiculo.pasarPozo();
            return null;
        }).when(pozo).pasar(vehiculo);
        pozo.pasar(vehiculo);

        doAnswer(i -> {
            vehiculo.pasarPiquete();
            return null;
        }).when(piquete).pasar(vehiculo);
        piquete.pasar(vehiculo);

        verify(pozo, times(1)).pasar(vehiculo);
        verify(piquete, times(1)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 3);
    }

    /**Interacción con Sorpresas**/

    @Test
    public void AutoEncuentraVacioDeTipoSorpresaTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        VacioSorpresa vacio = mock(VacioSorpresa.class);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);

        doAnswer(i -> null).when(vacio).aplicar(vehiculo);
        vacio.aplicar(vehiculo);

        verify(vacio, times(1)).aplicar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 0);
        assert (vehiculo.obtenerEstado().getClass() == Auto.class);
    }

    @Test
    public void AutoEncuentraSorpresaFavorable() {
        Vehiculo vehiculo = new Vehiculo(1, posicionMock, juegoMock);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);
        SorpresaPuntaje sorpresa = mock(SorpresaPuntaje.class);

        when(sorpresa.obtenerValor()).thenReturn(0.8);
        doAnswer(i -> {
            vehiculo.aplicarSorpresaPuntaje(sorpresa.obtenerValor());
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);

        verify(sorpresa, times(1)).obtenerValor();
        verify(sorpresa, times(1)).aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Auto.class);
        assert (vehiculo.obtenerMovimientos() == 0.8);
    }

    @Test
    public void AutoEncuentraSorpresaDesfavorable() {
        Vehiculo vehiculo = new Vehiculo(1, posicionMock, juegoMock);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);
        SorpresaPuntaje sorpresa = mock(SorpresaPuntaje.class);

        when(sorpresa.obtenerValor()).thenReturn(1.25);
        doAnswer(i -> {
            vehiculo.aplicarSorpresaPuntaje(sorpresa.obtenerValor());
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);

        verify(sorpresa, times(1)).obtenerValor();
        verify(sorpresa, times(1)).aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Auto.class);
        assert (vehiculo.obtenerMovimientos() == 1.25);
    }

    @Test
    public void AutoEncuentraSorpresaCambioVehiculo() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);
        SorpresaVehiculo sorpresa = mock(SorpresaVehiculo.class);

        doAnswer(i -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);

        verify(sorpresa, times(1)).aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);
    }

    @Test
    public void AutoEncuentraSorpresaCambioVehiculo2veces() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);
        SorpresaVehiculo sorpresa = mock(SorpresaVehiculo.class);

        doAnswer(i -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);

        doAnswer(i -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Moto.class);

        verify(sorpresa, times(2)).aplicar(vehiculo);
    }


    @Test
    public void AutoEncuentraSorpresaCambioVehiculo3Veces() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);
        SorpresaVehiculo sorpresa = mock(SorpresaVehiculo.class);

        doAnswer(i -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);

        doAnswer(i -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Moto.class);

        doAnswer(i -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Auto.class);
    }
}
