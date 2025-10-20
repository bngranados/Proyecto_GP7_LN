package Logica;

public class Carta {

  private final String palo;  
  private final String color;   
  private final String valor;   
  private final String nombre;  
  private final int numero;     


  
  public Carta(String palo, String valor, String nombre, int numero, int id) {
    this.palo = palo;
    this.valor = valor;
    this.nombre = nombre;
    this.numero = numero;
    
    this.color = (palo.equals("♥") || palo.equals("♦")) ? "rojo" : "negro";
  }

  
  public Carta(String palo, String valor, String nombre, int numero) {
    this(palo, valor, nombre, numero, 0);
  }

  public String getPalo() { return palo; }
  public String getColor() { return color; }
  public String getValor() { return valor; }
  public String getNombre() { return nombre; }
  public int getNumero() { return numero; }
 

  public int compararPorNumero(Carta otra) {
    return Integer.compare(this.numero, otra.numero);    
  }

  @Override
  public String toString() {
    return "[" + valor + "|" + palo + "] " + nombre + " (" + color + ")" ;
  }

  public static void main(String[] args) {
    Carta carta1 = new Carta("♥", "A", "As", 1);
    Carta carta2 = new Carta("♣", "K", "Ka", 13, 51);

    System.out.println(carta1);
    System.out.println(carta2);
  }
}
