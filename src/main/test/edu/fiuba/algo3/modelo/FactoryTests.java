package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.sorpresas.*;

public class FactoryTests {

    private static final double VALOR_SORPRESA_FAVORABLE = 0.8;
    private static final double VALOR_SORPRESA_DESFAVORABLE = 1.25;

    /**Creacion de sorpresas**/

    @Test
    public void creoSorpresaFavorableATravesDeFabrica() {
        ISorpresaFabrica fabrica = new SorpresaFavorableFabrica();
        ISorpresa resultado = fabrica.crearSorpresa();

        assert (resultado.getClass() == SorpresaPuntaje.class);
        assert (((SorpresaPuntaje) resultado).obtenerValor() == VALOR_SORPRESA_FAVORABLE);
    }

    @Test
    public void creoSorpresaDesfavorableATravesDeFabrica() {
        ISorpresaFabrica fabrica = new SorpresaDesfavorableFabrica();
        ISorpresa resultado = fabrica.crearSorpresa();

        assert (resultado.getClass() == SorpresaPuntaje.class);
        assert (((SorpresaPuntaje) resultado).obtenerValor() == VALOR_SORPRESA_DESFAVORABLE);
    }
}
