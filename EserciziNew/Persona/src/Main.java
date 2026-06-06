//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona a = new Persona("Luca","Maggi",15,"1234");
        Persona b = new Persona("Luca","Maggi",15,"1234");

        System.out.println(a.equals(b));
    }
}