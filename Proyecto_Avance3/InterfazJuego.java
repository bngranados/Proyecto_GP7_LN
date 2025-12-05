package Proyecto_Avance3;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InterfazJuego extends JFrame {
    private Juego juego;
    private boolean mostrarMazo = false;
    private boolean mostrarMano = true;
    private final Color VERDE_MESA = new Color(6, 90, 45);
    private final Color DORADO = new Color(255, 215, 0);
    private final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 18);
    private final Font FUENTE_CARTA = new Font("Segoe UI", Font.BOLD, 14);
    private final Font FUENTE_BOTON = new Font("Segoe UI", Font.BOLD, 13);
    private JPanel panelCaja, panelMazo, panelMano, panelPozo, panelOpciones;
    private JButton btnNueva, btnBarajar, btnMostrarMazo, btnMostrarMano, btnValidar, btnOrdenar, btnGuardar, btnCargar;
    private List<JToggleButton> botonesMano = new ArrayList<>();

    public InterfazJuego() {
        setTitle("The Sandwich Guy — Mesa Verde");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1150, 680);
        setLocationRelativeTo(null);
        getContentPane().setBackground(VERDE_MESA);
        juego = new Juego();
        crearComponentes();
        armarLayout();
        refrescarTodo();
    }

    private void crearComponentes() {
        panelCaja = crearPanelContenedor();
        panelMazo = crearPanelContenedor();
        panelMano = crearPanelContenedor();
        panelPozo = crearPanelContenedor();
        panelOpciones = new JPanel();
        panelOpciones.setOpaque(false);
        panelOpciones.setLayout(new GridLayout(2, 4, 10, 8));
        btnNueva = crearBoton("Nueva partida", e -> { juego = new Juego(); mostrarMazo = false; mostrarMano = true; refrescarTodo(); });
        btnBarajar = crearBoton("Barajar", e -> { juego.barajarYPrepararMazo(); refrescarTodo(); });
        btnMostrarMazo = crearBoton("Mostrar mazo", e -> { mostrarMazo = !mostrarMazo; btnMostrarMazo.setText(mostrarMazo ? "Ocultar mazo" : "Mostrar mazo"); refrescarTodo(); });
        btnMostrarMano = crearBoton("Ocultar mano", e -> { mostrarMano = !mostrarMano; btnMostrarMano.setText(mostrarMano ? "Ocultar mano" : "Mostrar mano"); refrescarTodo(); });
        btnValidar = crearBoton("Validar", e -> validarMano());
        btnOrdenar = crearBoton("Ordenar mano", e -> { juego.getMano().ordenar(); refrescarTodo(); });
        btnGuardar = crearBoton("Guardar", e -> guardarPartida());
        btnCargar = crearBoton("Cargar", e -> cargarPartida());
        panelOpciones.add(btnNueva);
        panelOpciones.add(btnBarajar);
        panelOpciones.add(btnMostrarMazo);
        panelOpciones.add(btnMostrarMano);
        panelOpciones.add(btnValidar);
        panelOpciones.add(btnOrdenar);
        panelOpciones.add(btnGuardar);
        panelOpciones.add(btnCargar);
    }

    private JPanel crearPanelContenedor() {
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        JPanel inner = new JPanel();
        inner.setOpaque(false);
        p.add(inner, BorderLayout.CENTER);
        return p;
    }

    private JButton crearBoton(String texto, java.awt.event.ActionListener l) {
        JButton b = new JButton(texto);
        b.setFont(FUENTE_BOTON);
        b.setBackground(DORADO);
        b.setForeground(Color.BLACK);
        b.setFocusPainted(false);
        b.addActionListener(l);
        return b;
    }

    private void armarLayout() {
        JPanel centro = new JPanel(new GridLayout(2, 2, 12, 12));
        centro.setOpaque(false);
        centro.add(wrapPanel("Caja", panelCaja));
        centro.add(wrapPanel("Mazo", panelMazo));
        centro.add(wrapPanel("Mano", panelMano));
        centro.add(wrapPanel("Pozo", panelPozo));
        add(panelOpciones, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
    }

    private JPanel wrapPanel(String titulo, JPanel contenido) {
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        JLabel l = new JLabel(titulo);
        l.setFont(FUENTE_TITULO);
        l.setForeground(DORADO);
        p.add(l, BorderLayout.NORTH);
        p.add(contenido, BorderLayout.CENTER);
        p.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        return p;
    }

    private void refrescarTodo() {
        refrescarCaja();
        refrescarMazo();
        refrescarMano();
        refrescarPozo();
        revalidate();
        repaint();
    }

    private void refrescarCaja() {
        panelCaja.removeAll();
        JPanel area = crearAreaCartas(false);
        for (Carta c : juego.getCaja().getCartas()) {
            area.add(crearBotonCartaVisible(c, false));
        }
        JScrollPane sp = new JScrollPane(area);
        sp.setBorder(null);
        sp.getViewport().setOpaque(false);
        sp.setOpaque(false);
        panelCaja.add(sp, BorderLayout.CENTER);
    }

    private void refrescarMazo() {
        panelMazo.removeAll();
        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
        if (juego.getMazo().isEmpty()) {
            JLabel vacio = new JLabel("Mazo vacío");
            vacio.setForeground(DORADO);
            center.add(vacio);
        } else if (!mostrarMazo) {
            int dorsos = Math.min(10, juego.getMazo().size());
            for (int i = 0; i < dorsos; i++) {
                JButton d = new JButton("🂠");
                d.setFont(FUENTE_CARTA);
                d.setPreferredSize(new Dimension(80, 40));
                d.setEnabled(false);
                d.setBackground(Color.DARK_GRAY);
                d.setForeground(Color.WHITE);
                center.add(d);
            }
            JLabel cont = new JLabel("Cartas: " + juego.getMazo().size());
            cont.setForeground(DORADO);
            center.add(cont);
        } else {
            for (Carta c : juego.getMazo().getCartas()) {
                center.add(crearBotonCartaVisible(c, false));
            }
        }
        JScrollPane sp = new JScrollPane(center);
        sp.setBorder(null);
        sp.getViewport().setOpaque(false);
        sp.setOpaque(false);
        panelMazo.add(sp, BorderLayout.CENTER);
    }

    private void refrescarMano() {
        panelMano.removeAll();
        JPanel area = crearAreaCartas(true);
        botonesMano.clear();
        if (!mostrarMano) {
            JLabel oculto = new JLabel("✦ Mano Oculta ✦");
            oculto.setForeground(DORADO);
            panelMano.add(oculto, BorderLayout.CENTER);
            return;
        }
        List<Carta> lista = juego.getMano().getCartas();
        for (int i = 0; i < lista.size(); i++) {
            Carta c = lista.get(i);
            JToggleButton tb = new JToggleButton(c.getValor() + c.getPalo());
            tb.setFont(FUENTE_CARTA);
            tb.setPreferredSize(new Dimension(100, 60));
            tb.setBackground(Color.WHITE);
            tb.setForeground(c.getColor().equals("rojo") ? Color.RED : Color.BLACK);
            int idx = i;
            tb.addActionListener(e -> toggleSeleccion(tb, idx));
            botonesMano.add(tb);
            area.add(tb);
        }
        JScrollPane sp = new JScrollPane(area);
        sp.setBorder(null);
        sp.getViewport().setOpaque(false);
        sp.setOpaque(false);
        panelMano.add(sp, BorderLayout.CENTER);
    }

    private JPanel crearAreaCartas(boolean grande) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        p.setOpaque(false);
        return p;
    }

    private JButton crearBotonCartaVisible(Carta c, boolean grande) {
        JButton b = new JButton(c.getValor() + c.getPalo());
        b.setFont(FUENTE_CARTA);
        b.setPreferredSize(grande ? new Dimension(100, 60) : new Dimension(80, 45));
        b.setBackground(Color.WHITE);
        b.setForeground(c.getColor().equals("rojo") ? Color.RED : Color.BLACK);
        return b;
    }

    private void toggleSeleccion(JToggleButton tb, int idx) {
        int seleccionadas = (int) botonesMano.stream().filter(AbstractButton::isSelected).count();
        if (tb.isSelected() && seleccionadas > 3) {
            tb.setSelected(false);
            JOptionPane.showMessageDialog(this, "Sólo puedes seleccionar hasta 3 cartas.");
            return;
        }
        if ((int) botonesMano.stream().filter(AbstractButton::isSelected).count() == 3) {
            List<Carta> seleccion = new ArrayList<>();
            for (int i = 0; i < botonesMano.size(); i++)
                if (botonesMano.get(i).isSelected())
                    seleccion.add(juego.getMano().getCartas().get(i));
            List<String> detalle = juego.detallePermutaciones(seleccion);
            StringBuilder sb = new StringBuilder();
            for (String s : detalle) sb.append(s).append("\n");
            int opcion = JOptionPane.showConfirmDialog(this, sb.toString(), "Permutaciones (4/3/2/0). Enviar al pozo?", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                String res = juego.aplicarDescartarYRefrescar(seleccion);
                for (JToggleButton t : botonesMano) t.setSelected(false);
                refrescarTodo();
                JOptionPane.showMessageDialog(this, res);
            } else {
                for (JToggleButton t : botonesMano) t.setSelected(false);
            }
        }
    }

    private void validarMano() {
        boolean existe = juego.existeSandwichEnMano();
        if (!existe) {
            JOptionPane.showMessageDialog(this, "PERDISTE. No existen sándwiches válidos en la mano.");
            btnBarajar.setEnabled(false);
            btnMostrarMazo.setEnabled(false);
            btnMostrarMano.setEnabled(false);
            btnValidar.setEnabled(false);
            btnOrdenar.setEnabled(false);
            btnGuardar.setEnabled(true);
            btnCargar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Hay al menos un sándwich válido en la mano.");
        }
    }

    private void guardarPartida() {
        JFileChooser fc = new JFileChooser();
        int r = fc.showSaveDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            try {
                juego.guardarA(f);
                JOptionPane.showMessageDialog(this, "Guardado OK");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error guardando: " + ex.getMessage());
            }
        }
    }

    private void cargarPartida() {
        JFileChooser fc = new JFileChooser();
        int r = fc.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            try {
                juego.cargarDe(f);
                refrescarTodo();
                JOptionPane.showMessageDialog(this, "Partida cargada");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error cargando: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazJuego v = new InterfazJuego();
            v.setVisible(true);
        });
    }

    private void refrescarPozo() {
        panelPozo.removeAll();
        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 6));
        center.setOpaque(false);
        List<Carta> lista = juego.getPozo().getCardsSnapshot();
        if (lista.isEmpty()) {
            JLabel vacio = new JLabel("Pozo vacío");
            vacio.setForeground(DORADO);
            center.add(vacio);
        } else {
            for (Carta c : lista) {
                center.add(crearBotonCartaVisible(c, false));
            }
        }
        JScrollPane sp = new JScrollPane(center);
        sp.setBorder(null);
        sp.getViewport().setOpaque(false);
        sp.setOpaque(false);
        panelPozo.add(sp, BorderLayout.CENTER);
    }
}
