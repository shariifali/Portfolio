import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class RestaurantReceiptCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        // Initialize variables
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        double taxRate = 0.07; // 7% tax rate
        String moreItems;

        System.out.println("Welcome to the Restaurant Receipt Calculator!");

        // Get item prices and names
        do {
            System.out.print("Enter the name of the item: ");
            String itemName = scanner.nextLine();
            items.add(itemName);

            System.out.print("Enter the price of " + itemName + ": $");
            double price = scanner.nextDouble();
            prices.add(price);

            scanner.nextLine(); // Consume leftover newline

            System.out.print("Do you want to add another item? (yes/no): ");
            moreItems = scanner.nextLine().trim().toLowerCase();

        } while (moreItems.equals("yes"));

        // Calculate subtotal, tax, and total
        double subtotal = 0;
        for (double price : prices) {
            subtotal += price;
        }
        double tax = subtotal * taxRate;
        double total = subtotal + tax;

        // Print receipt
        System.out.println("\n************ RECEIPT ************");
        System.out.println("Items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%-20s $%s\n", items.get(i), df.format(prices.get(i)));
        }
        System.out.println("---------------------------------");
        System.out.printf("Subtotal:               $%s\n", df.format(subtotal));
        System.out.printf("Tax (7%%):              $%s\n", df.format(tax));
        System.out.printf("Total:                 $%s\n", df.format(total));
        System.out.println("*********************************");
        System.out.println("Thank you for dining with us!");

        scanner.close();
    }
}
