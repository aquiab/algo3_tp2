package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class VehiculoUnitariasTest {
    @Test
    public void VehiculoMover() {
        Posicion posicion = mock(Posicion.class);
        Direccion direccion = mock(Direccion.class);
        Vehiculo vehiculo = new Vehiculo(0, posicion);

        vehiculo.mover(direccion);

        assert (vehiculo.movimientos == 1);
        verify(direccion, times(1)).mover(posicion, vehiculo);
    }
    @Test
    public void VehiculoAplicarEstado() {
        Estado estado = mock(Estado.class);
        Vehiculo vehiculo = new Vehiculo(0, null);

        vehiculo.aplicarEstado(estado);

        assert(vehiculo.estado == estado);
    }
    @Test
    public void VehiculoIncrementarMovimiento() {
        Vehiculo vehiculo = new Vehiculo(0, null);

        vehiculo.incrementarMovimientos(1);

        assert(vehiculo.movimientos == 1);
    }
    @Test
    public void VehiculoAplicarSorpresaDesfavorable() {
        Vehiculo vehiculo = new Vehiculo(10, null);

        vehiculo.aplicarSorpresaDesfavorable();

        assert(vehiculo.movimientos == (10*1.25));
    }
    @Test
    public void VehiculoAplicarSorpresaFavorable() {
        Vehiculo vehiculo = new Vehiculo(10, null);

        vehiculo.aplicarSorpresaFavorable();

        assert (vehiculo.movimientos == (10 * 0.8));
    }
    @Test
    public void VehiculoAplicarSorpresaCambioVehiculo() {
        Estado estado = mock(Estado.class);
        Vehiculo vehiculo = new Vehiculo(0, null);
        vehiculo.aplicarEstado(estado);

        vehiculo.aplicarSorpresaCambioVehiculo();

        verify(estado, times(1)).aplicarSorpresaCambioVehiculo();
    }
    @Test
    public void VehiculoPasarPozo() {
        Estado estado = mock(Estado.class);
        Vehiculo vehiculo = new Vehiculo(0, null);
        vehiculo.aplicarEstado(estado);

        vehiculo.pasarPozo();

        verify(estado, times(1)).pasarPozo();
    }
    @Test
    public void VehiculoPasarPiquete() {
        Estado estado = mock(Estado.class);
        Vehiculo vehiculo = new Vehiculo(0, null);
        vehiculo.aplicarEstado(estado);

        vehiculo.pasarPiquete();

        verify(estado, times(1)).pasarPiquete();
    }
    @Test
    public void VehiculoPasarControl() {
        Estado estado = mock(Estado.class);
        Vehiculo vehiculo = new Vehiculo(0, null);
        vehiculo.aplicarEstado(estado);

        vehiculo.pasarControlPolicial();

        verify(estado, times(1)).pasarControlPolicial();
    }
    @Test
    public void VehiculoPasarVacio() {
        Estado estado = mock(Estado.class);
        Vehiculo vehiculo = new Vehiculo(0, null);
        vehiculo.aplicarEstado(estado);

        vehiculo.aplicarVacio();

        verify(estado, times(1)).pasarVacio();
    }
}