package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.Estado;
import edu.fiuba.algo3.modelo.modificadores.*;

public class Director {

    /*----Sorpresas----*/

    public ISorpresa generarVacioSorpresa() {
        return new VacioSorpresa();
    }

    public ISorpresa generarSorpresaFavorable() {
        SorpresaPuntajeConstructor constructor = new SorpresaPuntajeConstructor();
        constructor.valorSopresa(0.8);
        return constructor.construir();
    }

    public ISorpresa generarSorpresaDesfavorable() {
        SorpresaPuntajeConstructor constructor = new SorpresaPuntajeConstructor();
        constructor.valorSopresa(1.25);
        return constructor.construir();
    }

    public ISorpresa generarSorpresaCambioDeVehiculo() {
        SorpresaVehiculoConstructor constructor = new SorpresaVehiculoConstructor();
        return constructor.construir();
    }

    public ISorpresa generarSopresa(int codigo) {
        switch (codigo%3) {
            case 0:
                return generarSorpresaFavorable();
            case 1:
                return generarSorpresaDesfavorable();
        }
        return generarSorpresaCambioDeVehiculo();
    }

    /*----Obstáculos----*/

    public IObstaculo generarVacioObstaculo() {
        return new VacioObstaculo();
    }

    public IObstaculo generarPozo() {
        PozoConstructor constructor = new PozoConstructor();
        constructor.penalizacion(3);
        return constructor.construir();
    }
}
