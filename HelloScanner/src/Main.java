import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int eta;
        boolean isFelice;
        String nome;
        String cognome;

        Scanner input = new Scanner(System.in); //creato oggetto scanner
        System.out.print("Inserisci il tuo nome: ");
        nome = input.nextLine(); //salvato input in una variabile
        System.out.print("inserisci il tuo cognome: ");
        cognome = input.nextLine();
        System.out.print("Inserisci la tua età: ");
        eta = input.nextInt();
        System.out.print("Sei felice? ");
        isFelice = input.nextBoolean();

        System.out.println(nome + " " + cognome + " " + eta + " " + isFelice);

    }
}