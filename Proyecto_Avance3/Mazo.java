package Proyecto_Avance3;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Mazo {
    private final Stack<Carta> cartas;

    public Mazo() {
        cartas = new Stack<>();
    }

    public void push(Carta c) {
        cartas.push(c);
    }

    public Carta pop() {
        if (cartas.isEmpty()) return null;
        return cartas.pop();
    }

    public int size() {
        return cartas.size();
    }

    public boolean isEmpty() {
        return cartas.isEmpty();
    }

    public void clear() {
        cartas.clear();
    }

    public void addAllFromCaja(List<Carta> listaCaja) {
        cartas.addAll(listaCaja);
    }

    public void shuffle() {
        Collections.shuffle(cartas);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public List<Carta> getCardsSnapshot() {
        return List.copyOf(cartas);
    }
}
