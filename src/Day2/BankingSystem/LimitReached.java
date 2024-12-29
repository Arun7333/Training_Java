package Day2.BankingSystem;

public class LimitReached extends RuntimeException {
    public LimitReached() {
        super("Your day's withdraw limit reached!");
    }
}
