package Day2.BankingSystem;

class Manager {
    private int id;
    private String name;
    private Bank bank;

    Manager(int id, String name, Bank bank){
        this.id = id;
        this.name = name;
        this.bank = bank;
    }

    public void addUser(User user){
        bank.addUser(user);
    }

    public void removeUser(User user){
        bank.removeUser(user);
    }

    public Account createSavingsAccount(User user){
        return bank.createSavingsAccount(user);
    }

    public Account creatCurrentAccount(User user){
        return bank.createCurrentAccount(user);
    }

    public void removeAccount(Account account){
        bank.removeAccount(account);
    }
}
