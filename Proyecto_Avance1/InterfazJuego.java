package Proyecto_Avance1;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfazJuego extends javax.swing.JFrame {

    private Juego juego;

    public InterfazJuego() {
        initComponents();
        setTitle("Juego de Cartas - Sandwich");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setLayout(new BorderLayout());

        juego = new Juego();
        mostrarCartasCaja(juego.getCaja());
    }

    private void mostrarCartasCaja(List<Carta> listaCartas) {
        JPanelCaja.setLayout(new BorderLayout());
        
        JPanel cartasPanel = new JPanel();
        
        if (listaCartas.size() == 52) {
            cartasPanel.setLayout(new GridLayout(4, 13, 5, 5));
        } else {
            cartasPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        }
        
        for (Carta carta : listaCartas) {
            JButton cartaBoton = new JButton(carta.getValor() + carta.getPalo());
            
            cartaBoton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            cartaBoton.setOpaque(true);
            cartaBoton.setBackground(Color.WHITE);
            cartaBoton.setPreferredSize(new Dimension(80, 50));
            
            if (carta.getColor().equals("rojo")) {
                cartaBoton.setForeground(Color.RED);
            } else {
                cartaBoton.setForeground(Color.BLACK);
            }
            
            cartasPanel.add(cartaBoton);
        }
        
        Component[] components = JPanelCaja.getComponents();
        for (Component component : components) {
            if (component != jLabel1) {
                JPanelCaja.remove(component);
            }
        }
        
        JPanelCaja.add(jLabel1, BorderLayout.NORTH);
        JPanelCaja.add(cartasPanel, BorderLayout.CENTER);
        
        JPanelCaja.revalidate();
        JPanelCaja.repaint();
    }
    
    private void actualizarVistasJuego() {
        mostrarCartasCaja(juego.getCaja()); 
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        JPanelCaja = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPanelMano = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JPanelOpciones = new javax.swing.JPanel();
        btnNuevaP = new javax.swing.JButton();
        btnOrdenar = new javax.swing.JButton();
        bntValidar = new javax.swing.JButton();
        bntGuardar = new javax.swing.JButton();
        bntCargarP = new javax.swing.JButton();
        JPanelMazo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JPanelPozo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel1.setText("Caja de cartas:");
        
        
        JPanelMano.setLayout(new FlowLayout());
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel2.setText("Mano:");

        javax.swing.GroupLayout JPanelManoLayout = new javax.swing.GroupLayout(JPanelMano);
        JPanelMano.setLayout(JPanelManoLayout);
        JPanelManoLayout.setHorizontalGroup(
            JPanelManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelManoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelManoLayout.setVerticalGroup(
            JPanelManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelManoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        btnNuevaP.setText("Nueva partida");
        btnNuevaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPActionPerformed(evt);
            }
        });

        btnOrdenar.setText("Barajar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarajarActionPerformed(evt);
            }
        });

        bntValidar.setText("Validar");

        bntGuardar.setText("Guardar");

        bntCargarP.setText("Cargar partida");

        javax.swing.GroupLayout JPanelOpcionesLayout = new javax.swing.GroupLayout(JPanelOpciones);
        JPanelOpciones.setLayout(JPanelOpcionesLayout);
        JPanelOpcionesLayout.setHorizontalGroup(
            JPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevaP)
                .addGap(18, 18, 18)
                .addComponent(bntCargarP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(btnOrdenar)
                .addGap(18, 18, 18)
                .addComponent(bntValidar)
                .addGap(18, 18, 18)
                .addComponent(bntGuardar)
                .addGap(19, 19, 19))
        );
        JPanelOpcionesLayout.setVerticalGroup(
            JPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevaP)
                    .addComponent(btnOrdenar)
                    .addComponent(bntValidar)
                    .addComponent(bntGuardar)
                    .addComponent(bntCargarP))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        JPanelMazo.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel3.setText("Mazo:");

        javax.swing.GroupLayout JPanelMazoLayout = new javax.swing.GroupLayout(JPanelMazo);
        JPanelMazo.setLayout(JPanelMazoLayout);
        JPanelMazoLayout.setHorizontalGroup(
            JPanelMazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMazoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        JPanelMazoLayout.setVerticalGroup(
            JPanelMazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMazoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(282, Short.MAX_VALUE))
        );

        JPanelPozo.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel4.setText("Pozo:");

        javax.swing.GroupLayout JPanelPozoLayout = new javax.swing.GroupLayout(JPanelPozo);
        JPanelPozo.setLayout(JPanelPozoLayout);
        JPanelPozoLayout.setHorizontalGroup(
            JPanelPozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPozoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelPozoLayout.setVerticalGroup(
            JPanelPozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPozoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPanelCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPanelMano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JPanelPozo, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(JPanelMazo, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPanelCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JPanelMano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPanelMazo, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(JPanelPozo, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }

    private void btnNuevaPActionPerformed(java.awt.event.ActionEvent evt) {
        juego = new Juego();
        actualizarVistasJuego();
    }

    private void btnBarajarActionPerformed(java.awt.event.ActionEvent evt) {
        if (juego.getCaja().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Las cartas ya estan en el Mazo y mezcladas.");
            return;
        }
        
        juego.barajarYPrepararMazo();
        
        mostrarCartasCaja(juego.getCaja()); 
        
        JOptionPane.showMessageDialog(this, "Baraja mezclada. Ahora hay " + juego.getMazo().size() + " cartas en el Mazo.");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazJuego().setVisible(true);
            }
        });
    }

    private javax.swing.JPanel JPanelCaja;
    private javax.swing.JPanel JPanelMano;
    private javax.swing.JPanel JPanelMazo;
    private javax.swing.JPanel JPanelOpciones;
    private javax.swing.JPanel JPanelPozo;
    private javax.swing.JButton bntCargarP;
    private javax.swing.JButton bntGuardar;
    private javax.swing.JButton bntValidar;
    private javax.swing.JButton btnNuevaP;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
}