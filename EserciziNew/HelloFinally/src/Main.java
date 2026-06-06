
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //cicliamo array per verificare se solo numeri
        for (String arg : args) {
            try {
                double numero = Double.parseDouble(arg);
                System.out.println(numero + " È un numero");
                System.out.println(4/numero);
            }
            catch (NumberFormatException nfe) {
                System.out.println(arg + " Non è un numero");
                System.out.println(nfe.getMessage());
            }
            finally {
                System.out.println("Finito");
            }

        }
    }
}