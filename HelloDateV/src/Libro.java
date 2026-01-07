import java.util.Date;

public class Libro extends Base{
    private int giorni;

    public Libro(int giorni) {
        this.giorni = giorni;
    }

    @Override
    Date dataDiScadenza() {
        return null;
    }
}
