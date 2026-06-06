//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                String sigla = "PROD-";
                String prodotto = arg.substring(0, arg.indexOf("-")+1);
                int codiceProdotto = Integer.parseInt(arg.substring(arg.indexOf("-")+1));

                if (prodotto.equals(sigla)) {

                    if (codiceProdotto >= 1000){

                        System.out.println("Codice valido: "+arg);
                    }
                    else {
                        System.out.println("Codice non valido: "+arg);
                        System.out.println("Motivo: Il codice deve contenere almeno 4 cifre numeriche dopo 'PROD-'.");
                    }
                }
                else {
                    System.out.println("Codice non valido: "+arg);
                    System.out.println("Motivo: Il codice deve iniziare con 'PROD-'.");
                }

            }
            catch (NumberFormatException e) {
                System.out.println("Codice non valido: "+arg);
                System.out.println("Motivo: Il codice deve iniziare con 'PROD-'.");
            }

        }
    }

}