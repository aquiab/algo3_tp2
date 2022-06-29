package edu.fiuba.algo3.modelo.constructores;

import edu.fiuba.algo3.modelo.Vehiculo;

public class PozoV2 implements IObstaculo {

    private double penalizacionPozo;

    public PozoV2(PozoConstructor constructor) {
        this.penalizacionPozo = constructor.obtenerPenalizacion();
    }

    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.pasarPozo(this.penalizacionPozo);
    }


}
