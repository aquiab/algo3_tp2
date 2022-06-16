package edu.fiuba.algo3.modelo.TDAs;

import edu.fiuba.algo3.modelo.Modificador;

public class Nodo {

    public Modificador valor;
    public Nodo siguiente;

    public Nodo(Modificador elemento, Nodo sig) {
        this.valor = elemento;
        this.siguiente = sig;
    }
}
