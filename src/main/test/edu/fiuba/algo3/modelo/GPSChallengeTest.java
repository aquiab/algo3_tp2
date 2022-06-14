package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

public class GPSChallengeTest {

    @Test
    public void vehiculoEncuentraSorpresaFavorable() {
        //Test 1 - Entrega número 2.
        Usuario juego = new Usuario();
        Auto auto = new Auto(new Puntaje());
        juego.establecerVehiculo(auto);
        Calle calle = new Calle(new SorpresaFavorable(), null);

        Esquina esquinaA0 = new Esquina();
        Esquina esquinaA1 = new Esquina();
        Tuple direccionA0 = new Tuple(esquinaA0, calle);
        Tuple direccionA1 = new Tuple(esquinaA1, calle);

        //Enlazo las esquinas entre sí.
        esquinaA0.agregarEsquinaAdyacente(direccionA1, "a1");
        esquinaA1.agregarEsquinaAdyacente(direccionA0, "a0");

        auto.asignarPosicionInicial(esquinaA0);
        juego.hacerMovimiento("a1");
        assert (juego.cantidadDeMovimientos() == 0.8);

        juego.hacerMovimiento("a0");
        assert (juego.cantidadDeMovimientos() == 1.8);

        juego.hacerMovimiento("a1");
        assert (juego.cantidadDeMovimientos() == 2.8);
    }

    @Test
    public void vehiculoEncuentraSorpresaDesfavorable() {
        //Test 2 - Entrega número 2.
        Usuario juego = new Usuario();
        Auto auto = new Auto(new Puntaje());
        juego.establecerVehiculo(auto);
        Calle calle = new Calle(new SorpresaDesfavorable(), null);

        Esquina esquinaA0 = new Esquina();
        Esquina esquinaA1 = new Esquina();
        Tuple direccionA0 = new Tuple(esquinaA0, calle);
        Tuple direccionA1 = new Tuple(esquinaA1, calle);

        //Enlazo las esquinas entre sí.
        esquinaA0.agregarEsquinaAdyacente(direccionA1, "a1");
        esquinaA1.agregarEsquinaAdyacente(direccionA0, "a0");

        auto.asignarPosicionInicial(esquinaA0);
        juego.hacerMovimiento("a1");
        assert (juego.cantidadDeMovimientos() == 1.25);

        juego.hacerMovimiento("a0");
        assert (juego.cantidadDeMovimientos() == 2.25);

        juego.hacerMovimiento("a1");
        assert (juego.cantidadDeMovimientos() == 3.25);
    }

    @Test
    public void vehiculoEncuentraSorpresaDeCambioDeVehiculo() {
        //Test 3 - Entrega número 2
        //Orden de cambio: moto -> auto -> 4x4 -> moto -> ...
        Usuario juego = new Usuario();
        Auto auto = new Auto(new Puntaje());
        juego.establecerVehiculo(auto);
        Calle calle = new Calle(new SorpresaCambioVehiculo(), null);

        Esquina esquinaA0 = new Esquina();
        Esquina esquinaA1 = new Esquina();
        Tuple direccionA0 = new Tuple(esquinaA0, calle);
        Tuple direccionA1 = new Tuple(esquinaA1, calle);

        //Enlazo las esquinas entre sí.
        esquinaA0.agregarEsquinaAdyacente(direccionA1, "a1");
        esquinaA1.agregarEsquinaAdyacente(direccionA0, "a0");

        juego.asignarPosicionInicial(esquinaA0);

        assert (juego.devolverVehiculo().getClass() == Auto.class);
        juego.hacerMovimiento("a1");
        assert (juego.devolverVehiculo().getClass() == Camioneta.class);
        assert (juego.cantidadDeMovimientos() == 1);

        //Al volver no puedo usar mas la sorpresa. Por lo que el vehículo no debería cambiar su tipo.
        //Puebo un vuelva e ida nuevamente.
        juego.hacerMovimiento("a0");
        assert (juego.devolverVehiculo().getClass() == Camioneta.class);
        assert (juego.cantidadDeMovimientos() == 2);

        juego.hacerMovimiento("a1");
        assert (juego.devolverVehiculo().getClass() == Camioneta.class);
        assert (juego.cantidadDeMovimientos() == 3);
    }

    @Test
    public void camionetaEncuentraSorpresaDeCambioDeVehiculo() {
        Usuario juego = new Usuario();
        Camioneta camioneta = new Camioneta(new Puntaje());
        juego.establecerVehiculo(camioneta);
        Calle calle = new Calle(new SorpresaCambioVehiculo(), null);

        Esquina esquinaA0 = new Esquina();
        Esquina esquinaA1 = new Esquina();
        Tuple direccionA0 = new Tuple(esquinaA0, calle);
        Tuple direccionA1 = new Tuple(esquinaA1, calle);

        //Enlazo las esquinas entre sí.
        esquinaA0.agregarEsquinaAdyacente(direccionA1, "a1");
        esquinaA1.agregarEsquinaAdyacente(direccionA0, "a0");

        juego.asignarPosicionInicial(esquinaA0);

        assert (juego.devolverVehiculo().getClass() == Camioneta.class);
        juego.hacerMovimiento("a1");
        assert (juego.devolverVehiculo().getClass() == Moto.class);
    }

    @Test
    public void motoEncuentraSorpresaDeCambioDeVehiculo() {
        Usuario juego = new Usuario();
        Moto moto = new Moto(new Puntaje());
        juego.establecerVehiculo(moto);
        Calle calle = new Calle(new SorpresaCambioVehiculo(), null);

        Esquina esquinaA0 = new Esquina();
        Esquina esquinaA1 = new Esquina();
        Tuple direccionA0 = new Tuple(esquinaA0, calle);
        Tuple direccionA1 = new Tuple(esquinaA1, calle);

        //Enlazo las esquinas entre sí.
        esquinaA0.agregarEsquinaAdyacente(direccionA1, "a1");
        esquinaA1.agregarEsquinaAdyacente(direccionA0, "a0");

        juego.asignarPosicionInicial(esquinaA0);

        assert (juego.devolverVehiculo().getClass() == Moto.class);
        juego.hacerMovimiento("a1");
        assert (juego.devolverVehiculo().getClass() == Auto.class);
    }

    @Test
    public void MotoPasaPiquete() {
        //Test 4 - Entrega número 2.
        //A diferencia de los autos y camionetas 4x4, las motos sí puede atravesar piquetes,
        //pero este le genera una penalización de 2 movimientos.
        Usuario juego = new Usuario();
        Moto moto = new Moto(new Puntaje());
        juego.establecerVehiculo(moto);
        Calle calle = new Calle(null, new Piquete());

        Esquina esquinaA0 = new Esquina();
        Esquina esquinaA1 = new Esquina();
        Tuple direccionA0 = new Tuple(esquinaA0, calle);
        Tuple direccionA1 = new Tuple(esquinaA1, calle);

        esquinaA0.agregarEsquinaAdyacente(direccionA1, "a1");
        esquinaA1.agregarEsquinaAdyacente(direccionA0, "a0");

        moto.asignarPosicionInicial(esquinaA0);
        juego.hacerMovimiento("a1");

        //assert
        assert (moto.obtenerPosicionActual() == esquinaA1);
        assert(moto.obtenerMovimientos() == 3);
    }
}
