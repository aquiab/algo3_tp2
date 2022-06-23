package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modificadores.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class AutoUnitariasTest {
    @Test
    public void AutoEcuentraPozo() {
        /*Obstaculo pozo = mock(Obstaculo.class);
        doAnswer(invocation -> {
            Vehiculo vehiculo = invocation.getArgument(0);
            vehiculo.pasarPozo();
            return null;
        });*/

        Posicion posicion = mock(Posicion.class);
        Direccion direccion = mock(Direccion.class);
        doAnswer(invocation -> {
            Vehiculo vehiculo2 = invocation.getArgument(1);
            posicion.moverArriba(vehiculo2);
            return null;
        });

        Vehiculo vehiculo = new Vehiculo(0, posicion);
        Estado auto = new Auto(vehiculo);
        vehiculo.aplicarEstado(auto);

        Pozo pozo = new Pozo();

        Calle calle = mock(Calle.class);
        doAnswer(invocation -> {
            Vehiculo vehiculo2 = invocation.getArgument(0);
            pozo.aplicar(vehiculo2);
            return null;
        }).when(calle).recorrer(vehiculo);

        Mapa mapa = mock(Mapa.class);
        when(mapa.obtenerCalleHorizontal(0, 0)).thenReturn(calle);


    }
}
