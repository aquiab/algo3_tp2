package edu.fiuba.algo3.modelo;
import java.util.HashMap;

public class Esquina {
    HashMap<String, Tuple> map = new HashMap<>();

    Esquina() { //lleno el diccionario de la esquina
        map.put("up", null);
        map.put("down", null);
        map.put("right", null);
        map.put("left", null);
    }
    Tuple devolver_esquina_calle(String direccion) {
        return map.get(direccion);
    }
    public void modificarDiccionario(Tuple tupla, String str) {
        map.put(str, tupla);
    }
}
