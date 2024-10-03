import java.util.ArrayList;

public class User {
    private String name;
    private Account account;
    private ArrayList<Transaction> transactions;

    public User(String name, double initialIncome) {
        this.name = name;
        this.account = new Account(initialIncome);
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        account.updateBalance(transaction.getAmount());
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}