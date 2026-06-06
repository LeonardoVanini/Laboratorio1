import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GestioneEventiTest {

    @Test
    void prenotaSuEvento() {

        //configurazione e creazione evento test
        GestioneEventi g = new GestioneEventi();
        Evento e = new EventoBase("esmpio", LocalDate.parse("2027-02-02"),2);
        g.aggiungiEvento(e);

        String firstUser = "Pippo";
        String secondUser = "Luigi";
        String thirdUser = "Marco";
        boolean expectedfirstResult = true;
        boolean expectedSecondResult = true;
        boolean expectedThirdResult = false;

        boolean actualfirstResult = g.prenotaSuEvento(firstUser,0);
        boolean actualSecondResult = g.prenotaSuEvento(secondUser,0);
        boolean actualThirdResult = g.prenotaSuEvento(thirdUser,0);

        assertEquals(expectedfirstResult,actualfirstResult);
        assertEquals(expectedSecondResult,actualSecondResult);
        assertEquals(expectedThirdResult,actualThirdResult);



    }
}