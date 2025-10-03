//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String word = args[0];
        String old = args[1];
        String newV = args[2];
        String newWord = "";

        newWord = word.replace(old, newV);

        System.out.println("The word "+word+ " has been changed to "+newWord);
    }
}