package edu.fiuba.algo3.modelo;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {
	int mapSize = ThreadLocalRandom.current().nextInt(10, 20);
	Mapa mapa = new Mapa(mapSize);
	Vehiculo vehiculo = new Auto(0);
}
