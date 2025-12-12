package ch.samt.dictionary;

public class Entry {
    private String parolaItaliano;
    private String ParolaInglese;

    public Entry(String parolaItaliano, String parolaInglese) {
        this.parolaItaliano = parolaItaliano;
        ParolaInglese = parolaInglese;
    }

    public String getParolaItaliano() {
        return parolaItaliano;
    }

    public void setParolaItaliano(String parolaItaliano) {
        this.parolaItaliano = parolaItaliano;
    }

    public String getParolaInglese() {
        return ParolaInglese;
    }

    public void setParolaInglese(String parolaInglese) {
        ParolaInglese = parolaInglese;
    }

    @Override
    public String toString() {
        return "ITA: " + parolaItaliano +" -> ENG: " + ParolaInglese;
    }
}