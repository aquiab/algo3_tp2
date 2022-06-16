package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Calle {
    public Modificador obstaculo;
    public Modificador sorpresa;
    Random rand = new Random();

    Calle() {
        //Obstaculo[] obstaculos = {new Pozo(), new Piquete(), new ControlPolicial(), null, null, null};
        //Obstaculo[] obstaculos = {new Pozo()};
        //Sorpresa[] sorpresas = {new SorpresaDesfavorable()};
        //this.obstaculo = obstaculos[rand.nextInt(obstaculos.length)];
        //this.sorpresa = sorpresas[rand.nextInt(sorpresas.length)];
    }

    public void recorrer(Vehiculo vehiculo) {
        if (obstaculo != null) {
            obstaculo.aplicar(vehiculo);
        }
        if (sorpresa != null) {
            sorpresa.aplicar(vehiculo);
        }
    }

    public void agregarObstaculo(Modificador obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void agregarSorpresa(Modificador sorpresa) {
        this.sorpresa = sorpresa;
    }

    
}
