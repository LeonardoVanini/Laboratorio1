package ch.samt.biblioteca.data;

import ch.samt.biblioteca.model.ItemBiblioteca;
import ch.samt.biblioteca.model.Libro;

import java.util.*;

public class Biblioteca {
    private ArrayList<ItemBiblioteca> catalogo;
    private Set<String> codiciUsati;
    private Map<String,ArrayList<ItemBiblioteca>> elementiPerAutore;
    private Queue<ItemBiblioteca> prenotazioniFIFO;
    private Stack<ItemBiblioteca> consegneUrgentiLIFO;

    public Biblioteca() {
        catalogo = new ArrayList<>();
        codiciUsati = new HashSet<>();
        elementiPerAutore = new HashMap<>();
        prenotazioniFIFO = new LinkedList<>();
        consegneUrgentiLIFO = new Stack<>();
    }

    public boolean aggiungiItem(ItemBiblioteca item){
        if (codiciUsati.contains(item.getCodice())){
            return false;
        }else {
            catalogo.add(item);
            codiciUsati.add(item.getCodice());
            try {
                Libro itemLibro = (Libro) item;
                if (!elementiPerAutore.containsKey(itemLibro.getAutore())) {
                    elementiPerAutore.put(itemLibro.getAutore(), new ArrayList<>());
                }
                elementiPerAutore.get(itemLibro.getAutore()).add(item);
            }catch (ClassCastException e){
                //System.out.println(e);
            }
            return true;
        }
    }

    public ArrayList<ItemBiblioteca> getCatalogo(){
        return catalogo;
    }
    public ArrayList<ItemBiblioteca> getElementiDiAutore(String autore){
        return elementiPerAutore.get(autore);
    }


    public void aggiungiPrenotazioneFIFO(ItemBiblioteca item){
        prenotazioniFIFO.add(item);
    }
    public ItemBiblioteca prossimaPrenotazioneFIFO(){
        return prenotazioniFIFO.poll();
    }
    public void aggiungiConsegnaUrgenteLIFO(ItemBiblioteca item){
        consegneUrgentiLIFO.add(item);
    }
    public ItemBiblioteca prossimaConsegnaLIFO(){
        return consegneUrgentiLIFO.pop();
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Biblioteca that = (Biblioteca) o;
        return Objects.equals(catalogo, that.catalogo) && Objects.equals(codiciUsati, that.codiciUsati) && Objects.equals(elementiPerAutore, that.elementiPerAutore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogo, codiciUsati, elementiPerAutore);
    }
}
