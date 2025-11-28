public class Account {
    private double balance;
    private String accountNumber;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        balance=0;
    }

    public Account(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    void deposit(double amount){
        balance+=amount;
    }
    void withdraw(double amount){
        if (balance-amount >=0){
            balance-=amount;
            System.out.println("prelievo accettato");
        }else {
            System.out.println("prelievo respinto");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
