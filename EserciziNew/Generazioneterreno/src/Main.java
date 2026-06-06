//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double ampiezza =1;
        double periodo =4;
        double traslazioneOrizzontale=0;
        double traslazioneVerticale=0;

        for (int i = 0; i < 100; i++) {
            double j = 0.04 * i;
            System.out.println(genera(j,ampiezza,periodo,0,0));
        }

    }

    static public double genera (double x, double a, double p, double x_s, double y_s){
        double sinusoide = a*Math.sin((2 * Math.PI /p)*(x - x_s))+y_s;

        double epsilon = 1e-10;

        if (Math.abs(sinusoide) < epsilon) {
            sinusoide = 0;
        }
        return sinusoide;
    }
}