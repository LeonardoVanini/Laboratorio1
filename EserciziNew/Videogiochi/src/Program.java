public class Program {
    public static void main(String[] args) {
        Sviluppatore s1 = new Sviluppatore("Shigeru", "Miyamoto");
        Sviluppatore s2 = new Sviluppatore("Hideo", "Kojima");
        Sviluppatore s3 = new Sviluppatore("Sid", "Meier");
        Sviluppatore s4 = new Sviluppatore("Gabe", "Newell");
        Sviluppatore s5 = new Sviluppatore("Todd", "Howard");
        Sviluppatore s6 = new Sviluppatore("Neil", "Druckmann");
        Sviluppatore s7 = new Sviluppatore("Cory", "Barlog");

        Videogioco v1 = new Videogioco("Half-Life 2", s4, 19.99f, true);
        Videogioco v2 = new Videogioco("Death Stranding", s2, 59.99f, true);
        v2.aggiungiSviluppatore(s6); // Kojima + Druckmann
        Videogioco v3 = new Videogioco("The Elder Scrolls VI", s5, 69.99f, true);
        v3.aggiungiSviluppatore(s1); // Howard + Miyamoto + Meier
        v3.aggiungiSviluppatore(s3);
        Videogioco v4 = new Videogioco("God of War", s7, 49.99f, true);
        v4.aggiungiSviluppatore(s6); // Barlog + Druckmann
        Videogioco v5 = new Videogioco("Civilization VI", s3, 39.99f, false);

        Negozio gameStore = new Negozio("GamePlanet");

        gameStore.aggiungiVideogioco(v1);
        gameStore.aggiungiVideogioco(v2);
        gameStore.aggiungiVideogioco(v3);
        gameStore.aggiungiVideogioco(v4);
        gameStore.aggiungiVideogioco(v5);

        gameStore.rimuoviVideogioco(v3);

        System.out.println(gameStore.ottieniVideogiochi());
    }
}