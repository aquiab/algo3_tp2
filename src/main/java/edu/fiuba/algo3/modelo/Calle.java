package edu.fiuba.algo3.modelo;
import java.util.Random;

public class Calle {
    public String obstaculo;
    public String sorpresa;
    //Calle(String obs, String sorp) {
        //obstaculo = obs;
        //sorpresa = sorp;
    //}

    Calle() {

        String[] obstaculos = {"pozo", "piquete", "policial", null};
        String[] sorpresas = {"favorable", "desfavorable", "vehiculo", null};
        Random rand1 = new Random();
        Random rand2 = new Random();
        int obs = rand1.nextInt(4);
        int sor = rand2.nextInt(4);
        this.obstaculo = obstaculos[obs];
        this.sorpresa = sorpresas[sor];
    }
}
