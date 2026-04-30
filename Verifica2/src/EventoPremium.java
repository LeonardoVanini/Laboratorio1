import java.time.LocalDate;
import java.util.ArrayList;

public class EventoPremium extends Evento implements Prenotabile{
    private int costoBase;
    ArrayList<String> partecipanti;

    public EventoPremium(String titolo, LocalDate data, int maxPartecipanti) {
        super(titolo, data, maxPartecipanti-5);
        this.costoBase = 50;
        this.partecipanti = new ArrayList<>();
    }

    @Override
    public boolean prenota(String nomePartecipante) throws PrenotazioneExeption {
        if (partecipanti.size()+1<= getMaxPartecipanti()) {
            partecipanti.add(nomePartecipante);
            return true;
        }else {
            throw new  PrenotazioneExeption("Numero massimo di partecipanti raggiunto");
        }
    }

    @Override
    double calcolaCosto() {
        return costoBase * partecipanti.size();
    }
    @Override
    ArrayList<String> getPartecipanti() {
        return partecipanti;
    }
}
