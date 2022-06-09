package edu.fiuba.algo3.modelo;

public class Calle {
    private Sorpresa sorpresa;
    private Obstaculo obstaculo;
    Calle(Sorpresa i, Obstaculo j) {
        sorpresa = i;
        obstaculo = j;
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
