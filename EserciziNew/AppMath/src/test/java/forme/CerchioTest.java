package test.java.forme;

import main.java.forme.Cerchio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CerchioTest {
    @Test
    void area() {
        double raggio =5;
        double expectedResult = 78.539;
        double delta = 0.001;
        Cerchio cerchio = new Cerchio(raggio);
        double actualResult = cerchio.area();

        assertEquals(expectedResult,actualResult,delta);
    }

    @Test
    void perimetro() {
        double raggio =5;
        double expectedResult = 31.415;
        double delta = 0.001;
        Cerchio cerchio = new Cerchio(raggio);
        double actualResult = cerchio.perimetro();

        assertEquals(expectedResult,actualResult,delta);
    }
}