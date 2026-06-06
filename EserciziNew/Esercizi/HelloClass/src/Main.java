public class Main {
    public static void main(String[] args) {
        Rettangolo r1 = new Rettangolo(4f,10f);
        Rettangolo r2 = new Rettangolo(4f,10.9f);
        Rettangolo r3 = new Rettangolo(4f,11.3f);
        r1.stampaInformazioni();
        r2.stampaInformazioni();
        r3.stampaInformazioni();

        r1.stampaRettangolo();
        r2.stampaRettangolo();
        r3.stampaRettangolo();

    }
}