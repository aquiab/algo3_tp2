package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.TDAs.ListaCircular;

public class Generador {

    private ListaCircular obstaculos;
    // pozo --> control --> piquete --> pozo --> ...

    private ListaCircular sorpresas;
    // fav --> des --> cambio --> fav --> ..

    public Generador() {
        this.obstaculos = new ListaCircular();
        this.obstaculos.agregar(new Pozo());
        this.obstaculos.agregar(new ControlPolicial());
        this.obstaculos.agregar(new Piquete());

        this.sorpresas = new ListaCircular();
        this.sorpresas.agregar(new SorpresaFavorable());
        this.sorpresas.agregar(new SorpresaDesfavorable());
        this.sorpresas.agregar(new SorpresaVehiculo());
    }

    public void generarObstaculo(Calle calle) {
        calle.agregarObstaculo(this.obstaculos.verActual());
        this.obstaculos.avanzar();
    }

    public void generarSorpresa(Calle calle) {
        calle.agregarSorpresa(this.sorpresas.verActual());
        this.sorpresas.avanzar();
    }
}
