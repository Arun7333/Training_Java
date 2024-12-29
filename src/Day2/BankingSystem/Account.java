package Day2.BankingSystem;

import java.time.LocalDate;

abstract class Account {
    protected int accountNumber;
    protected User accountHolder;
    protected int balance;
    private String accountType;

    Account(int accountNumber, User accountHolder, String accountType){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        balance = 0;
    }

    Account(int accountNumber, User accountHolder, int balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(int amount){
        balance += amount;
        System.out.println(accountHolder.getName() + ": " + amount + ".RS deposited in your account");
        System.out.println("Your balance is : " + this.getBalance());
    }

    public abstract void withdraw(int amount);

    public int getBalance(){
        return balance;
    }

    protected boolean isAvailable(int amount){
        return balance >= amount;
    }

    public String getAccountType(){
        return accountType;
    }

}

class Savings extends Account{
    private static final int withdrawLimit = 10000;
    private int todayWithdrawal;
    private LocalDate todayDate;

    Savings(int accountNumber, User accountHolder){
        super(accountNumber, accountHolder, "Savings");
        todayWithdrawal = 0;
        todayDate = LocalDate.now();
    }

    public void withdraw(int amount) throws LowBalance, LimitReached{
        checkDate();
        if(isAvailable(amount)){
            if(!isLimitReached(amount)) {
                balance -= amount;
                System.out.println(accountHolder.getName()+ ": " + amount + ".RS is withdrawn from your Account");
                this.todayWithdrawal += amount;
            }
            else throw new LimitReached();
        }
        else throw new LowBalance();

    }

    protected void checkDate(){
        if(todayDate != LocalDate.now()){
            todayDate = LocalDate.now();
            this.todayWithdrawal = 0;
        }
    }

    protected boolean isLimitReached(int amount){
        return this.todayWithdrawal + amount > withdrawLimit;
    }
}

class Current extends Account{

    Current(int accountNumber, User accountHolder){
        super(accountNumber, accountHolder, "Current");
    }

    public void withdraw(int amount) throws LowBalance{
        if(isAvailable(amount)){
            balance -= amount;
            System.out.println(accountHolder.getName()+ ": " + amount + ".RS is withdrawn from your Account");
        }
        else throw new LowBalance();
    }
}