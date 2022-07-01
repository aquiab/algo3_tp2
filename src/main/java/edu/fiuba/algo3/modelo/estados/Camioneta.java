package edu.fiuba.algo3.modelo.estados;
import edu.fiuba.algo3.modelo.sistema_de_posicion.Posicion;
import edu.fiuba.algo3.modelo.Vehiculo;

public class Camioneta extends Estado {

    public Camioneta(Vehiculo vehiculo) {
        super(vehiculo);
        this.PENALIZACION_POLICIAL = 3;
        this.PENALIZACION_POZO = 2;
        this.PROBABILIDAD_CONTROL_POLICIAL = 2;
    }

    protected int cantidadPozos = 0;

    @Override
    public void pasarPozo(double penalizacion) {
        this.cantidadPozos++;
        if (this.cantidadPozos % 3 == 0) {
            vehiculo.incrementarMovimientos(penalizacion);
        }
    }

    public void pasarPiquete(double penalizacion) {
        Posicion posicion = vehiculo.devolverPosicion();
        posicion.defaultearSig();
    }
    public Moto aplicarSorpresaCambioVehiculo() {
        return (new Moto(vehiculo));
    }

    @Override
    public Estado siguienteEstado() {
        return new Moto(vehiculo);
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

