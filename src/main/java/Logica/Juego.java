package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
//todo esto es un boceto de como seguira el proyecto

public class Juego {

    private Stack<Carta> mazo;       // Cartas boca abajo
    private ArrayList<Carta> mano;   // Cartas visibles
    private Stack<Carta> pozo;       // Cartas descartadas

    public Juego() {
        mazo = new Stack<>();
        mano = new ArrayList<>();
        pozo = new Stack<>();
    }

    // Inicia la partida: crea baraja y reparte 8 cartas 
    public void iniciar() {
        System.out.println("Iniciando la partida...");
        crearBaraja();
        barajar();
        repartir();
        mostrarEstado();
    }

    // Crea las 52 cartas y las pone en la pila del mazo
    private void crearBaraja() {
        String[] palos = {"♥", "♦", "♠", "♣"};
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] nombres = {"As","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez","Jota","Quina","Ka"};

        for (String palo : palos) {
            for (int i = 0; i < valores.length; i++) {
                Carta c = new Carta(palo, valores[i], nombres[i], i+1);
                mazo.push(c);
            }
        }
    }

    /// Baraja el mazo 
    private void barajar() {
        ArrayList<Carta> temp = new ArrayList<>();
        while (!mazo.isEmpty()) {
            temp.add(mazo.pop());
        }
        Collections.shuffle(temp);
        for (Carta c : temp) {
            mazo.push(c);
        }
        System.out.println("Mazo barajado.");
    }

   // Reparte 8 cartas a la mano desde mazo 
    private void repartir() {
        mano.clear();
        for (int i = 0; i < 8 && !mazo.isEmpty(); i++) {
            mano.add(mazo.pop());
        }
        System.out.println("Repartidas 8 cartas a la mano.");
    }

    // Muestra el estado actual del juego
    public void mostrarEstado() {
        System.out.println("\n=== ESTADO DEL JUEGO ===");
        System.out.println("Mazo: " + mazo.size() + " cartas");
        System.out.println("Mano: " + mano);
        System.out.println("Pozo: " + pozo.size() + " cartas");
        System.out.println("========================\n");
    }

    public int validarSandwich(Carta c1, Carta c2, Carta c3) {
        return validarPermutaciones(new Carta[]{c1, c2, c3}, 0, 0);
    }

    private int validarPermutaciones(Carta[] cartas, int index, int maxCartas) {
        if (index == cartas.length) {
            // permutación actual
            int resultado = evaluarTripleta(cartas[0], cartas[1], cartas[2]);
            return Math.max(maxCartas, resultado);
        }

        for (int i = index; i < cartas.length; i++) {
            // Intercambiar para permutación
            Carta temp = cartas[index];
            cartas[index] = cartas[i];
            cartas[i] = temp;

          
            maxCartas = validarPermutaciones(cartas, index + 1, maxCartas);

       
            temp = cartas[index];
            cartas[index] = cartas[i];
            cartas[i] = temp;
        }
        return maxCartas;
    }

    // Evalua una tripleta fija 
    private int evaluarTripleta(Carta a, Carta b, Carta c) {
        int diff1 = Math.abs(a.getNumero() - b.getNumero());
        int diff2 = Math.abs(b.getNumero() - c.getNumero());

        // Ajusta "vuelta" de K a A
        if (a.getNumero() > b.getNumero()) diff1 = (13 - a.getNumero() + b.getNumero());
        if (b.getNumero() > c.getNumero()) diff2 = (13 - b.getNumero() + c.getNumero());

        // Verifica sandwich
        if (diff1 == diff2) {
        
            if (a.getPalo().equals(b.getPalo()) && b.getPalo().equals(c.getPalo())) return 4;
           
            if (a.getColor().equals(b.getColor()) && b.getColor().equals(c.getColor())) return 3;
         
            return 2;
        }
        return 0;
    }
}