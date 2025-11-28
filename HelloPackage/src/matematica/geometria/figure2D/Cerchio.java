package matematica.geometria.figure2D;

import matematica.geometria.PIGreco;

public class Cerchio {
    private int raggio;

    public Cerchio(int raggio) {
        this.raggio = raggio;
    }
    public double calcolaArea(){
        PIGreco pi = new PIGreco();
        return (raggio*raggio)*pi.get();
    }
}
