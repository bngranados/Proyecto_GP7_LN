package Proyecto_Avance3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Mano {
    public static final int CAPACIDAD = 8;
    private final List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public boolean estaLlena() {
        return cartas.size() >= CAPACIDAD;
    }

    public void agregarCarta(Carta c) {
        if (!estaLlena()) cartas.add(c);
    }

    public void removerCarta(Carta c) {
        cartas.remove(c);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void limpiar() {
        cartas.clear();
    }

    public int size() {
        return cartas.size();
    }

    public void ordenar() {
        cartas.sort(Comparator.comparingInt(Carta::getNumero).thenComparing(Carta::getPalo));
    }
}
