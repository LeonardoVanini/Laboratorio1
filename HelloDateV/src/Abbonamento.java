import java.time.LocalDate;

public class Abbonamento extends Base{
    private int mesi;

    public Abbonamento(int codice, LocalDate dataDiCreazione, int mesi) {
        super(codice, dataDiCreazione);
        this.mesi = mesi;
    }

    @Override
    LocalDate dataDiScadenza() {
        LocalDate data = getDataDiCreazione();
        data = data.plusMonths(mesi);
        return data;
    }

    @Override
    public String toString() {
        return "L'abbonamento di "+getCodice()+" scade il "+dataDiScadenza();
    }
}
