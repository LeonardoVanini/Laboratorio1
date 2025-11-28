//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {

            House casa = new House();

            casa.aggiungiStanza("Soggiorno", 20);
            casa.aggiungiStanza("Atrio", 2);
            casa.visualizzaStanze();
            casa.aggiungiStanza("Ciao", Double.parseDouble(args[0]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Errore : argomenti errati");
        }catch (NumberFormatException g){
            System.out.println("Forato non double");
        }
    }
}