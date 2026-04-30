import java.time.LocalDate;

public class VoloInternazionale extends Prenotazione{
    private String destinazione;
    private String nomePasseggero;
    private boolean bagaglioStiva;

    public VoloInternazionale(String codiceVolo, LocalDate dataPartenza, double prezzoBase, String destinazione, String nomePasseggero, boolean bagaglioStiva) {
        super(codiceVolo, dataPartenza, prezzoBase);
        this.destinazione = destinazione;
        this.nomePasseggero = nomePasseggero;
        this.bagaglioStiva = bagaglioStiva;
    }

    @Override
    void calcolaCostoTotale() {
        if(bagaglioStiva){
            setPrezzoBase(getPrezzoBase()+25);
        }
        else {
            setPrezzoBase(getPrezzoBase() + 25 + 40);
        }
    }

    @Override
    public String generaTicket() {
        StringBuilder ticket = new StringBuilder();
        int larghezza = 50;
        for (int i = 0; i < larghezza; i++) {
            ticket.append("*");
        }
        ticket.append("\n* BOARDING PASS                                  *");
        ticket.append("\n");
        for (int i = 0; i < larghezza; i++) {
            ticket.append("*");
        }


        ticket.append("\n Passeggero:\t");
        ticket.append(nomePasseggero.toUpperCase());
        ticket.append("\n VOLO:\t\t");
        ticket.append(getCodiceVolo().toUpperCase());
        ticket.append("\n Destinazione:\t");
        ticket.append(destinazione.toUpperCase());
        ticket.append("\n DATA:\t\t");
        ticket.append(getDataPartenza());

        return ticket.toString();
    }
}
