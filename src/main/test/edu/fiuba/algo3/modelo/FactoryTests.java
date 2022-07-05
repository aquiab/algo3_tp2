package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.fabrica_obstaculos.*;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.*;
import org.junit.jupiter.api.Test;

public class FactoryTests {

    private static final double VALOR_SORPRESA_FAVORABLE = 0.8;
    private static final double VALOR_SORPRESA_DESFAVORABLE = 1.25;

    /**Creación de obstaculos*/

    @Test
    public void creoPozoATravesDeFabrica() {
        IObstaculoFabrica fabrica = new PozoFabrica();
        IObstaculo resultado = fabrica.crearObstaculo();

        assert (resultado.getClass() == Pozo.class);
    }

    @Test
    public void creoPiqueteATravesDeFabrica() {
        IObstaculoFabrica fabrica = new PiqueteFabrica();
        IObstaculo resultado = fabrica.crearObstaculo();

        assert (resultado.getClass() == Piquete.class);
    }

    @Test
    public void creoControlPolicialATravesDeFabrica() {
        IObstaculoFabrica fabrica = new ControlPolicialFabrica();
        IObstaculo resultado = fabrica.crearObstaculo();

        assert (resultado.getClass() == ControlPolicial.class);
    }

    /**Creacion de sorpresas**/

    @Test
    public void creoSorpresaFavorableATravesDeFabrica() {
        ISorpresaFabrica fabrica = new SorpresaFavorableFabrica();
        ISorpresa resultado = fabrica.crearSorpresa();

        assert (resultado.getClass() == SorpresaPuntaje.class);
        assert (((SorpresaPuntaje) resultado).obtenerValor() == this.VALOR_SORPRESA_FAVORABLE);
    }

    @Test
    public void creoSorpresaDesfavorableATravesDeFabrica() {
        ISorpresaFabrica fabrica = new SorpresaDesfavorableFabrica();
        ISorpresa resultado = fabrica.crearSorpresa();

        assert (resultado.getClass() == SorpresaPuntaje.class);
        assert (((SorpresaPuntaje) resultado).obtenerValor() == this.VALOR_SORPRESA_DESFAVORABLE);
    }

    @Test
    public void creoSorpresaDeCambioDeVehiculoATravesDeFabrica() {
        ISorpresaFabrica fabrica = new SorpresaVehiculoFabrica();
        ISorpresa resultado = fabrica.crearSorpresa();

        assert (resultado.getClass() == SorpresaVehiculo.class);
    }
}
