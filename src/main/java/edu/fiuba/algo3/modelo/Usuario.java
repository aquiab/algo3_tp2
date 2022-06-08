package edu.fiuba.algo3.modelo;
public class Usuario {
    Vehiculo vehiculo;
    Integer movimientos;
    Esquina posicion;

    void hacerMovimiento(String direccion) {
        vehiculo.hacerMovimiento(direccion);
    }
    Vehiculo devolverVehiculo() {
        return vehiculo;
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