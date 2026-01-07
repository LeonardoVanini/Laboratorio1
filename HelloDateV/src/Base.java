import java.util.Date;
import java.util.Objects;

public abstract class Base {
    private int codice;
    private Date dataDiCreazione;

    abstract Date dataDiScadenza ();


    public void scaduto(Date data){
        if (data.after(dataDiScadenza())){
            System.out.println("È scaduto");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
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

    public Date getDataDiCreazione() {
        return dataDiCreazione;
    }
}
