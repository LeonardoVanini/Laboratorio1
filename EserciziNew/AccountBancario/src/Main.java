//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Client c1=new Client("Giorgio","001",10);
        System.out.println(c1.getAccount());
        c1.withdrawFunds(5);
        System.out.println(c1.getAccount());
        c1.withdrawFunds(10);
        System.out.println(c1.getAccount());
        c1.addFunds(20);
        System.out.println(c1.getAccount());
    }
}