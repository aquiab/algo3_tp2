package edu.fiuba.algo3.modelo.obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.PozoConstructor;
import edu.fiuba.algo3.modelo.obstaculos.IObstaculo;

public class Pozo implements IObstaculo {

    private double penalizacion;

    public Pozo(PozoConstructor constructor) {
        this.penalizacion = constructor.obtenerPenalizacion();
    }

    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.pasarPozo(this.penalizacion);
    }

    @Override
    public void actualizar(double penalizacion, double probabilidad) {
        this.penalizacion = penalizacion;
    }


}
