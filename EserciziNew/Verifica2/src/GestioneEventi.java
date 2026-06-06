import java.util.ArrayList;

public class GestioneEventi {
    private ArrayList<Evento> evento;

    public GestioneEventi() {
        evento = new ArrayList<>();
    }

    public void aggiungiEvento(Evento evento) {
        this.evento.add(evento);
    }
    public void stampaEventi(){
        for (Evento evento : evento) {
            System.out.println(evento);
        }
    }

    public ArrayList<Evento> getEvento() {
        return evento;
    }

    public boolean prenotaSuEvento(String nomePartecipante, int indice) {
        Evento evento = this.evento.get(indice);


        if (evento instanceof EventoPremium) {
            EventoPremium eventoPremium = (EventoPremium) evento;
            try {
                eventoPremium.prenota(nomePartecipante);
                return true;
            }catch (PrenotazioneExeption pe) {
                System.out.println(pe);
                return false;
            }
        }else if (evento instanceof EventoBase) {
            EventoBase eventoBase = (EventoBase) evento;
            try {
                eventoBase.prenota(nomePartecipante);
                return true;
            }catch (PrenotazioneExeption pe) {
                System.out.println(pe);
                return false;
            }

        }
        return false;
    }
    public int restituisciEvento(String titolo) {

        for (int i = 0; i<evento.size(); i++) {
            if (evento.get(i).getTitolo().equals(titolo)) {
                return i;
            }
        }
        return 0;
    }
    public boolean cercaEvento(String titolo){
        for (Evento evento : evento) {
            if (evento.getTitolo().equals(titolo)) {
                return true;
            }



        }
        return false;
    }

    public void prenotazioni(){
        System.out.println();
        for (Evento evento : evento) {
            System.out.println(evento.getTitolo());
            for (String partecipante : evento.getPartecipanti()) {
                System.out.println(partecipante);
            }
            System.out.println();
        }
    }

    /*
    public void riordinaEventi(){
        ArrayList<Evento> newEvento = new ArrayList<>();
        for (Evento evento : evento) {
            if (newEvento.isEmpty()) {
                newEvento.add(evento);
            }else {
                for (int i = 0; i < newEvento.size(); i++) {
                    if (evento.getData().isAfter(newEvento.get(i).getData())) {
                        if (evento.getData().isBefore(newEvento.get(i+1).getData())||i+1 == newEvento.size()) {
                            newEvento.add(evento);
                            break;
                        }
                    }
                }
            }
        }
        this.evento = newEvento;
    }*/
}
