package Proyecto_Avance3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    private final Caja caja;
    private final Mazo mazo;
    private final Mano mano;
    private final Pozo pozo;
    private boolean terminado = false;
    private boolean ganado = false;

    public Juego() {
        caja = new Caja();
        mazo = new Mazo();
        mano = new Mano();
        pozo = new Pozo();
        inicializarBaraja();
    }

    private void inicializarBaraja() {
        String[] palos = {"♥", "♦", "♠", "♣"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] nombres = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Jota", "Quina", "Ka"};
        for (String palo : palos) {
            for (int i = 0; i < valores.length; i++) {
                String valor = valores[i];
                String nombre = nombres[i];
                int numero = i + 1;
                Carta carta = new Carta(palo, valor, nombre, numero);
                caja.agregarCarta(carta);
            }
        }
    }

    public void barajarYPrepararMazo() {
        if (caja.estaVacia()) return;
        mazo.addAllFromCaja(new ArrayList<>(caja.getCartas()));
        caja.limpiar();
        mazo.shuffle();
        mano.limpiar();
        for (int i = 0; i < Mano.CAPACIDAD && !mazo.isEmpty(); i++) {
            Carta c = mazo.pop();
            if (c != null) mano.agregarCarta(c);
        }
    }

    public Caja getCaja() {
        return caja;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public Mano getMano() {
        return mano;
    }

    public Pozo getPozo() {
        return pozo;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public boolean isGanado() {
        return ganado;
    }

    public int forwardDistance(int a, int b) {
        return (b - a + 13) % 13;
    }

    public boolean esSandwich(Carta a, Carta b, Carta c) {
        int d1 = forwardDistance(a.getNumero(), b.getNumero());
        int d2 = forwardDistance(b.getNumero(), c.getNumero());
        return d1 == d2;
    }

    public int permisoPorColoresYPalos(Carta a, Carta b, Carta c) {
        String pa = a.getPalo();
        String pb = b.getPalo();
        String pc = c.getPalo();
        if (pa.equals(pb) && pb.equals(pc)) return 4;
        String ca = a.getColor();
        String cb = b.getColor();
        String cc = c.getColor();
        if (ca.equals(cb) && cb.equals(cc)) return 3;
        return 2;
    }

    public int evaluarTripleta(Carta x, Carta y, Carta z) {
        if (esSandwich(x, y, z)) {
            return permisoPorColoresYPalos(x, y, z);
        } else {
            return 0;
        }
    }

    public int maxTakeForSelected(List<Carta> selected) {
        if (selected.size() != 3) return 0;
        List<int[]> perms = List.of(new int[]{0,1,2}, new int[]{0,2,1}, new int[]{1,2,0}, new int[]{1,0,2}, new int[]{2,0,1}, new int[]{2,1,0});
        int max = 0;
        for (int[] p : perms) {
            Carta a = selected.get(p[0]);
            Carta b = selected.get(p[1]);
            Carta c = selected.get(p[2]);
            int val = evaluarTripleta(a,b,c);
            if (val > max) max = val;
        }
        return max;
    }

    public List<String> detallePermutaciones(List<Carta> selected) {
        List<String> out = new ArrayList<>();
        if (selected.size() != 3) return out;
        List<int[]> perms = List.of(new int[]{0,1,2}, new int[]{0,2,1}, new int[]{1,2,0}, new int[]{1,0,2}, new int[]{2,0,1}, new int[]{2,1,0});
        for (int[] p : perms) {
            Carta a = selected.get(p[0]);
            Carta b = selected.get(p[1]);
            Carta c = selected.get(p[2]);
            int val = evaluarTripleta(a,b,c);
            String linea = a.toString() + " " + b.toString() + " " + c.toString() + " -> " + val;
            out.add(linea);
        }
        return out;
    }

    public String aplicarDescartarYRefrescar(List<Carta> selected) {
        if (selected.size() != 3) return "Selección inválida";
        int take = maxTakeForSelected(selected);
        for (Carta c : selected) pozo.encolar(c);
        for (Carta c : selected) mano.removerCarta(c);
        int canTake = Math.min(take, Mano.CAPACIDAD - mano.size());
        for (int i = 0; i < canTake; i++) {
            if (!mazo.isEmpty()) {
                Carta traer = mazo.pop();
                if (traer != null) mano.agregarCarta(traer);
            }
        }
        if (mazo.isEmpty()) {
            terminado = true;
            ganado = true;
            return "¡GANASTE! Mazo vacío.";
        }
        return "Tripleta enviada al Pozo. Tomadas: " + canTake;
    }

    public boolean existeSandwichEnMano() {
        List<Carta> lista = mano.getCartas();
        int n = lista.size();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    Carta a = lista.get(i);
                    Carta b = lista.get(j);
                    Carta c = lista.get(k);
                    List<Carta> trip = List.of(a,b,c);
                    if (maxTakeForSelected(trip) > 0) return true;
                }
            }
        }
        return false;
    }

    public void guardarA(File file) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("Partida");
        doc.appendChild(root);

        Element cajaE = doc.createElement("Caja");
        for (Carta c : caja.getCartas()) {
            Element cartaE = doc.createElement("Carta");
            cartaE.setAttribute("valor", c.getValor());
            cartaE.setAttribute("palo", c.getPalo());
            cartaE.setAttribute("numero", Integer.toString(c.getNumero()));
            cajaE.appendChild(cartaE);
        }
        root.appendChild(cajaE);

        Element mazoE = doc.createElement("Mazo");
        for (Carta c : mazo.getCartas()) {
            Element cartaE = doc.createElement("Carta");
            cartaE.setAttribute("valor", c.getValor());
            cartaE.setAttribute("palo", c.getPalo());
            cartaE.setAttribute("numero", Integer.toString(c.getNumero()));
            mazoE.appendChild(cartaE);
        }
        root.appendChild(mazoE);

        Element manoE = doc.createElement("Mano");
        for (Carta c : mano.getCartas()) {
            Element cartaE = doc.createElement("Carta");
            cartaE.setAttribute("valor", c.getValor());
            cartaE.setAttribute("palo", c.getPalo());
            cartaE.setAttribute("numero", Integer.toString(c.getNumero()));
            manoE.appendChild(cartaE);
        }
        root.appendChild(manoE);

        Element pozoE = doc.createElement("Pozo");
        for (Carta c : pozo.getCardsSnapshot()) {
            Element cartaE = doc.createElement("Carta");
            cartaE.setAttribute("valor", c.getValor());
            cartaE.setAttribute("palo", c.getPalo());
            cartaE.setAttribute("numero", Integer.toString(c.getNumero()));
            pozoE.appendChild(cartaE);
        }
        root.appendChild(pozoE);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMSource ds = new DOMSource(doc);
        StreamResult sr = new StreamResult(file);
        t.transform(ds, sr);
    }

    public void cargarDe(File file) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        org.w3c.dom.Document doc = db.parse(file);
        doc.getDocumentElement().normalize();

        caja.limpiar();
        mazo.clear();
        mano.limpiar();
        pozo.limpiar();

        var listaCaja = doc.getElementsByTagName("Caja").item(0);
        if (listaCaja != null && listaCaja.getChildNodes() != null) {
            var nodes = listaCaja.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                var n = nodes.item(i);
                if (n.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    String valor = e.getAttribute("valor");
                    String palo = e.getAttribute("palo");
                    int numero = Integer.parseInt(e.getAttribute("numero"));
                    String nombre = valor;
                    caja.agregarCarta(new Carta(palo, valor, nombre, numero));
                }
            }
        }

        var listaMazo = doc.getElementsByTagName("Mazo").item(0);
        if (listaMazo != null && listaMazo.getChildNodes() != null) {
            var nodes = listaMazo.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                var n = nodes.item(i);
                if (n.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    String valor = e.getAttribute("valor");
                    String palo = e.getAttribute("palo");
                    int numero = Integer.parseInt(e.getAttribute("numero"));
                    String nombre = valor;
                    mazo.getCartas().add(new Carta(palo, valor, nombre, numero));
                }
            }
        }

        var listaMano = doc.getElementsByTagName("Mano").item(0);
        if (listaMano != null && listaMano.getChildNodes() != null) {
            var nodes = listaMano.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                var n = nodes.item(i);
                if (n.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    String valor = e.getAttribute("valor");
                    String palo = e.getAttribute("palo");
                    int numero = Integer.parseInt(e.getAttribute("numero"));
                    String nombre = valor;
                    mano.agregarCarta(new Carta(palo, valor, nombre, numero));
                }
            }
        }

        var listaPozo = doc.getElementsByTagName("Pozo").item(0);
        if (listaPozo != null && listaPozo.getChildNodes() != null) {
            var nodes = listaPozo.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                var n = nodes.item(i);
                if (n.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    String valor = e.getAttribute("valor");
                    String palo = e.getAttribute("palo");
                    int numero = Integer.parseInt(e.getAttribute("numero"));
                    String nombre = valor;
                    pozo.encolar(new Carta(palo, valor, nombre, numero));
                }
            }
        }
    }
}
