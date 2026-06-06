package matematica.geometria.figure2D;

public class Composta {
    private Rettangolo r;
    private Cerchio c;

    public Composta() {
        this.r = new Rettangolo(5);
        this.c = new Cerchio(3);

    }
    int getLato(){
        return r.lato;
    }
}
