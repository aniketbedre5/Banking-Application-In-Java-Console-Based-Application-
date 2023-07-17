import java.util.Scanner;

public class ABbanking {
    private static double balance = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        boolean exit = false;
        while (!exit) {
            bankingSystem.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bankingSystem.checkBalance();
                    break;
                case 2:
                    bankingSystem.deposit();
                    break;
                case 3:
                    bankingSystem.withdraw();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println();
        }

        System.out.println("Thank you for using the AB Banking Application!");
    }

    private static class BankingSystem {
        public void displayMenu() {
            System.out.println("Welcome to the AB Banking:");
            System.out.println("1. Check Balance: ");
            System.out.println("2. Deposit: ");
            System.out.println("3. Withdraw: ");
            System.out.println("4. Exit.");
            System.out.print("Please enter your choice: ");
        }

        public void checkBalance() {
            System.out.println("Your balance is: $" + balance);
        }

        public void deposit() {
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful!");
            } else {
                System.out.println("Invalid amount.");
            }
        }

        public void withdraw() {
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            if (amount > 0) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdrawal successful!");
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Invalid amount.");
            }
        }
    }
}
