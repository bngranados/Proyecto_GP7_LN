package Proyecto_Avance3;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Carta {
    private final String palo;
    private final String valor;
    private final String nombre;
    private final int numero;

    public Carta(String palo, String valor, String nombre, int numero) {
        this.palo = palo;
        this.valor = valor;
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
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

    public String getColor() {
        return (palo.equals("♥") || palo.equals("♦")) ? "rojo" : "negro";
    }

    @Override
    public String toString() {
        return valor + palo;
    }

    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        InterfazJuego ventana = new InterfazJuego();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
}
