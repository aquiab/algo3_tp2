package edu.fiuba.algo3.modelo.obstaculos;

import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.PiqueteConstructor;
import edu.fiuba.algo3.modelo.obstaculos.IObstaculo;

public class Piquete implements IObstaculo {

    private double penalizacion;

    public Piquete(PiqueteConstructor constructor) {
        this.penalizacion = constructor.obtenerPenalizacion();
    }

    @Override
    public void pasar(Vehiculo vehiculo) {
        vehiculo.pasarPiquete(this.penalizacion);
    }

    @Override
    public void actualizar(double penalizacion, double probabilidad) {
        this.penalizacion = penalizacion;
    }
}
