import java.util.ArrayList;

public class House {
    private ArrayList<Room> stanze;

    public House() {
        stanze = new ArrayList<>();
    }

    void aggiungiStanza(String nome, double superficieMq){
        stanze.add(new Room(nome,superficieMq));
    }
    void visualizzaStanze(){
        if (stanze.size()>0){
            for ( Room stanza : stanze){
                System.out.println(stanza);
            }
        }else {
            System.out.println("La casa è vuota.");
        }
    }
    double getSuperficieTotale(){
        double somma=0;
        for (Room stanza : stanze){
            somma+=stanza.getSuperficieMq();
        }
        return somma;
    }
}
