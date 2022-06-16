package edu.fiuba.algo3.modelo;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {
	int mapSize = ThreadLocalRandom.current().nextInt(10, 20);

	Vehiculo vehiculo = new Vehiculo(0, new Posicion(0, 0));

	public Mapa mapa = Mapa.generarMapa(mapSize);

	//Juego() {
		//this.mapa.printear(this.mapa.callesHorizontales);
		//System.out.println("----------Calles verticales------------");
		//this.mapa.printear(this.mapa.callesVerticales);
	//}

	public void mover(Direccion direccion) {
		this.vehiculo.mover(direccion);
	}
}