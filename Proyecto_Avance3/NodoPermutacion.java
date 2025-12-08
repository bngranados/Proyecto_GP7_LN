package Proyecto_Avance3;

import java.util.List;

public class NodoPermutacion {
    List<Carta> tripleta;
    int valor;
    NodoPermutacion izquierda;
    NodoPermutacion derecha;

    public NodoPermutacion(List<Carta> tripleta, int valor) {
        this.tripleta = tripleta;
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    @Override
    public String toString() {
        return tripleta.get(0) + " " + tripleta.get(1) + " " + tripleta.get(2) + " -> " + valor;
    }
}
