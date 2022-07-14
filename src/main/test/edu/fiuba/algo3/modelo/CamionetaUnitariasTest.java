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
import static org.mockito.Mockito.times;

public class CamionetaUnitariasTest {

    private Juego juegoMock = mock(Juego.class);
    private Posicion posicionMock = mock(Posicion.class);

    /**Interacciones con obstáculos**/
    
    @Test
    public void CabionetaEncuentraVacioDeTipoObstaculoTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        VacioObstaculo vacio = mock(VacioObstaculo.class);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);

        doAnswer(i -> null).when(vacio).pasar(vehiculo);
        vacio.pasar(vehiculo);

        verify(vacio, times(1)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 0);
    }

    @Test
    public void CamionetaEncuentraPozoYEsPenalizadaTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Pozo pozo = mock(Pozo.class);
        Camioneta camioneta = spy(new Camioneta(vehiculo));
        vehiculo.aplicarEstado (camioneta);

        when(camioneta.penalizacionPozoHabilitada()).thenReturn(true);
        doAnswer(i -> {
            vehiculo.pasarPozo();
            return null;
        }).when(pozo).pasar(vehiculo);

        doAnswer(i -> {
            if (camioneta.penalizacionPozoHabilitada()) vehiculo.incrementarMovimientos(2);
            return null;
        }).when(camioneta).pasarPozo();

        pozo.pasar(vehiculo);

        verify(pozo, times(1)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 2);
    }

    @Test
    public void CamionetaEncuentraPozoYNoEsPenalizadaTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Pozo pozo = mock(Pozo.class);
        Camioneta camioneta = spy(new Camioneta(vehiculo));
        vehiculo.aplicarEstado (camioneta);

        when(camioneta.penalizacionPozoHabilitada()).thenReturn(false);
        doAnswer(i -> {
            vehiculo.pasarPozo();
            return null;
        }).when(pozo).pasar(vehiculo);

        doAnswer(i -> {
            if (camioneta.penalizacionPozoHabilitada()) vehiculo.incrementarMovimientos(2);
            return null;
        }).when(camioneta).pasarPozo();

        pozo.pasar(vehiculo);

        verify(pozo, times(1)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 0);
    }

    @Test
    public void CamionetaEncuentraPozosYEsPenalizadaAlTerceroTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Pozo pozo = mock(Pozo.class);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);

        doAnswer(i -> {
            vehiculo.pasarPozo();
            return null;
        }).when(pozo).pasar(vehiculo);
        for (int i = 0; i < 3; i++) pozo.pasar(vehiculo);

        verify(pozo, times(3)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 2);
    }

    @Test
    public void CamionetaInteractuaConControlPolicialTest() {
        Vehiculo vehiculo =  new Vehiculo(0, posicionMock, juegoMock);
        ControlPolicial control = mock(ControlPolicial.class);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);

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
    public void CamionetaInteractuaConPiqueteTest() {
        //Camioneta no presenta penalizacion alguna al chocar con un piquete.
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Piquete piquete = mock(Piquete.class);
        Camioneta camioneta = new Camioneta(vehiculo);

        vehiculo.aplicarEstado (camioneta);
        doAnswer(i -> {
            vehiculo.pasarPiquete();
            return null;
        }).when(piquete).pasar(vehiculo);
        piquete.pasar(vehiculo);

        verify(piquete, times(1)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 0);
    }

    @Test
    public void CamionetaEncuentraPiqueteYPozoTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Piquete piquete = mock(Piquete.class);
        Pozo pozo = mock(Pozo.class);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);

        //El primer paso en el pozo no me penaliza en absoluto.
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
        assert (vehiculo.obtenerMovimientos() == 0);
    }

    /**Interacciones con Sorpresas**/

    @Test
    public void CamionetaEncuentraSorpresaFavorable() {
        Vehiculo vehiculo = new Vehiculo(1, posicionMock, juegoMock);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);
        SorpresaPuntaje sorpresa = mock(SorpresaPuntaje.class);

        when(sorpresa.obtenerValor()).thenReturn(0.8);
        doAnswer(i -> {
            vehiculo.aplicarSorpresaPuntaje(sorpresa.obtenerValor());
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);

        verify(sorpresa, times(1)).obtenerValor();
        verify(sorpresa, times(1)).aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);
        assert (vehiculo.obtenerMovimientos() == 0.8);
    }

    @Test
    public void CamionetaEncuentraSorpresaDesfavorable() {
        Vehiculo vehiculo = new Vehiculo(1, posicionMock, juegoMock);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);
        SorpresaPuntaje sorpresa = mock(SorpresaPuntaje.class);

        when(sorpresa.obtenerValor()).thenReturn(1.25);
        doAnswer(i -> {
            vehiculo.aplicarSorpresaPuntaje(sorpresa.obtenerValor());
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);

        verify(sorpresa, times(1)).obtenerValor();
        verify(sorpresa, times(1)).aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);
        assert (vehiculo.obtenerMovimientos() == 1.25);
    }

    @Test
    public void CamionetaEncuentraSorpresaCambioVehiculo() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);
        SorpresaVehiculo sorpresa = mock(SorpresaVehiculo.class);

        doAnswer(i -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);

        verify(sorpresa, times(1)).aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Moto.class);
    }

    @Test
    public void CamionetaEncuentraSorpresaCambioVehiculo2veces() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);
        SorpresaVehiculo sorpresa = mock(SorpresaVehiculo.class);

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

        verify(sorpresa, times(2)).aplicar(vehiculo);
    }

    @Test
    public void CamionetaEncuentraSorpresaCambioVehiculo3Veces() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);
        SorpresaVehiculo sorpresa = mock(SorpresaVehiculo.class);

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

        doAnswer(i -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        sorpresa.aplicar(vehiculo);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);
    }

    @Test
    public void CamionetaEncuentraVacioDeTipoSorpresaTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicionMock, juegoMock);
        VacioSorpresa vacio = mock(VacioSorpresa.class);
        Camioneta camioneta = new Camioneta(vehiculo);
        vehiculo.aplicarEstado (camioneta);

        doAnswer(i -> null).when(vacio).aplicar(vehiculo);
        vacio.aplicar(vehiculo);

        verify(vacio, times(1)).aplicar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 0);
        assert (vehiculo.obtenerEstado().getClass() == Camioneta.class);
    }

}
