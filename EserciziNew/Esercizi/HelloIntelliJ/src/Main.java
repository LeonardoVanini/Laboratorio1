public class Main {
    public static void main(String[] args) {
        System.out.println("Hello IDE" + " " + args[0]);
        long somma = 1;
        for (int i = 1; i < 100; i++) {
            System.out.println(i);
            somma *= i;
        }
        System.out.println(somma);

    }
}