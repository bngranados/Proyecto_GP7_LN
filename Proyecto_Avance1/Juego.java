package Proyecto_Avance1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

public class Juego {

    private LinkedList<Carta> caja;
    private Stack<Carta> mazo;
    private List<Carta> mano;
    private Queue<Carta> pozo;

    public Juego()
    {
        caja = new LinkedList<>();
        mazo = new Stack<>();
        mano = new LinkedList<>();
        pozo = new LinkedList<>();
        inicializarBaraja();
    }

    private void inicializarBaraja()
    {
        String[] palos = {"♥", "♦", "♠", "♣"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] nombres = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Jota", "Quina", "Ka"};

        for (String palo : palos) {
            for (int i = 0; i < valores.length; i++)
            {
                String valor = valores[i];
                String nombre = nombres[i];
                int numero = i + 1;
                Carta carta = new Carta(palo, valor, nombre, numero);
                caja.add(carta);
            }
        }
    }

    public void barajarYPrepararMazo() {
        mazo.addAll(caja);
        caja.clear();
        Collections.shuffle(mazo);
    }
    
    public LinkedList<Carta> getCaja()
    {
        return caja;
    }

    public List<Carta> getMano() {
        return mano;
    }
    
    public Stack<Carta> getMazo() {
        return mazo;
    }
    
    public Queue<Carta> getPozo() {
        return pozo;
    }
}
