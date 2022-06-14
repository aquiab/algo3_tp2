package edu.fiuba.algo3.modelo;

public class Piquete extends Obstaculo {

    private final float PENALIZACION_POR_PASAR_PIQUETE = 2;
    @Override
    public void aplicar(Vehiculo vehiculo) throws CaminoCortado {
        if (vehiculo.getClass() != Moto.class) throw new CaminoCortado();
        vehiculo.aumentarPuntos(PENALIZACION_POR_PASAR_PIQUETE);
    }
}
