package Day2.BankingSystem;

import java.util.ArrayList;
import java.util.List;

class User{
    private int id;
    private int age;
    private String name;
    private Manager manager;
    public List<Account> accounts;

    public User(int id, int age, String name, Manager manager){
        this.id = id;
        this.age = age;
        this.name = name;
        this.manager = manager;
        accounts = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void deposit(Account account, int amount){
        account.deposit(amount);
    }

    public void withdraw(Account account, int amount){
        try{
            account.withdraw(amount);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void checkBalance(Account account){
        System.out.println(this.getName() + " : Your balance is " +account.getBalance());
    }

    public void createAccount(String accountType){
        Account account;
        if(accountType.equals("Savings")){
            account = manager.createSavingsAccount(this);
        }
        else{
            account = manager.creatCurrentAccount(this);
        }
        accounts.add(account);
    }

    public void closeAccount(Account account){
        manager.removeAccount(account);
        accounts.remove(account);
        System.out.println("Account closed successfully!");
    }

    public List<Account> getAccounts(){
        return new ArrayList<>(accounts);
    }

    public void deleteUser(){
        manager.removeUser(this);
    }

    public boolean isMajor(){
        return age >= 18;
    }
}
