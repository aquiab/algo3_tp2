package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.PozoConstructor;

public class Pozo implements IObstaculo {

    private double penalizacionPozo;

    public Pozo(PozoConstructor constructor) {
        this.penalizacionPozo = constructor.obtenerPenalizacion();
    }

    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.pasarPozo(this.penalizacionPozo);
    }


}
