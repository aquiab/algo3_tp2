package edu.fiuba.algo3.modelo.sorpresas;

public class SorpresaDesfavorableFabrica implements ISorpresaFabrica {

    private static final double VALOR_SORPRESA_DESFAVORABLE = 1.25;

    @Override
    public ISorpresa crearSorpresa() {
        SorpresaPuntaje sorpresa = new SorpresaPuntaje();
        sorpresa.asignarValor(VALOR_SORPRESA_DESFAVORABLE);
        return sorpresa;
    }

}
