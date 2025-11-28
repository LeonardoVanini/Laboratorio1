//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Brano a = new Brano("Holiday","green");
        Brano b = new Brano("unknown","unknown");
        Playlist c=new Playlist("MyPlaylist");
        c.add(a);
        c.add(b);
        Player d=new Player("VlC","1.0",c);

        d.play();
        d.play();
        d.precedente();
        d.play();
        d.precedente();
        d.precedente();
        d.play();
        System.out.println("");
        System.out.println(d.getPlaylist());
    }
}