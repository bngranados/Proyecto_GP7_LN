package Proyecto_Avance3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Pozo {
    private final Queue<Carta> cartas;

    public Pozo() {
        cartas = new ArrayDeque<>();
    }

    public void encolar(Carta c) {
        cartas.add(c);
    }

    public Carta sacar() {
        return cartas.poll();
    }

    public void limpiar() {
        cartas.clear();
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }

    public int size() {
        return cartas.size();
    }

    public List<Carta> getPozo() {
        return new ArrayList<>(cartas);
    }

    public List<Carta> getCardsSnapshot() {
        return new ArrayList<>(cartas);
    }
}
