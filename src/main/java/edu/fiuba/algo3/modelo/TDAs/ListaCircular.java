package edu.fiuba.algo3.modelo.TDAs;

import edu.fiuba.algo3.modelo.Modificador;

public class ListaCircular {
    Nodo inicio;
    Nodo fin;

    Nodo actual;

    public ListaCircular() {
        this.inicio = null;
        this.fin = null;

    }

    public void agregar(Modificador elemento) {
        Nodo aux = new Nodo(elemento, null);
        if(this.inicio == null) {
            this.inicio = aux;
            this.fin = aux;
            this.actual = aux;
            return;
        }
        this.fin.siguiente = aux;
        this.fin = aux;
    }

    public Modificador verActual() {
        return this.actual.valor;
    }

    public void avanzar() {
        if (this.actual == this.fin) {
            this.actual = this.inicio;
            return;
        }
        this.actual = this.actual.siguiente;
    }
}
