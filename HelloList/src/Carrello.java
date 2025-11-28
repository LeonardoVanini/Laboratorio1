import java.util.ArrayList;

public class Carrello {
    private String nome;
    private ArrayList<Alimento> carrello;

    public Carrello(String nome) {
        this.nome = nome;
        carrello = new ArrayList<>();
    }
    void aggiungiAlimento(Alimento alimento){
        carrello.add(alimento);
    }
    void aggiungiAlimento(String nome,String categoria,String dataScadenza,int qt){
        carrello.add(new Alimento(nome,categoria,dataScadenza,qt));
    }
    void rimuoviAlimento(Alimento alimento){
        carrello.remove(alimento);
    }

    @Override
    public String toString() {
        return "Carrello: " +
                nome +
                carrello;
    }
}
