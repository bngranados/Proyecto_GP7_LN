package Proyecto_Avance3;

import java.util.ArrayList;
import java.util.List;

public class Caja {
    private final List<Carta> cartas;

    public Caja() {
        cartas = new ArrayList<>();
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void agregarCarta(Carta c) {
        cartas.add(c);
    }

    public void agregarTodas(List<Carta> otras) {
        cartas.addAll(otras);
    }

    public void limpiar() {
        cartas.clear();
    }

    public boolean estaVacia() {
        return cartas.isEmpty();
    }

    public int size() {
        return cartas.size();
    }
}
