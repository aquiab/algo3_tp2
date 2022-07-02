package edu.fiuba.algo3.modelo.fabrica_sorpresa;

public class SorpresaDesfavorableFabrica implements ISorpresaFabrica {

    private static final double VALOR_SORPRESA_DESFAVORABLE = 1.25;

    @Override
    public ISorpresa crearSorpresa() {
        return new SopresaPuntaje(this.VALOR_SORPRESA_DESFAVORABLE);
    }

}
