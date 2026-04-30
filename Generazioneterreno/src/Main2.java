import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main2 extends JPanel {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Sinusoide");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new Main2());
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double ampiezza = 150;
        double periodo = 10;
        double traslazioneOrizzontale = 0;
        double traslazioneVerticale = 200;

        int prevX = 0;
        int prevY = (int) traslazioneVerticale;

        for (int i = 0; i <= 500; i++) {
            double x = i * 0.04;
            double y = genera(x, ampiezza, periodo, traslazioneOrizzontale, traslazioneVerticale);

            int drawX = i;
            int drawY = (int) (getHeight() - y); // inverti y per grafico

            g.drawLine(prevX, prevY, drawX, drawY);

            prevX = drawX;
            prevY = drawY;
        }
    }

    static public double genera(double x, double a, double p, double x_s, double y_s) {

        double sinusoide = a * Math.sin((2 * Math.PI / p) * (x - x_s)) + y_s;
        double epsilon = 1e-10;
        if (Math.abs(sinusoide) < epsilon) sinusoide = 0;
        return sinusoide;
    }
}
