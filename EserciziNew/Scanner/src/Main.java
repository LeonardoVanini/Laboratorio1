import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Quanti numeri vuoi inserire? ");
            int num = input.nextInt();
            if (num <= 0){
                System.out.println("Array nullo");
            }
            int[] numeri = new int[num];

            for (int i = 0; i < numeri.length; i++) {
                System.out.print("Inserisci il numero " + (i + 1) + ": ");
                numeri[i] = input.nextInt();
            }
            System.out.println("=== Numero massimo ===");
            for (int i = 0; i < numeri.length; i++) {
                for (int j = i + 1; j < numeri.length; j++) {
                    if (numeri[i] > numeri[j]) {
                        int temp = numeri[i];
                        numeri[i] = numeri[j];
                        numeri[j] = temp;
                    }
                }

            }
            System.out.println(numeri[numeri.length - 1]);
            System.out.print("Come vuoi ordinare (1 = da - a +, 2 = da + a -)? ");
            int ord = input.nextInt();
            if (ord == 1) {
                for (int i = 0; i < numeri.length; i++) {
                    System.out.println("Numero " + (i + 1) + ": " + numeri[i]);
                }
            } else if (ord == 2) {
                for (int i = numeri.length - 1; i >= 0; i--) {
                    System.out.println("Numero " + (i + 1) + ": " + numeri[i]);
                }
            }
        }
        catch (InputMismatchException ime) {
            System.out.println(ime.getMessage());
        }
        catch (NegativeArraySizeException nase) {
            System.out.println(nase.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println(aioobe.getMessage());
        }
    }
}