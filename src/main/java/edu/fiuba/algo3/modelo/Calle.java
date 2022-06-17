package edu.fiuba.algo3.modelo;

public class Calle {
    public Modificador obstaculo;
    public Modificador sorpresa;

    public void recorrer(Vehiculo vehiculo) {
        if (obstaculo != null) {
            obstaculo.aplicar(vehiculo);
        }
        if (sorpresa != null) {
            sorpresa.aplicar(vehiculo);
        }
    }

    public void agregarObstaculo(Modificador obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void agregarSorpresa(Modificador sorpresa) {
        this.sorpresa = sorpresa;
    }

    
}
