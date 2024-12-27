package Day2.OOP_Basics;

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount newBankAccount = new BankAccount(100);
        newBankAccount.deposit(1000);
        newBankAccount.showBalance();
        try{
            newBankAccount.withdraw(5000);
        }
        catch(amountExceededException e){
            System.out.println(e.getMessage());
        }

    }
}

class BankAccount{
    private int accountNumber;
    private int balance;

    BankAccount(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public int withdraw(int amount) throws amountExceededException{
        if(amount <= balance){
            balance -= amount;
            return amount;
        }
        else throw new amountExceededException();
    }

    public void showBalance(){
        System.out.println("Balance Amount: " + balance);
    }
}

class amountExceededException extends Exception{
    amountExceededException(){
        super("Amount exceeded!");
    }
}
