package edu.fiuba.algo3.modelo.modificadores;

public class Obstaculos {

    private ControlPolicial controlPolicial;
    private Piquete piquete;
    private Pozo pozo;

    private Obstaculo actual;

    public Obstaculos() {
        controlPolicial = new ControlPolicial();
        piquete = new Piquete();
        pozo = new Pozo();

        actual = controlPolicial;
    }

    public Obstaculo devolverObstaculo() {
        Obstaculo obstaculoAuxiliar = actual;
        siguienteObstaculo();
        return obstaculoAuxiliar;
    }

    private void siguienteObstaculo() {
        if (actual.getClass() == ControlPolicial.class) {
            actual = piquete;
        } else if (actual.getClass() == Piquete.class) {
            actual = pozo;
        } else {
            actual = controlPolicial;
        }
    }
}
