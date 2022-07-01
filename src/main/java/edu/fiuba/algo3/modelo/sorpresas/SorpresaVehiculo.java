package edu.fiuba.algo3.modelo.sorpresas;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.constructores.SorpresaVehiculoConstructor;

public class SorpresaVehiculo implements ISorpresa {

    private Estado siguienteEstado;

    public SorpresaVehiculo(SorpresaVehiculoConstructor constructor) {
        this.siguienteEstado = constructor.obtenerSiguienteEstado();
    }

    @Override
    public void aplicar(Vehiculo vehiculo) {
        vehiculo.aplicarSorpresaCambioVehiculo(this.siguienteEstado);
    }

    @Override
    public void actualizar(double valor, Estado siguienteEstado) {
        this.siguienteEstado = siguienteEstado;
    }
}
