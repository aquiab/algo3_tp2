package edu.fiuba.algo3.modelo;
public class Usuario {
    private Vehiculo vehiculo;

    void hacerMovimiento(String direccion) {
        Sorpresa sorpresa = vehiculo.hacerMovimiento(direccion);
        if (sorpresa != null) sorpresa.aplicar(this);
    }
    Vehiculo devolverVehiculo() {
        return vehiculo;
    }

    public void establecerVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double cantidadDeMovimientos() {
        return vehiculo.obtenerMovimientos();
    }

    public void asignarPosicionInicial(Esquina esquina) {
        vehiculo.asignarPosicionInicial(esquina);
    }
}

/*
Usuario.hacerMovimiento("arriba")
se lee de los atributos de la esquina la tupla
se actualiza la nueva esquina
de la calle se toma el obstaculo
se delega al vehiculo aplicar el obstaculo
se delega al usuario aplicar la sorpresa
*/