package Proyecto_Avance2;

import java.util.LinkedList;
import java.util.List;

public class Caja {

    private LinkedList<Carta> cartas;

    public Caja() {
        cartas = new LinkedList<>();
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void agregarCarta(Carta c) {
        cartas.add(c);
    }

    public void limpiar() {
        cartas.clear();
    }
}