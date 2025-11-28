import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Carrello spesa = new Carrello("Spesa");

        spesa.aggiungiAlimento(new Alimento("Coca cola","Bibita","?",1));
        spesa.aggiungiAlimento("Ciao","hfiu","hvs",064);
        System.out.println(spesa);


    }
}