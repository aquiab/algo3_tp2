package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estado.*;
import edu.fiuba.algo3.modelo.obstaculos.VacioObstaculo;
import edu.fiuba.algo3.modelo.sorpresas.VacioSorpresa;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MotoUnitariasTest {
    Juego juego = mock(Juego.class);
    Posicion posicion = mock(Posicion.class);
    Direccion direccion = mock(Direccion.class);

    @Test
    public void MotoEncuentraVacioDeTipoObstaculoTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        VacioObstaculo vacio = mock(VacioObstaculo.class);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(i -> null).when(vacio).pasar(vehiculo);
        vacio.pasar(vehiculo);

        verify(vacio, times(1)).pasar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 0);
    }

    @Test
    public void MotoEncuentraPozoTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(e ->{
            vehiculo.pasarPozo();
            return null;
        }).when(direccion).mover(posicion, vehiculo);

        vehiculo.mover(direccion);

        assert(vehiculo.movimientos == 4);
    }

    @Test
    public void MotoEncuentraPiqueteTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(e -> {
            vehiculo.pasarPiquete();
            return null;
        }).when(direccion).mover(posicion, vehiculo);

        vehiculo.mover(direccion);

        assert (vehiculo.movimientos == 3);
    }

    @Test
    public void MotoEncuentraPolicialTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(e -> {
            vehiculo.pasarControlPolicial(1);
            return null;
        }).when(direccion).mover(posicion, vehiculo);

        vehiculo.mover(direccion);

        assert (vehiculo.movimientos == 4);
    }

    @Test
    public void MotoEncuentraPozoyPiqueteTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);
        Direccion direccion2 = mock(Direccion.class);

        doAnswer(e -> {
            vehiculo.pasarPiquete();
            return null;
        }).when(direccion).mover(posicion, vehiculo);
        doAnswer(e -> {
            vehiculo.pasarPozo();
            return null;
        }).when(direccion2).mover(posicion, vehiculo);

        vehiculo.mover(direccion);
        vehiculo.mover(direccion2);

        assert (vehiculo.movimientos == 7);
    }

    @Test
    public void MotoEncuentraVacioDeTipoSorpresaTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        VacioSorpresa vacio = mock(VacioSorpresa.class);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(i -> null).when(vacio).aplicar(vehiculo);
        vacio.aplicar(vehiculo);

        verify(vacio, times(1)).aplicar(vehiculo);
        assert (vehiculo.obtenerMovimientos() == 0);
        assert (vehiculo.estadoActual() == Moto.class);
    }

    @Test
    public void MotoEncuentraSorpresaCambioVehiculoTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(e -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(direccion).mover(posicion, vehiculo);

        vehiculo.mover(direccion);

        assert (vehiculo.estadoActual() == Auto.class);
    }

    @Test
    public void MotoEncuentraSorpresaCambioVehiculo2VecesTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(e -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(direccion).mover(posicion, vehiculo);

        vehiculo.mover(direccion);
        vehiculo.mover(direccion);

        assert (vehiculo.estadoActual() == Camioneta.class);
    }

    @Test
    public void MotoEncuentraSorpresaCambioVehiculo3VecesTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(e -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(direccion).mover(posicion, vehiculo);

        vehiculo.mover(direccion);
        vehiculo.mover(direccion);
        vehiculo.mover(direccion);

        assert (vehiculo.estadoActual() == Moto.class);
    }

    @Test
    public void MotoEncuentraSorpresaFavorableTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(e -> {
            vehiculo.aplicarSorpresaPuntaje(0.8);
            return null;
        }).when(direccion).mover(posicion, vehiculo);

        vehiculo.mover(direccion);

        assert (vehiculo.movimientos == 0.8);
    }

    @Test
    public void MotoEncuentraSorpresaDesfavorableTest() {
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Moto moto = new Moto(vehiculo);
        vehiculo.aplicarEstado(moto);

        doAnswer(e -> {
            vehiculo.aplicarSorpresaPuntaje(1.25);
            return null;
        }).when(direccion).mover(posicion, vehiculo);

        vehiculo.mover(direccion);

        assert (vehiculo.movimientos == 1.25);
    }
}