import java.time.LocalDate;
import java.util.ArrayList;

public class EventoBase extends Evento implements Prenotabile {
    private int costoBase;
    ArrayList<String> partecipanti;

    public EventoBase(String titolo, LocalDate data, int maxPartecipanti) {
        super(titolo, data, maxPartecipanti);
        this.costoBase = 20;
        this.partecipanti = new ArrayList<>();
    }

    @Override
    public boolean prenota(String nomePartecipante) throws PrenotazioneExeption {
        if (nomePartecipante == null || nomePartecipante.isEmpty()) {
            throw new  PrenotazioneExeption("Nome non valido");
        }

        if (LocalDate.now().isAfter(getData())){
            throw new  PrenotazioneExeption("Evento scaduto");
        }

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
