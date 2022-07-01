package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.sistema_de_posicion.Posicion;
import edu.fiuba.algo3.modelo.Vehiculo;

public class Auto extends Estado {

    public Auto(Vehiculo vehiculo) {
        super(vehiculo);
        this.PENALIZACION_POLICIAL = 3;
        this.PENALIZACION_POZO = 3;
        this.PROBABILIDAD_CONTROL_POLICIAL = 5;
    }

    public void pasarPiquete(double penalizacion) {
        Posicion posicion = vehiculo.devolverPosicion();
        posicion.defaultearSig();
    }

    public Camioneta aplicarSorpresaCambioVehiculo() {
        return (new Camioneta(vehiculo));
    }

    @Override
    public Estado siguienteEstado() {
        return new Camioneta(vehiculo);
    }

    @Override
    public double obtenerPenalizacionPozo() {
        return this.PENALIZACION_POZO;
    }

    @Override
    public double obtenerProbabilidadControl() {
        return this.PROBABILIDAD_CONTROL_POLICIAL;
    }

    @Override
    public double obtenerPenalizacionPiquete() {
        return this.PENALIZACION_PIQUETE;
    }
}
