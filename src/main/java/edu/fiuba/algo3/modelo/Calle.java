package edu.fiuba.algo3.modelo;

public class Calle {
    Sorpresa sorpresa;
    Obstaculo obstaculo;
    Calle(Sorpresa i, Obstaculo j) {
        sorpresa = i;
        obstaculo = j;
    }
    Sorpresa devolverSorpresa(){
        return sorpresa;
    }
    Obstaculo devolverObstaculo(){
        return obstaculo;
    }
}
