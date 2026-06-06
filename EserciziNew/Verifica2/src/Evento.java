import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Evento {
    private String titolo;
    private LocalDate data;
    private int maxPartecipanti;

    public Evento(String titolo, LocalDate data, int maxPartecipanti) {
        this.titolo = titolo;
        this.data = data;
        this.maxPartecipanti = maxPartecipanti;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getMaxPartecipanti() {
        return maxPartecipanti;
    }

    abstract ArrayList<String> getPartecipanti();

    abstract double calcolaCosto();

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(titolo);
        str.append(" il ");
        str.append(data);
        str.append(" con un massimo di ");
        str.append(maxPartecipanti);
        return str.toString();
    }
}
