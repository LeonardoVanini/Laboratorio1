//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Videogioco a = new Videogioco("abe",new Sviluppatore("Gianni","Morandi"),10,false);
        a.aggiungiSviluppatore(new Sviluppatore("Gicacomo","Pieri"));
        System.out.println(a.ottieniSviluppatori());
        Negozio b = new Negozio("Ciao");
        b.aggiungiVideogioco(a);
        System.out.println(b.ottieniVideogiochi());
    }
}