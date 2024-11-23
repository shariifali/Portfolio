import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    String accountNumber;
    double amount;
    String transactionTime;

    public Transaction(String accountNumber, double amount, String transactionTime) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Amount: $" + amount + ", Time: " + transactionTime;
    }
}

public class FraudDetectionSystem {
    private static final double MAX_TRANSACTION_AMOUNT = 10000.00; // Threshold for large transactions
    private static final long MIN_TIME_DIFFERENCE = 60000; // 1 minute in milliseconds

    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Fraud Detection System!");

        while (true) {
            // Collect transaction details
            System.out.println("\nEnter transaction details:");
            System.out.print("Account Number: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Transaction Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.print("Transaction Time (yyyy-MM-dd HH:mm:ss): ");
            String transactionTime = scanner.nextLine();

            // Create a new transaction and add it to the list
            Transaction newTransaction = new Transaction(accountNumber, amount, transactionTime);
            transactions.add(newTransaction);

            // Check for potential fraud
            checkFraud(transactions, newTransaction);

            // Ask the user if they want to add more transactions
            System.out.print("\nDo you want to add another transaction? (yes/no): ");
            String moreTransactions = scanner.nextLine().toLowerCase();
            if (!moreTransactions.equals("yes")) {
                break;
            }
        }

        System.out.println("\nAll transactions processed. Thank you!");
        scanner.close();
    }

    private static void checkFraud(ArrayList<Transaction> transactions, Transaction currentTransaction) {
        boolean isFraudulent = false;

        // Rule 1: Check for unusually large transaction amounts
        if (currentTransaction.amount > MAX_TRANSACTION_AMOUNT) {
            System.out.println("Fraud Alert: Unusually large transaction detected!");
            System.out.println(currentTransaction);
            isFraudulent = true;
        }

        // Rule 2: Check for rapid successive transactions from the same account
        for (Transaction transaction : transactions) {
            if (!transaction.equals(currentTransaction) && transaction.accountNumber.equals(currentTransaction.accountNumber)) {
                long timeDifference = getTimeDifference(transaction.transactionTime, currentTransaction.transactionTime);
                if (timeDifference < MIN_TIME_DIFFERENCE) {
                    System.out.println("Fraud Alert: Rapid successive transactions detected!");
                    System.out.println("Previous Transaction: " + transaction);
                    System.out.println("Current Transaction: " + currentTransaction);
                    isFraudulent = true;
                }
            }
        }

        if (!isFraudulent) {
            System.out.println(" Transaction is valid: " + currentTransaction);
        }
    }

    private static long getTimeDifference(String time1, String time2) {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long time1Millis = sdf.parse(time1).getTime();
            long time2Millis = sdf.parse(time2).getTime();
            return Math.abs(time1Millis - time2Millis);
        } catch (java.text.ParseException e) {
            System.out.println("Error parsing time: " + e.getMessage());
            return Long.MAX_VALUE; // Return a large value to avoid false positives
        }
    }
}
