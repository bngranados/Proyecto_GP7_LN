package Proyecto_Avance2;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Carta {

  private final String palo;
  private final String color;
  private final String valor;
  private final String nombre;
  private final int numero;

  public Carta(String palo, String valor, String nombre, int numero) {
    this.palo = palo;
    this.valor = valor;
    this.nombre = nombre;
    this.numero = numero;
    this.color = (palo.equals("♥") || palo.equals("♦")) ? "rojo" : "negro";
  }

  public String getPalo() {
    return palo;
  }

  public String getColor() {
    return color;
  }

  public String getValor() {
    return valor;
  }

  public String getNombre() {
    return nombre;
  }

  public int getNumero() {
    return numero;
  }

  @Override
  public String toString() {
    return "[" + valor + "|" + palo + "] " + nombre + " (" + color + ")";
  }

  public static void main(String[] args) {
    try {
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          Carta carta = new Carta("♥", "A", "As", 1);
          System.out.println(carta);

          InterfazJuego ventana = new InterfazJuego();
          ventana.setVisible(true);
          ventana.setLocationRelativeTo(null);
          break;
        }
      }
    } catch (Exception e) {
      // If Nimbus is not available, you can set the GUI to another look and feel.
    }

  }

}
