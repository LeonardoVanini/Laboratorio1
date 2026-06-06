import java.util.ArrayList;

public class Negozio {
    private String nome;
    private ArrayList<Videogioco> videogiochi;

    public Negozio(String nome) {
        this.nome = nome;
        videogiochi = new ArrayList<>();
    }
    void aggiungiVideogioco(Videogioco videogioco){
        videogiochi.add(videogioco);
    }
    void rimuoviVideogioco(Videogioco videogioco){
        videogiochi.remove(videogioco);
    }

    String ottieniVideogiochi(){
        String output="";
        for (Videogioco videogioco : videogiochi){
            output=output.concat(videogioco+", \r\n");

        }
        return output;
    }
}
