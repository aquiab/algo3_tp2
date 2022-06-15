package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Calle {
    public Obstaculo obstaculo;
    public Sorpresa sorpresa;
    Random rand = new Random();

    Calle() {
        //Obstaculo[] obstaculos = {new Pozo(), new Piquete(), new ControlPolicial(), null, null, null};
        Obstaculo[] obstaculos = {new ControlPolicial()};
        Sorpresa[] sorpresas = {new Sorpresa(), null, null, null};
        this.obstaculo = obstaculos[rand.nextInt(obstaculos.length)];
        this.sorpresa = sorpresas[rand.nextInt(sorpresas.length)];
    }

    public void aplicarObstaculo(Vehiculo vehiculo) {
        obstaculo.aplicarObstaculo(vehiculo);
    }
}
