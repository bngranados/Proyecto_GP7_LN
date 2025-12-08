package Proyecto_Avance3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Mazo
 {
    // Pila de cartas del mazo (tope = siguiente carta a robar)
    private final Stack<Carta> cartas;

    public Mazo() 
    {
        cartas = new Stack<>();
    }

    /** Agrega una carta al tope del mazo. */
    public void push(Carta c) 
    {
        if (c != null) {
            cartas.push(c);
        }
    }

    /** Extrae y devuelve la carta del tope del mazo. Devuelve null si está vacío. */
    public Carta pop() 
    {
        if (cartas.isEmpty())
        {
            return null;
        }
        return cartas.pop();
    }

    /** Indica si el mazo está vacío. */
    public boolean isEmpty() 
    {
        return cartas.isEmpty();
    }

    /** Cantidad de cartas en el mazo. */
    public int size() 
    {
        return cartas.size();
    }

    /** Agrega todas las cartas de una lista (por ejemplo, desde la caja) al mazo. */
    public void addAllFromCaja(List<Carta> listaCaja) 
    {
        if (listaCaja == null || listaCaja.isEmpty()) 
        {
            return;
        }
        cartas.addAll(listaCaja);
    }

    /** Baraja aleatoriamente las cartas del mazo. */
    public void shuffle() 
    {
        Collections.shuffle(cartas);
    }

    /**
     * Devuelve la lista interna de cartas.
     * OJO: si modificas esta lista, modificas también el mazo.
     */
    public List<Carta> getCartas() 
    {
        return cartas;
    }

    /**
     * Devuelve una copia de la lista de cartas para solo lectura o visualización.
     * (Usa ArrayList en vez de List.copyOf para ser compatible con Java 8.)
     */
    public List<Carta> getCardsSnapshot() 
    {
        return new ArrayList<>(cartas);
    }

     /** Elimina todas las cartas del mazo. */
    public void clear() {
        cartas.clear();
    }
}
