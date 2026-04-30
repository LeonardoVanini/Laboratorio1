package test.java.forme;

import main.java.forme.Rettangolo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RettangoloTest {
    private Rettangolo rettangolo;



    @ParameterizedTest
    @CsvSource({
            "3.0, 4.0, 12.0",
            "5.0, 5.0, 25.0",
            "1.0, 10.0, 10.0",
            "2.5, 4.0, 10.0"
    })
    void testArea(double base, double altezza, double areaAttesa){
        rettangolo = new Rettangolo(base,altezza);
        double areaEffettiva = rettangolo.area();
        assertEquals(areaAttesa,areaEffettiva,0.001);
    }
}