import javax.swing.*; // Libreria Swing per GUI e pannello
import java.awt.*;    // Libreria AWT per disegno (Graphics)
import java.util.Random; // Libreria per numeri casuali

// Classe principale che estende JPanel, permette di disegnare il terreno
public class TerrainGenerator extends JPanel {

    // Numero totale di punti del terreno da disegnare
    static final int NUM_PUNTI = 10000;

    // Lunghezza di ciascun blocco in punti: ogni blocco avrà un'altezza casuale
    static final int BLOCCO = 100;

    // Altezza minima e massima del terreno
    static final int MIN_Y = 100;
    static final int MAX_Y = 300;

    // Numero totale di blocchi necessari per NUM_PUNTI
    static final int NUM_BLOCCHI = NUM_PUNTI / BLOCCO + 2;
    // +2 per sicurezza: coprire l’ultimo blocco e interpolazioni

    // Array che contiene l’altezza di ciascun blocco
    static double[] blocchi = new double[NUM_BLOCCHI];

    // Generatore di numeri casuali globale
    static Random r = new Random();

    // Metodo main: punto di ingresso del programma
    public static void main(String[] args) {
        // Genera altezze casuali per ogni blocco all’avvio
        for (int i = 0; i < NUM_BLOCCHI; i++) {
            // blocchi[i] sarà un numero tra MIN_Y e MAX_Y
            blocchi[i] = MIN_Y + r.nextDouble() * (MAX_Y - MIN_Y);
        }

        // Creazione della finestra principale
        JFrame frame = new JFrame("Terreno Hill Climb");

        // Imposta l'operazione di chiusura della finestra
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dimensioni della finestra
        frame.setSize(1200, 400);

        // Aggiunge il pannello TerrainGenerator alla finestra
        frame.add(new TerrainGenerator());

        // Rende la finestra visibile
        frame.setVisible(true);
    }

    // Metodo che disegna il pannello
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Chiama il metodo della superclasse per pulire il pannello

        // Punto iniziale del terreno (x=0)
        int prevX = 0;
        int prevY = (int) genera(0); // Y iniziale calcolata con la funzione genera

        // Ciclo per disegnare tutti i punti del terreno
        for (int i = 1; i <= NUM_PUNTI; i++) {
            int drawX = i;          // Coordinata x corrente
            int drawY = (int) genera(i); // Coordinata y calcolata dal generatore

            // Disegna una linea dal punto precedente al punto corrente
            g.drawLine(prevX, prevY, drawX, drawY);

            // Aggiorna il punto precedente per la prossima linea
            prevX = drawX;
            prevY = drawY;
        }
    }

    // Funzione che genera l’altezza del terreno in un dato punto x
    static double genera(double x) {
        // Identifica il blocco corrente
        int id = (int) (x / BLOCCO);

        // Identifica il blocco successivo (necessario per interpolazione)
        int nextId = id + 1;

        // Altezza del blocco corrente
        double y0 = blocchi[id];

        // Altezza del blocco successivo
        double y1 = blocchi[nextId];

        // t è la posizione relativa all’interno del blocco: 0 all’inizio, 1 alla fine
        double t = (x % BLOCCO) / BLOCCO;

        // Interpolazione sinusoidale per rendere il terreno liscio tra blocchi
        // Formula: y = y0 + (y1 - y0) * (0.5 - 0.5 * cos(π * t))
        // - quando t=0 → cos(0)=1 → y=y0
        // - quando t=1 → cos(π)=-1 → y=y1
        double y = y0 + (y1 - y0) * (0.5 - 0.5 * Math.cos(Math.PI * t));

        // Non strettamente necessario, ma in generale possiamo correggere valori vicini a zero
        double epsilon = 1e-10;
        if (Math.abs(y) < epsilon) y = 0;

        return y; // Ritorna l’altezza del terreno in quel punto
    }
}
