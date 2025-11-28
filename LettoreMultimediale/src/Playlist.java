import java.util.ArrayList;

public class Playlist {
    private String titolo;
    private ArrayList<Brano> brani;

    public Playlist(String titolo) {
        this.titolo = titolo;
        this.brani = new ArrayList<>();
    }
    void add(Brano brano){
        brani.add(brano);
    }
    void remove(Brano brano){
        brani.remove(brano);
    }
    String info(int index){
        return ""+brani.get(index);
    }

    @Override
    public String toString() {
        String player = "Titolo\tAutore\tPosizione"+"\n\r";
        for (int i =0; i< brani.size();i++){
            player=player+brani.get(i).toString()+"\t"+(i+1)+"\n\r";
        }
        return player;
    }
}
