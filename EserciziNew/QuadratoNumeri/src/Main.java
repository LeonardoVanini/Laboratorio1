//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            try{
                double num = Double.parseDouble(arg);
                if (num == (int)num){
                    int numero = (int)num;
                    if (numero >= 0){
                        int quadrato = numero * numero;
                        System.out.println(numero +" quadrato: "+quadrato);
                    }
                    else {
                        System.out.println(numero+" Errore: il numero deve essere positivo");
                    }

                }
                else{
                    System.out.println(num + " Errore: il numero deve essere intero");
                }
            }
            catch(NumberFormatException e){
                System.out.println(arg + " Errore: input non numerico");
            }
        }
    }
}