

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dimensioni matrice = new Dimensioni(5);



        matrice.stampaMatrice();
        for (int i = 0; i < 4; i++) {
            matrice.spostamento(1,0,0);
            matrice.stampaMatrice();
            Thread.sleep(1000);

        }
        matrice.spostamento(2,-2,-2);
        matrice.stampaMatrice();
    }
}