import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestioneEventi gestione = new GestioneEventi();
        Scanner input = new Scanner(System.in);
        EventoBase fuochi = new EventoBase("Spettacolo fuochi",LocalDate.parse("2027-01-01"),2);
        EventoPremium circo = new EventoPremium("Circo",LocalDate.parse("2026-07-01"),6);
        gestione.aggiungiEvento(fuochi);
        gestione.aggiungiEvento(circo);

        //gestione.riordinaEventi();


        while (true){
            System.out.println("Eventi disponibili: ");
            gestione.stampaEventi();
            System.out.println("Inserisca nome evento: ");
            String opzione = input.nextLine();
            if (gestione.cercaEvento(opzione)){

                System.out.println("Bene, inserisca nome per prenotazione :");
                String nome = input.nextLine();
                if (gestione.prenotaSuEvento(nome, gestione.restituisciEvento(opzione))){
                    System.out.println("Prenotazione completata con successo");
                }
            }else {
                System.out.println("Evento non valido");
            }

            gestione.prenotazioni();

            System.out.println();
        }





    }
}