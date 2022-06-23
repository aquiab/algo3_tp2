package edu.fiuba.algo3.modelo.modificadores;

public class Sorpresas {

    //ES LA ESPECIE DE GENERADOR!!!!!!!!!!!!!!!!!!!!!!!!!

    private SorpresaFavorable sorpresaFavorable;
    private SorpresaDesfavorable sorpresaDesfavorable;
    private SorpresaVehiculo sorpresaVehiculo;

    private Sorpresa actual;

    public Sorpresas() {
        sorpresaFavorable = new SorpresaFavorable();
        sorpresaDesfavorable = new SorpresaDesfavorable();
        sorpresaVehiculo = new SorpresaVehiculo();

        actual = sorpresaFavorable;
    }

    public Sorpresa devolverSorpresa() {
        Sorpresa obstaculoAuxiliar = actual;
        siguienteSorpresa();
        return obstaculoAuxiliar;
    }

    private void siguienteSorpresa() {
        if (actual.getClass() == SorpresaFavorable.class) {
            actual = sorpresaDesfavorable;
        } else if (actual.getClass() == SorpresaDesfavorable.class) {
            actual = sorpresaVehiculo;
        } else {
            actual = sorpresaFavorable;
        }
    }
}
