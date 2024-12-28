package Day2.Constructors;

public class ConstructorOverloading {

}

class Account{
    private int accountNumber;
    private int balance;

    Account(int accountNumber){
        this.accountNumber = accountNumber;
    }

    Account(int accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
