package edu.fiuba.algo3.modelo;

public class Calle {
    private Sorpresa sorpresa;
    private Obstaculo obstaculo;
    Calle(Sorpresa sor, Obstaculo obst) {
        sorpresa = sor;
        obstaculo = obst;
    }
    Sorpresa devolverSorpresa(){
        Sorpresa sorpresa1 = sorpresa;
        BorrarSorpresa();
        return sorpresa1;
    }
    Obstaculo devolverObstaculo(){
        return obstaculo;
    }

    void BorrarSorpresa() {
        sorpresa = null;
    }
}
