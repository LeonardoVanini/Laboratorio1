import java.util.ArrayList;

public class Videogioco {
    private String titolo;
    private ArrayList<Sviluppatore> sviluppatori;
    private float prezzo;
    private boolean stato;

    public Videogioco(String titolo, Sviluppatore sviluppatore, float prezzo, boolean stato) {
        this.titolo = titolo;
        this.sviluppatori = new ArrayList<>();
        aggiungiSviluppatore(sviluppatore);
        this.prezzo = prezzo;
        this.stato = stato;
    }
    void aggiungiSviluppatore(Sviluppatore sviluppatore){
        sviluppatori.add(sviluppatore);
    }
    void rimuoviSviluppatore(Sviluppatore sviluppatore){
        sviluppatori.remove(sviluppatore);
    }

    String ottieniSviluppatori(){
        String output="";
        for (Sviluppatore sviluppatore : sviluppatori){
            output=output.concat(sviluppatore+", ");

        }
        return output;
    }

    @Override
    public String toString() {
        return  titolo +", "+
                ottieniSviluppatori() +" "+
                prezzo +", "+
                stato
                ;
    }
}
