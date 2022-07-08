package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.obstaculos.*;
import edu.fiuba.algo3.modelo.sorpresas.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class CalleTest {

    @Test
    public void calleRecienCreadaVieneSinNada() {
        Calle calle = new Calle();
        assert (calle.obtenerObstaculo().getClass() == VacioObstaculo.class);
        assert (calle.obtenerSorpresa().getClass() == VacioSorpresa.class);
    }

    @Test
    public void calleDevuelveSuObstaculoYSorpresaAsignadosCorrectamente() {
        Calle calle = new Calle();
        calle.agregarObstaculo(new VacioObstaculo());
        calle.agregarSorpresa(new VacioSorpresa());
        assert (calle.obtenerObstaculo().getClass() == VacioObstaculo.class);
        assert (calle.obtenerSorpresa().getClass() == VacioSorpresa.class);
    }

    @Test
    public void recorroCalleLlena() {
        //Recorro una calle lena con dos obstaculos vacíos.
        Calle calle = new Calle();

        Vehiculo vehiculo = mock(Vehiculo.class);
        Estado auto = mock(Auto.class);
        vehiculo.aplicarEstado(auto);
        ISorpresa sorpresa = mock(VacioSorpresa.class);
        IObstaculo obstaculo = mock(VacioObstaculo.class);

        calle.agregarObstaculo(obstaculo);
        calle.agregarSorpresa(sorpresa);

        doNothing().when(vehiculo).aplicarVacio();

        doAnswer(a -> {
            vehiculo.aplicarVacio();
            return null;
        }).when(sorpresa).aplicar(vehiculo);
        doAnswer(a -> {
            vehiculo.aplicarVacio();
            return null;
        }).when(obstaculo).pasar(vehiculo);

        calle.recorrer(vehiculo);

        verify(obstaculo, times(1)).pasar(vehiculo);
        verify(sorpresa, times(1)).aplicar(vehiculo);
    }
}
