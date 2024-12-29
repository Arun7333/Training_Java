package Day2.BankingSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(01, "Bank of Burudaaa");
        Manager manager = new Manager(01, "Arun", bank);

        User user1 = new User(01, 18, "Karthi", manager);
        User user2 = new User(02, 21, "John", manager);

        manager.addUser(user1);
        manager.addUser(user2);

        user1.createAccount("Savings");
        user1.createAccount("Current");

        user2.createAccount("Savings");

        List<Account> user1Accounts = user1.getAccounts();
        List<Account> user2Accounts = user2.getAccounts();

        for(Account account : user1Accounts){
            user1.deposit(account, 10000 * account.accountNumber);
        }

        for(Account account : user2Accounts){
            user2.deposit(account, 30000);
        }

        user1.withdraw(user1Accounts.get(0), 10001);
        user2.withdraw(user2Accounts.get(0), 10000);

        user2.withdraw(user2Accounts.get(0), 10000);

        for(Account account : user1Accounts){
            user1.checkBalance(account);
        }

        for(Account account : user2Accounts){
            user2.checkBalance(account);
        }

    }
}
