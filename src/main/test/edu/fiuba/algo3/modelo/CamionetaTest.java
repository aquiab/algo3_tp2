package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

public class CamionetaTest {

    @Test
    public void camionetaEncuentraPozoNoEsPenalizada() {
        //Una 4x4 atraviesa la ciudad y se encuentra con un Pozo. No es penalizada.
        Usuario conductor = new Usuario();
        Camioneta camioneta = new Camioneta(new Puntaje());
        conductor.establecerVehiculo(camioneta);
        Calle calle = new Calle(null, new Pozo());

        Esquina esquinaA0 = new Esquina();
        Esquina esquinaA1 = new Esquina();
        Tuple direccionA0 = new Tuple(esquinaA0, calle);
        Tuple direccionA1 = new Tuple(esquinaA1, calle);

        //Enlazo las esquinas entre sí.
        esquinaA0.agregarEsquinaAdyacente(direccionA1, "a1");
        esquinaA1.agregarEsquinaAdyacente(direccionA0, "a0");

        camioneta.asignarPosicionInicial(esquinaA0);
        conductor.hacerMovimiento("a1");

        assert (camioneta.obtenerMovimientos() == 1);
    }

    @Test
    public void camionetaEncuentraPiqueteNoSeMueveAunqueIntentaCuentaComoMovimiento() {
        Usuario conductor = new Usuario();
        Camioneta camioneta = new Camioneta();
        conductor.establecerVehiculo(camioneta);
        Calle calle = new Calle(null, new Piquete());

        Esquina esquinaA0 = new Esquina();
        Esquina esquinaA1 = new Esquina();
        Tuple direccionA0 = new Tuple(esquinaA0, calle);
        Tuple direccionA1 = new Tuple(esquinaA1, calle);

        //Enlazo las esquinas entre sí.
        esquinaA0.agregarEsquinaAdyacente(direccionA1, "a1");
        esquinaA1.agregarEsquinaAdyacente(direccionA0, "a0");
        camioneta.asignarPosicionInicial(esquinaA0);

        //Primer intento
        conductor.hacerMovimiento("a1");
        assert (camioneta.obtenerPosicionActual() == esquinaA0);
        assert (camioneta.obtenerMovimientos() == 1);

        //Segundo intento
        conductor.hacerMovimiento("a1");
        assert (camioneta.obtenerPosicionActual() == esquinaA0);
        assert (camioneta.obtenerMovimientos() == 2);
    }
}
