import java.time.LocalDate;
import java.util.Objects;

public abstract class Base {
    private int codice;
    private LocalDate dataDiCreazione;

    public Base(int codice, LocalDate dataDiCreazione) {
        this.codice = codice;
        this.dataDiCreazione = dataDiCreazione;
    }

    abstract LocalDate dataDiScadenza ();


    public boolean scaduto(LocalDate data){

        if (data.isAfter(dataDiScadenza())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Base)) return false;
        Base base = (Base) o;
        return codice == base.codice;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codice);
    }

    @Override
    public String toString() {
        return codice+";"+ dataDiCreazione+";"+dataDiScadenza();
    }

    public int getCodice() {
        return codice;
    }

    public LocalDate getDataDiCreazione() {
        return dataDiCreazione;
    }
}
