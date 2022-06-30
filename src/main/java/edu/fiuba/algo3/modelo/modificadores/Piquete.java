package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.PiqueteConstructor;

public class Piquete implements IObstaculo {

    private final double penalizacion;

    public Piquete(PiqueteConstructor constructor) {
        this.penalizacion = constructor.obtenerPenalizacion();
    }

    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.pasarPiquete(this.penalizacion);
    }
}
