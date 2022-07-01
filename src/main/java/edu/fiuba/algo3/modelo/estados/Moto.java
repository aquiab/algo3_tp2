package edu.fiuba.algo3.modelo.estados;
import edu.fiuba.algo3.modelo.Vehiculo;

public class Moto extends Estado {

    public Moto(Vehiculo vehiculo) {
        super(vehiculo);
        this.PENALIZACION_POLICIAL = 3;
        this.PROBABILIDAD_CONTROL_POLICIAL = 7;
        this.PENALIZACION_POZO = 3;
        this.PENALIZACION_PIQUETE = 2;
    }

    public void pasarPiquete(double penalizacion) {
        vehiculo.incrementarMovimientos(penalizacion);
    }

    @Override
    public Estado siguienteEstado() {
        return new Auto(vehiculo);
    }

    public Auto aplicarSorpresaCambioVehiculo() {
        return (new Auto(vehiculo));
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
