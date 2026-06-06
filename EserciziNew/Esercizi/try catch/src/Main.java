//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            float numero = Float.parseFloat(args[0]);
            verficaSegno(numero);
        }catch (NumberFormatException e) {
            System.out.println("Inserisci solo un numero");
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        /*

        for (float i = -5; i <= 5; i+=1) {
            verficaSegno(i);
        }
        */

    }
    public static void verficaSegno(float numeroTest) {
        if (numeroTest < 0) {
            System.out.println("Il numero "+numeroTest+" è negativo");
        } else if (numeroTest == 0) {
            System.out.println("Numero zero");
            throw new IllegalArgumentException("Il numero non può essere zero");
        } else {
            System.out.println("Il numero "+numeroTest+" è positivo");
        }

    }
}