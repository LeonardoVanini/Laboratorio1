import java.nio.channels.ScatteringByteChannel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int length = 0;
        int direction = 0;
        if (args.length < 2) {
            System.out.println("Inserire almeno 2 argomenti");
            return;
        }
        if (args.length > 2) {
            System.out.println("Inserire al massimo 2 argomenti");
            return;
        }
        if (Integer.parseInt(args[0]) == 0) {
            System.out.println("Inserire almeno 1, come attributo lunghezza");
            return;
        }
        try {
            length = Integer.parseInt(args[0]);
            direction = Integer.parseInt(args[1]);
        }
        catch (Exception e) {
            System.out.println("Inserire integer come argomenti");
        }
        if (direction == 0) {
            for (int i = 0; i < length; i++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < length; i++) {
                System.out.println("*");
            }
        }
    }

}