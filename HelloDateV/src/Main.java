import java.time.LocalDate;
import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println(data + " " + time);
        System.out.println(data.getDayOfMonth());
        System.out.println(data.getMonthValue());

        Libro l = new Libro(10,LocalDate.of(2026,1,1),10);
        Libro li = new Libro(203,LocalDate.of(2026,1,1),10);
        System.out.println(l);
        ArrayList<Base>resoconto = new ArrayList<>();
        resoconto.add(l);
        resoconto.add(li);
        Abbonamento a = new Abbonamento(203,LocalDate.of(2023,5,20),12);
        resoconto.add(a);
        for (Base uso : resoconto){
            System.out.println(uso);
        }
        for (Base uso : resoconto){
            if (uso.scaduto(LocalDate.of(2026,1,1))) {
                System.out.println(uso.getCodice()+" è scaduto");
            }
        }
        for (int i = 0; i < resoconto.size(); i++) {
            for (int j = 0; j < resoconto.size(); j++) {
                if (resoconto.get(i).equals(resoconto.get(j)) && i!=j){
                    System.out.println(resoconto.get(i).getCodice()+" c'è più di una volta");
                }
            }
        }

    }
}