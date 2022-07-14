package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.obstaculos.VacioObstaculo;
import edu.fiuba.algo3.modelo.sorpresas.ISorpresa;
import edu.fiuba.algo3.modelo.sorpresas.VacioSorpresa;

public class Calle {
    private IObstaculo obstaculo = new VacioObstaculo();
    private ISorpresa sorpresa = new VacioSorpresa();
    public void recorrer(Vehiculo vehiculo) {
        obstaculo.pasar(vehiculo);
        sorpresa.aplicar(vehiculo);
        borrarSorpresa();
    }

    public void agregarObstaculo(IObstaculo obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void agregarSorpresa(ISorpresa sorpresa) {
        this.sorpresa = sorpresa;
    }

    public void borrarSorpresa() {
        this.sorpresa = new VacioSorpresa();
    }

    public IObstaculo obtenerObstaculo() {
        return this.obstaculo;
    }
    public ISorpresa obtenerSorpresa() {
        return this.sorpresa;
    }
}