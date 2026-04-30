import java.time.LocalDate;

public abstract class Prenotazione implements Documentabile{
    private String codiceVolo;
    private LocalDate dataPartenza;
    private double prezzoBase;

    public Prenotazione(String codiceVolo, LocalDate dataPartenza, double prezzoBase) {
        if (verificaCodiceVolo(codiceVolo)) {
            this.codiceVolo = codiceVolo;
        }
        else {
            throw new IllegalArgumentException("Codice volo non valido");
        }
        if (verificaDataPartenza(dataPartenza)) {
            this.dataPartenza = dataPartenza;
        }
        else {
            throw new IllegalArgumentException("Data di partenza non valida");
        }
        if (verificaPrezzoBase(prezzoBase)) {
            this.prezzoBase = prezzoBase;
        }
        else {
            throw new IllegalArgumentException("Prezzo base non valido");
        }
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public void setCodiceVolo(String codiceVolo) {
        if (verificaCodiceVolo(codiceVolo)) {
            this.codiceVolo = codiceVolo;
        }
        else {
            throw new IllegalArgumentException("Codice volo non valido");
        }
    }

    public LocalDate getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(LocalDate dataPartenza) {
        if (verificaDataPartenza(dataPartenza)) {
            this.dataPartenza = dataPartenza;
        }
        else {
            throw new IllegalArgumentException("Data di partenza non valida");
        }
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(double prezzoBase) {
        if (verificaPrezzoBase(prezzoBase)) {
            this.prezzoBase = prezzoBase;
        }
        else {
            throw new IllegalArgumentException("Prezzo base non valido");
        }
    }

    private boolean verificaCodiceVolo(String Volo) {
        return Volo.matches("^[A-Za-z]{2}[0-9]{3}$");
    }
    private boolean verificaDataPartenza(LocalDate Partenza) {
        LocalDate dataOdierna = LocalDate.now();
        if (Partenza.compareTo(dataOdierna) < 0) {
            return false;
        }
        return true;
    }

    private boolean verificaPrezzoBase(double Prezzo) {
        if (Prezzo <= 0) {
            return false;
        }
        return true;
    }

    abstract void calcolaCostoTotale();
}
