// OBIETTIVO: Calcolare la somma di tutti i numeri positivi in un array.
// Il programma contiene alcuni errori da scoprire con il debugger.
public class Main {
    public static void main(String[] args) {

        int[] numeri = {15, -4, 20, 0, -8, 10, 5, 7};
        int s = 0;


        System.out.println("Inizio del calcolo della somma dei numeri positivi.");
        System.out.println("Array di partenza: " + java.util.Arrays.toString(numeri));


        for (int i = 0; i < numeri.length; i++) {
            try {
                int numeroCorrente = numeri[i];
                System.out.println("Analizzo il numero: " + numeroCorrente);

                if (numeroCorrente > 0) {
                    s += numeroCorrente;
                    System.out.println("Numero positivo trovato. Nuova somma parziale: " + s);
                }

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("ERRORE: Si è verificato un problema con l'indice dell'array!");
                System.out.println("L'indice " + i + " non è valido.");
            }
        }
        System.out.println("\n-------------------------------------------");
        System.out.println("La somma finale calcolata è: " + s);
        System.out.println("-------------------------------------------\n");
        System.out.println("\nEsecuzione del programma terminata.");


    }
}