package edu.fiuba.algo3.modelo;
public class Tuple {
    Esquina x;
    Calle y;

    Tuple(Esquina i, Calle j){
        x = i;
        y = j;
    }

    Esquina devolverEsquina() {
        return x;
    }
    Calle devolverCalle() {
        return y;
    }
}
