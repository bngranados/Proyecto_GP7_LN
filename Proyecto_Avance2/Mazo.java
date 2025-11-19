package Proyecto_Avance2;

// Por instrucciones del profesor, la clase aun no es funcional.

import java.util.Stack;

public class Mazo {

    private Stack<Carta> cartas;

    public Mazo() {
        cartas = new Stack<>();
    }

    public Stack<Carta> getCartas() {
        return cartas;
    }

    public void push(Carta c) {
        cartas.push(c);
    }

    public void clear() {
        cartas.clear();
    }
}