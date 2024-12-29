package Day2.BankingSystem;

public class LowBalance extends RuntimeException {
    public LowBalance() {
        super("Account's balance is low!");
    }
}
