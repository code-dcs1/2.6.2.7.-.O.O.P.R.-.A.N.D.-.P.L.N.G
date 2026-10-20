import java.util.*;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the OOP Banking System");
        double openingBalance = readNonNegativeBalance(scanner);

        SavingsAccount savingsAccount = new SavingsAccount("Savings", openingBalance);
        CheckingAccount checkingAccount = new CheckingAccount("Checking", openingBalance);

        Account selectedAccount = savingsAccount;

        printAccountSummary(selectedAccount);
        boolean running = true;

        try {
            while (running) {
                showMenu();
                String choice = prompt(scanner, "Choice: ");

                switch (choice) {
                    case "1": {
                        double amount = readPositiveAmount(scanner, "Amount to withdraw: ");
                        if (amount > 0) {
                            if (selectedAccount.withdraw(amount)) {
                                System.out.println("Withdrawal fee: " + money(selectedAccount.calculateWithdrawalFee())
                                        + " | New " + selectedAccount.getAccountType()
                                        + " balance: " + money(selectedAccount.getBalance()));
                            } else {
                                System.out.println("Insufficient funds: amount plus fee ("
                                        + money(selectedAccount.calculateWithdrawalFee())
                                        + ") exceeds your balance. No changes made.");
                            }
                        }
                        break;
                    }
                    case "2": {
                        double amount = readPositiveAmount(scanner, "Amount to deposit: ");
                        if (amount > 0) {
                            selectedAccount.deposit(amount);
                            System.out.println("New " + selectedAccount.getAccountType()
                                    + " balance: " + money(selectedAccount.getBalance()));
                        }
                        break;
                    }
                    case "3":
                        printAccountSummary(selectedAccount);
                        break;
                    case "4":
                        selectedAccount = (selectedAccount == savingsAccount) ? checkingAccount : savingsAccount;
                        printAccountSummary(selectedAccount);
                        break;
                    case "5":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println();
        }

        System.out.println("Thank you for using the system!");
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("1 Withdraw  2 Deposit  3 Show balance  4 Switch account  5 Exit");
    }

    public static double readNonNegativeBalance(Scanner scanner) {
        while (true) {
            String input = prompt(scanner, "Opening balance: ");
            try {
                double value = Double.parseDouble(input);
                if (Double.isFinite(value) && value >= 0) {
                    return value;
                }
                System.out.println("Opening balance must be zero or more. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a numeric opening balance.");
            }
        }
    }

    public static double readPositiveAmount(Scanner scanner, String promptText) {
        String input = prompt(scanner, promptText);
        try {
            double value = Double.parseDouble(input);
            if (Double.isFinite(value) && value > 0) {
                return value;
            }
            System.out.println("Amount must be greater than zero. No changes made.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a number. No changes made.");
        }
        return -1;
    }

    public static void printAccountSummary(Account account) {
        System.out.println("Current account: " + account.getAccountType()
                + " | Balance: " + money(account.getBalance()));
    }

    private static String prompt(Scanner scanner, String text) {
        System.out.print(text);
        return scanner.nextLine().trim();
    }

    private static String money(double amount) {
        return String.format(Locale.US, "Php %.2f", amount);
    }
}

abstract class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double fee = calculateWithdrawalFee();
        if (amount + fee > balance) {
            return false;
        }
        balance -= (amount + fee);
        return true;
    }

    public abstract double calculateWithdrawalFee();
    public abstract String getAccountType();
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 0;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}

class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 10;
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}
