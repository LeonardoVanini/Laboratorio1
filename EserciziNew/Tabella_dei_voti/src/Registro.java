import java.util.Scanner;

public class Registro {
    private String[] studenti;
    private double[][] voti;
    private double[] mediaVoti;
    private int numeroStudenti;
    private int numeroVoti;
    private Scanner input = new Scanner(System.in);

    Registro(int numeroStudenti, int numeroVoti) {
        this.numeroStudenti = numeroStudenti;
        this.numeroVoti = numeroVoti;
        inizializzazione();
    }
    Registro(){
        this.numeroStudenti = 0;
        this.numeroVoti = 0;
        inizializzazione();
    }

    void inizializzazione() {
        studenti = new String[numeroStudenti];
        mediaVoti = new double[numeroStudenti];
        voti = new double[numeroStudenti][numeroVoti];

    }
    void inserisciVoti(){
        for (int i = 0; i < numeroStudenti; i++) {
            System.out.print("Nome dello studente "+(i+1)+": ");
            studenti[i]=input.nextLine();
            for (int j = 0; j < numeroVoti; j++) {
                System.out.print("Inserisci voto "+(j+1)+": ");
                voti[i][j]=input.nextDouble();

            }
            System.out.println();
        }
    }
    void stampaVoti(){
        System.out.println("=== Tabella Voti ===");
        for (int i = 0; i < numeroStudenti; i++) {
            System.out.print(studenti[i]+": ");
            for (int j = 0; j < numeroVoti; j++) {
                System.out.print(voti[i][j]+" ");
            }
            System.out.println();
        }
    }
    void mediaStudente(int i){
        double somma = 0;
        for (int j = 0; j < numeroVoti; j++) {
            somma += voti[i][j];
        }
        mediaVoti[i] = somma/numeroVoti;
    }
}
