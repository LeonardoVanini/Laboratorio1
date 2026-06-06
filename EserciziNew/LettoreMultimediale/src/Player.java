public class Player {
    private String modello;
    private String marca;
    private Playlist playlist;
    private int index;

    public Player(String modello, String marca, Playlist playlist) {
        this.modello = modello;
        this.marca = marca;
        this.playlist = playlist;
        this.index=0;
    }
    void play(){
        System.out.println("Riproducendo: "+getPlaylist().info(index)+", Posizione "+(index+1));
        index++;
    }
    void successivo(){
        index++;
    }
    void precedente(){
        index--;
    }
    void selezionabrano(int index){
        this.index=index-1;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

}
