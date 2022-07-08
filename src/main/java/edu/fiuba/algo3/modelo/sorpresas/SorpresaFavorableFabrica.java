package edu.fiuba.algo3.modelo.sorpresas;

public class SorpresaFavorableFabrica implements ISorpresaFabrica {

    private static final double VALOR_SORPRESA_FAVORABLE = 0.8;

    @Override
    public ISorpresa crearSorpresa() {
        SorpresaPuntaje sorpresa = new SorpresaPuntaje();
        sorpresa.asignarValor(VALOR_SORPRESA_FAVORABLE);
        return sorpresa;
    }
}
