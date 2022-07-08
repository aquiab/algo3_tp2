package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estado.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class GamePlayTest {

    @Test
    public void HistoriaTest() {
        Jugador jugador = mock(Jugador.class);
        Juego juego = mock(Juego.class);
        Posicion posicion = mock(Posicion.class);
        Vehiculo vehiculo = new Vehiculo(0, posicion, juego);
        Auto auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);

        Direccion direccionPozo = mock(Direccion.class);
        Direccion direccionPiquete = mock(Direccion.class);
        Direccion direccionControlPasar = mock(Direccion.class);
        Direccion direccionControlNoPasar = mock(Direccion.class);
        Direccion direccionCambioVehiculo = mock(Direccion.class);
        Direccion direccionSorpresaFavorable = mock(Direccion.class);
        Direccion direccionSorpresaDesfavorable = mock(Direccion.class);
        Direccion direccionVacio = mock(Direccion.class);
        Direccion direccionMeta = mock(Direccion.class);

        doAnswer(e -> {
            vehiculo.pasarPozo();
            return null;
        }).when(direccionPozo).mover(posicion, vehiculo);

        doAnswer(e -> {
            vehiculo.pasarPiquete();
            return null;
        }).when(direccionPiquete).mover(posicion, vehiculo);

        doAnswer(e -> {
            vehiculo.pasarControlPolicial(100);
            return null;
        }).when(direccionControlPasar).mover(posicion, vehiculo);

        doAnswer(e -> {
            vehiculo.pasarControlPolicial(0);
            return null;
        }).when(direccionControlNoPasar).mover(posicion, vehiculo);

        doAnswer(e -> {
            vehiculo.aplicarSorpresaCambioVehiculo();
            return null;
        }).when(direccionCambioVehiculo).mover(posicion, vehiculo);

        doAnswer(e -> {
            vehiculo.aplicarSorpresaPuntaje(0.8);
            return null;
        }).when(direccionSorpresaFavorable).mover(posicion, vehiculo);

        doAnswer(e -> {
            vehiculo.aplicarSorpresaPuntaje(1.25);
            return null;
        }).when(direccionSorpresaDesfavorable).mover(posicion, vehiculo);

        doNothing().when(direccionVacio).mover(posicion, vehiculo);

        doAnswer(e -> {
            vehiculo.ganar();
            return null;
        }).when(direccionMeta).mover(posicion, vehiculo);

        vehiculo.mover(direccionPozo);  // El auto pasa por un pozo, movimientos = 0 + 4
        vehiculo.mover(direccionCambioVehiculo); // El auto pasa por una sorpresa de cambio de vehiculo y cambia a camioneta, movimientos = 4 + 1
        vehiculo.mover(direccionPiquete); // La camioneta quiere pasar pero se encuentra un piquete, movimientos = 5 + 1
        vehiculo.mover(direccionVacio); // La camioneta pasa por una calle vacia, movimientos = 6 + 1
        vehiculo.mover(direccionControlPasar); // La camioneta pasa un control policial pero no la paran, movimientos = 7 + 1
        vehiculo.mover(direccionVacio); // La camioneta pasa por una calle vacia, movimientos = 8 + 1
        vehiculo.mover(direccionCambioVehiculo); // La camioneta pasa por una sorpresa de cambio de vehiculo y cambia a moto, movimientos = 9 + 1
        vehiculo.mover(direccionControlNoPasar); // La moto se encuentra un control policial y la paran, movimientos = 10 + 4
        vehiculo.mover(direccionVacio); // La moto pasa por una calle vacia, movimientos = 14 + 1
        vehiculo.mover(direccionSorpresaDesfavorable); // La moto pasa por una sorpresa desfavorable, movimientos = (15 + 1) * 1.25
        vehiculo.mover(direccionPiquete); // La moto quiere pasar por un piquete y como es una moto lo pasa, movimientos = 20 + 3
        vehiculo.mover(direccionVacio); // La moto pasa por una calle vacia, movimientos = 23 + 1
        vehiculo.mover(direccionPozo); // La moto se encuentra un pozo, movimientos = 24 + 4
        vehiculo.mover(direccionVacio); // La moto pasa por una calle vacia, movimientos = 28 + 1
        vehiculo.mover(direccionSorpresaFavorable); // La moto se encuentra una sorpresa favorable, movimientos = (29 + 1) * 0.8
        vehiculo.mover(direccionMeta); // La moto llega a la meta y gana, movimientos = 24 + 1

        assert (vehiculo.obtenerMovimientos() == 25);
    }
}
