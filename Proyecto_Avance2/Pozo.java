package Proyecto_Avance2;

import java.util.LinkedList;
import java.util.Queue;

public class Pozo {

    private Queue<Carta> cartas;

    public Pozo() {
        cartas = new LinkedList<>();
    }

    public Queue<Carta> getCartas() {
        return cartas;
    }

    public void encolar(Carta c) {
        cartas.add(c);
    }

    public void limpiar() {
        cartas.clear();
    }
}