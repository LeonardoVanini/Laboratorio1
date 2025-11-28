public class Sviluppatore {
    private String nome;
    private String cognome;

    public Sviluppatore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
