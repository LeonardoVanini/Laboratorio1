import java.util.Objects;

public class Persona {
    private String nome;
    private String cognome;
    private int anni;
    private String avs;

    public Persona(String nome, String cognome, int anni, String avs) {
        this.nome = nome;
        this.cognome = cognome;
        this.anni = anni;
        this.avs = avs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAvs() {
        return avs;
    }

    public void setAvs(String avs) {
        this.avs = avs;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getAnni() {
        return anni;
    }

    public void setAnni(int anni) {
        this.anni = anni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", anni=" + anni +
                ", avs='" + avs + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return anni == persona.anni && Objects.equals(nome, persona.nome) && Objects.equals(cognome, persona.cognome) && Objects.equals(avs, persona.avs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, anni, avs);
    }
}
