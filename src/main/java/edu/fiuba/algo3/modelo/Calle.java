package edu.fiuba.algo3.modelo;
import java.util.HashMap;

public class Calle {
    private HashMap<String, Tuple> adyacentes = new HashMap<>();
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
