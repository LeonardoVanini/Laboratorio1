import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int contatore=0;
        int numero=rand.nextInt(0,100);
        while (true){
            try {

                System.out.println("Inserisci il tuo numero: ");
                int numero2 = input.nextInt();
                if (numero == numero2) {
                    System.out.println("Bravo! Hai indovinato in " + contatore + " tentativi.");
                    break;
                } else if (numero < numero2) {
                    contatore++;
                    System.out.println("Troppo alto!");
                    System.out.println("Il tuo tentativo: " + numero2);
                } else {
                    contatore++;
                    System.out.println("Troppo basso!");
                    System.out.println("Il tuo tentativo: " + numero2);
                }
            }
            catch (InputMismatchException iex) {
                System.out.println("Numero invalido!");
            }

        }

    }
}