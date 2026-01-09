import java.util.Date;
import java.time.LocalDate;

public class Libro extends Base{
    private int giorni;

    public Libro(int codice, LocalDate dataDiCreazione, int giorni) {
        super(codice, dataDiCreazione);
        this.giorni = giorni;
    }


    @Override
    LocalDate dataDiScadenza() {
        LocalDate data = getDataDiCreazione();
        data = data.plusDays(giorni);
        return data;
    }

    @Override
    public String toString() {
        return "Il prestito di "+getCodice()+" scade il "+dataDiScadenza();
    }
}
