package edu.fiuba.algo3.modelo;

public class Auto extends Vehiculo{

    public Auto(double movimientos) {
        super(movimientos);
    }

    public void pasarPozo() {
        this.movimientos += 3;
    }

    public void pasarPiquete() {
        
    }
    
    public Camioneta aplicarSorpresaCambioVehiculo() {
        return (new Camioneta(this.movimientos));
    }
}
