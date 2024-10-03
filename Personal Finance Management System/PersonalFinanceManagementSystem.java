import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PersonalFinanceManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, welcome to Personal Finance Management System!");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your initial income: ");
        double initialIncome = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        User user = new User(name, initialIncome);

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addIncome(user, scanner);
                    break;
                case 2:
                    addExpense(user, scanner);
                    break;
                case 3:
                    viewBalance(user);
                    break;
                case 4:
                    viewTransactions(user);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void addIncome(User user, Scanner scanner) {
        System.out.print("Enter income amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Transaction transaction = new Transaction("Income", amount, "Income");
        user.addTransaction(transaction);

        System.out.println("Income added successfully!");
    }

    private static void addExpense(User user, Scanner scanner) {
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter expense category (Food, Rent, etc.): ");
        String category = scanner.nextLine();

        Transaction transaction = new Transaction("Expense", -amount, category);
        user.addTransaction(transaction);

        System.out.println("Expense added successfully!");
    }

    private static void viewBalance(User user) {
        double balance = user.getAccount().getBalance();

        if (balance > 0) {
            System.out.println("You're saving well!");
        } else if (balance < 0) {
            System.out.println("You're in debt. Try to cut down on expenses.");
        } else {
            System.out.println("Your balance is zero.");
        }

        System.out.println("Current balance: " + balance);
    }

    private static void viewTransactions(User user) {
        ArrayList<Transaction> transactions = user.getTransactions();

        for (Transaction transaction : transactions) {
            System.out.println("Date: " + transaction.getDate());
            System.out.println("Type: " + transaction.getType());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Category: " + transaction.getCategory());
            System.out.println();
        }
    }
}
