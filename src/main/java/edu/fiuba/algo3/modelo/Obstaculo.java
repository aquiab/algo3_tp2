package edu.fiuba.algo3.modelo;

public interface Obstaculo {
	public abstract void aplicarObstaculo(Vehiculo vehiculo);
	public abstract void aplicarObstaculo(Auto auto);
	public abstract void aplicarObstaculo(Moto moto);
	public abstract void aplicarObstaculo(Camioneta camioneta);
}
