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
    }
}