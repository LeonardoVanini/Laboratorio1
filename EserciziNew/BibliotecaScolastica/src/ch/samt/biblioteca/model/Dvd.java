package ch.samt.biblioteca.model;

public class Dvd extends ItemBiblioteca{
    private String regista;
    private int durataMinuti;

    public Dvd(String codice, String titolo, int annoPubblicazione, String scaffale, String regista, int durataMinuti) {
        super(codice, titolo, annoPubblicazione, scaffale);
        this.regista = regista;
        this.durataMinuti = durataMinuti;
    }

    public String getRegista() {
        return regista;
    }

    public int getDurataMinuti() {
        return durataMinuti;
    }

    @Override
    public String toString() {
        return "codice " + getCodice() +
                ", titolo " + getTitolo() +
                ", annoPubblicazione " + getAnnoPubblicazione() +
                ", scaffale " + scaffale+
                ", regista " + regista +
                ", durataMinuti " + durataMinuti
                ;
    }
}
