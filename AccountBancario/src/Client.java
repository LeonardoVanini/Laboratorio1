public class Client {
    private String name;
    private Account account;

    public Client(String name, String accountNumber) {
        this.name = name;
        account= new Account(accountNumber);
    }
    public Client(String name, String accountNumber, double balance) {
        this.name = name;
        account= new Account(balance,accountNumber);
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    void addFunds(double amount){
        account.deposit(amount);
    }
    void withdrawFunds(double amount){
        account.withdraw(amount);
    }
}
