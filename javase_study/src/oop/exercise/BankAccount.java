package oop.exercise;

public class BankAccount {
    private String name;
    private String accountNo;
    private double balance;

    public BankAccount(String name, String accountNo, double balance) {
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public BankAccount() {
        this("", "", 0.0);
    }

    public BankAccount(String name, double balance) {
        this(name, "HK001", balance);
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("CHAN DA MAN", "HK002", 500);
        System.out.println(bankAccount.getAccountInfo());
    }

    public String getAccountInfo() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                '}';
    }

}
