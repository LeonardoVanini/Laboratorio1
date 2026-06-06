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

        String[][] brani = {
                {"Holiday", "Green Day"},
                {"Bohemian Rhapsody", "Queen"},
                {"Imagine", "John Lennon"},
                {"Smells Like Teen Spirit", "Nirvana"},
                {"Billie Jean", "Michael Jackson"},
                {"Hey Jude", "The Beatles"},
                {"Like a Rolling Stone", "Bob Dylan"},
                {"Hotel California", "Eagles"},
                {"Sweet Child O' Mine", "Guns N' Roses"},
                {"Wonderwall", "Oasis"},
                {"Shape of You", "Ed Sheeran"},
                {"Rolling in the Deep", "Adele"},
                {"Lose Yourself", "Eminem"},
                {"Stairway to Heaven", "Led Zeppelin"},
                {"Purple Rain", "Prince"},
                {"Born to Run", "Bruce Springsteen"},
                {"Let It Be", "The Beatles"},
                {"Yesterday", "The Beatles"},
                {"One", "U2"},
                {"With or Without You", "U2"},
                {"Nothing Else Matters", "Metallica"},
                {"Enter Sandman", "Metallica"},
                {"Back in Black", "AC/DC"},
                {"Highway to Hell", "AC/DC"},
                {"Thunderstruck", "AC/DC"},
                {"Paint It Black", "The Rolling Stones"},
                {"Satisfaction", "The Rolling Stones"},
                {"Angie", "The Rolling Stones"},
                {"Heroes", "David Bowie"},
                {"Space Oddity", "David Bowie"},
                {"Hallelujah", "Leonard Cohen"},
                {"Creep", "Radiohead"},
                {"Paranoid Android", "Radiohead"},
                {"Fix You", "Coldplay"},
                {"Clocks", "Coldplay"},
                {"Viva La Vida", "Coldplay"},
                {"Somebody to Love", "Queen"},
                {"Radio Ga Ga", "Queen"},
                {"We Will Rock You", "Queen"},
                {"We Are the Champions", "Queen"},
                {"Born in the U.S.A.", "Bruce Springsteen"},
                {"Beat It", "Michael Jackson"},
                {"Thriller", "Michael Jackson"},
                {"Man in the Mirror", "Michael Jackson"},
                {"Poker Face", "Lady Gaga"},
                {"Bad Romance", "Lady Gaga"},
                {"Shallow", "Lady Gaga"},
                {"Uptown Funk", "Mark Ronson ft. Bruno Mars"},
                {"24K Magic", "Bruno Mars"},
                {"Grenade", "Bruno Mars"}
        };

        // Aggiungo i brani alla playlist
        for (int i =0; i< brani.length;i++) {
            String info[]=brani[i];
            Brano e = new Brano(info[0], info[1]);
            c.add(e);
        }





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