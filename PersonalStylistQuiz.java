import java.util.Scanner;

public class PersonalStylistQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to the Personal Stylist Quiz");
        System.out.println("Answer the following questions to find your perfect look.");
        System.out.println("--------------------------------------------------------");

        // Questions
        System.out.print("1. What's your favorite style? (Casual, Formal, Sporty, Edgy, Vintage): ");
        String style = scanner.nextLine().trim().toLowerCase();

        System.out.print("2. What colors do you love wearing? (Neutral, Bright, Dark, Pastel): ");
        String color = scanner.nextLine().trim().toLowerCase();

        System.out.print("3. What's the current weather like? (Hot, Cold, Mild): ");
        String weather = scanner.nextLine().trim().toLowerCase();

        System.out.print("4. What's the occasion? (Work, Party, Workout, Relaxing): ");
        String activity = scanner.nextLine().trim().toLowerCase();

        System.out.print("5. What's your budget range? (Low, Medium, High): ");
        String budget = scanner.nextLine().trim().toLowerCase();

        System.out.println("\nProcessing your answers...\n");

        // Suggest looks based on responses
        String look = "";

        if (style.equals("casual") && (activity.equals("relaxing") || activity.equals("party"))) {
            look = "A comfortable oversized hoodie, distressed jeans, and sneakers.";
        } else if (style.equals("formal") || activity.equals("work")) {
            look = "A tailored blazer, dress pants, and classic leather shoes.";
        } else if (style.equals("sporty") || activity.equals("workout")) {
            look = "Athletic leggings, a moisture-wicking top, and trendy sneakers.";
        } else if (style.equals("edgy") && color.equals("dark")) {
            look = "A leather jacket, ripped black jeans, and chunky boots.";
        } else if (style.equals("vintage") && (budget.equals("medium") || budget.equals("high"))) {
            look = "A retro A-line dress, pearls, and kitten heels.";
        } else if (weather.equals("hot")) {
            look = "A breezy sundress, sandals, and a sunhat.";
        } else if (weather.equals("cold")) {
            look = "A chic trench coat, scarf, and knee-high boots.";
        } else {
            look = "Something versatile: A plain tee, jeans, and comfortable sneakers.";
        }

        // Final output
        System.out.println(" Your perfect look suggestion: " + look);
        System.out.println("Now you're ready to rock your style! ");

        scanner.close();
    }
}
