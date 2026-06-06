public class Rettangolo {
    private float latoMinore;
    private float latoMaggiore;

    //metodo costruttore, permette di costruire un oggetto con valori passati per argomento
    public Rettangolo(float latoMinore, float latoMaggiore) {
        this.latoMinore = latoMinore;
        this.latoMaggiore = latoMaggiore;
    }
    //costruttore vuoto
    public Rettangolo() {
        this.latoMinore = 5;
        this.latoMaggiore = 10;
    }

    public float calcolaArea(){
        return latoMinore * latoMaggiore;
    }
    public float calcolaPerimetro(){
        return latoMaggiore * 2+ latoMinore * 2;
    }
    public void stampaInformazioni(){
        System.out.println("Area = " + calcolaArea() + " Perimetro = " + calcolaPerimetro());
    }
    public void stampaDimensioni(){
        System.out.println(latoMaggiore + "X" + latoMinore);
    }
    public void stampaRettangolo(){
        for (int j = 0; j < latoMinore; j++) {
            for (int i = 0; i < latoMaggiore; i++) {
                System.out.print("* ");
            }
            System.out.println();

        }
        System.out.println();
    }

}
