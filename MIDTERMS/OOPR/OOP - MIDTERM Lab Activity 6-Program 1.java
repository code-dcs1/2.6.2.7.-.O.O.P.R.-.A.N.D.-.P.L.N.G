import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("Enter your initial balance: ");
        int balance = scanner.nextInt();

        boolean running = true;

        while (running) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("Select an option:");
            System.out.println("1. Withdraw Amount");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Exit");
            System.out.println("--------------------------------------------------");
            System.out.print("Enter your choice (1-3): ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("How much amount you want to withdraw from your account?");
                    System.out.print("Amount: ");
                    int withdrawAmount = scanner.nextInt();
                    
                    if (withdrawAmount > balance) {
                        System.out.println("Transaction failed: Insufficient funds!");
                    } else if (withdrawAmount < 0) {
                        System.out.println("Invalid amount!");
                    } else {
                        balance -= withdrawAmount;
                        System.out.println("Your new balance is: " + balance);
                    }
                    break;

                case 2:
                    System.out.println("How much amount you want to deposit in your account?");
                    System.out.print("Amount: ");
                    int depositAmount = scanner.nextInt();
                    
                    if (depositAmount < 0) {
                        System.out.println("Invalid deposit amount!");
                    } else {
                        balance += depositAmount;
                        System.out.println("Your new balance is: " + balance);
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the system!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option! Please select 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
