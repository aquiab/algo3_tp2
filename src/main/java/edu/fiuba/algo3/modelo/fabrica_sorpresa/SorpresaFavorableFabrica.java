package edu.fiuba.algo3.modelo.fabrica_sorpresa;

public class SorpresaFavorableFabrica implements ISorpresaFabrica {

    private static final double VALOR_SORPRESA_FAVORABLE = 0.8;

    @Override
    public ISorpresa crearSorpresa() {
        return new SorpresaPuntaje(this.VALOR_SORPRESA_FAVORABLE);
    }
}
