package ch.samt.biblioteca.app;

import ch.samt.biblioteca.data.Biblioteca;
import ch.samt.biblioteca.model.Dvd;
import ch.samt.biblioteca.model.ItemBiblioteca;
import ch.samt.biblioteca.model.Libro;

public class Main {
    public static void main(String[] args) {
        Biblioteca cpt = new Biblioteca();

        Libro test = new Libro("01f","a",10,"s","prof",2);
        Libro test2 = new Libro("01f","a",10,"s","prof",2);
        Libro test3 = new Libro("02f","a",10,"s","prof",2);
        Dvd test4 = new Dvd("03f","de",12,"wd","AD",10);

        System.out.println(cpt.aggiungiItem(test));
        System.out.println(cpt.aggiungiItem(test2));
        System.out.println(cpt.aggiungiItem(test3));
        System.out.println(cpt.aggiungiItem(test4));

        System.out.println();

        for (ItemBiblioteca item : cpt.getCatalogo()){
            System.out.println(item);
        }
        System.out.println();
        for (ItemBiblioteca item : cpt.getElementiDiAutore("prof")){
            System.out.println(item);
        }
        System.out.println();
        cpt.aggiungiPrenotazioneFIFO(test);
        cpt.aggiungiPrenotazioneFIFO(test3);
        cpt.aggiungiPrenotazioneFIFO(test4);
        System.out.println(cpt.prossimaPrenotazioneFIFO());
        cpt.aggiungiConsegnaUrgenteLIFO(test);
        cpt.aggiungiConsegnaUrgenteLIFO(test3);
        cpt.aggiungiConsegnaUrgenteLIFO(test4);
        System.out.println(cpt.prossimaConsegnaLIFO());
    }
}
