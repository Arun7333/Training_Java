package Day2.BankingSystem;

import java.util.ArrayList;
import java.util.List;

class Bank {
    private int id;
    private String name;
    private List<Account> accounts;
    private List<User> users;
    private int accountNumber;

    Bank(int id, String name){
        this.id = id;
        this.name = name;
        accounts = new ArrayList<>();
        users = new ArrayList<>();
        accountNumber = 0;
    }

    public String getName(){
        return name;
    }

    public void addUser(User user){
        users.add(user);
        System.out.println("User " + user.getName() + " is added to the bank");
    }

    public void showUsers(){
        for(User user : users){
            System.out.println(user.getName());
        }
    }

    public void removeUser(User user){
        users.remove(user);
        System.out.println("User " + user.getName() + "is removed from the bank");
    }

    public Account createSavingsAccount(User user){
        Account newAccount = new Savings(getNewAccountNumber(), user);
        System.out.println("New Savings account created for " + user.getName());
        accounts.add(newAccount);
        return newAccount;
    }

    public Account createCurrentAccount(User user){
        Account newAccount = new Current(getNewAccountNumber(), user);
        System.out.println("New Current account created for " + user.getName());
        accounts.add(newAccount);
        return newAccount;
    }

    public void removeAccount(Account account){
        accounts.remove(account);
    }

    private int getNewAccountNumber(){
        return ++accountNumber;
    }
}
