//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String word = args[0];
        String vowels = "aeiouAEIOU";

        System.out.print(word +" contains the following vowels: ");

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < vowels.length(); j++) {
                if (word.charAt(i) == vowels.charAt(j)) {
                    System.out.print(word.charAt(i) + " ");
                }
            }

        }




    }
}