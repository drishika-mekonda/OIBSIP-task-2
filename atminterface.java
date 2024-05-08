import java.util.Scanner;

public class ATM_Interface {
    
    private static int balance = 5000;
    private static int withdraw = 0;
    private static int deposit = 0;
    
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        while(true) {
            printMenu();
            System.out.print("Choose the operation you want to perform: ");
            int choice = s.nextInt();
            switch(choice) {
                case 1:
                    withdrawMoney(s);
                    break;
                case 2:
                    depositMoney(s);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    transferMoney(s);
                    break;
                case 6:
                    System.out.println("Exiting ATM. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("-----------------------------------");
        System.out.println("|---- ATM INTERFACE----|");
        System.out.println("-----------------------------------");
        System.out.println("|   Choose 1 for Withdraw          |");
        System.out.println("|   Choose 2 for Deposit           |");
        System.out.println("|   Choose 3 for Check Balance     |");
        System.out.println("|   Choose 4 for Transaction History|");
        System.out.println("|   Choose 5 for Transfer Money    |");
        System.out.println("|   Choose 6 for EXIT              |");
        System.out.println("-----------------------------------");
    }

    private static void withdrawMoney(Scanner s) {
        System.out.print("Enter amount to be withdrawn: ");
        withdraw = s.nextInt();
        if (balance >= withdraw) {
            balance -= withdraw;
            System.out.println("Money Withdrawn Successfully! Please collect your money.");
        } else {
            System.out.println("Insufficient Balance. Please check your balance.");
        }
    }

    private static void depositMoney(Scanner s) {
        System.out.print("Enter amount to be deposited: ");
        deposit = s.nextInt();
        balance += deposit;
        System.out.println("Money has been successfully deposited.");
    }

    private static void checkBalance() {
        System.out.println("Your Balance: " + balance);
    }

    private static void showTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println("Deposited Amount: " + deposit);
        System.out.println("Withdrawn Amount: " + withdraw);
    }

    private static void transferMoney(Scanner s) {
        System.out.print("Enter the Account No: ");
        int accountNo = s.nextInt();
        System.out.print("Enter the Amount to Transfer: ");
        int amount = s.nextInt();
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Transfer Successful!");
        } else {
            System.out.println("Insufficient Balance. Transfer failed.");
        }
    }
}
