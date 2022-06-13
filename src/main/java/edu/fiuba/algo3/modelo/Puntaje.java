package edu.fiuba.algo3.modelo;

public class Puntaje {

    private double puntos;

    public Puntaje() {
        puntos = 0;
    }

    public void aumentarPuntos(double puntosAumentados) {
        puntos += puntosAumentados;
    }

    public void multiplicarPor(double descuento) {
        //Util para hacer los descuentos
        puntos *= descuento;
    }

    public double obtenerCantidadTotalMovimientos() {
        return puntos;
    }
}
