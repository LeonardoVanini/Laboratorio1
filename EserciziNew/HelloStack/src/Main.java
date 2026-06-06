//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        
        try {
            metodoA(0);
        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void metodoA(int n) {
        metodoB(n);
    }
    public static void metodoB(int n) {
        metodoC(n);
    }
    public static void metodoC(int n) {
        metodoD(n);
    }
    public static void metodoD(int n) {
        metodoE(n);
    }
    public static void metodoE(int n) {
        metodoF(n);
    }
    public static void metodoF(int n) {
        metodoG(n);
    }
    public static void metodoG(int n) {
        metodoH(n);
    }
    public static void metodoH(int n) {
        int reult = 1/n;
        System.out.println(reult);
    }
}