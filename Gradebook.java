import java.util.*;
import java.text.*;

public class Gradebook{
    public static DecimalFormat td = new DecimalFormat("0.00");
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String username;
        String password;

        // Prompt for username and password
        System.out.println("Please Enter your Username: ");
        username = scan.nextLine();

        System.out.println("Please Enter your Password: ");
        password = scan.nextLine();

        // Validate username and password
        if (username.equals("CSCI1302") && password.equals("SpRiNg2002")) {
            System.out.println("Welcome Computer Science Major! Please Follow the Directions Below");
            System.out.println();

            System.out.println("You Are Going to be Entering 10 Grades (0-100)");

            double sum = 0;
            double grade;

            // Input grades and calculate sum
            for (int i = 1; i <= 10; i++) {
                while (true) { // Loop to validate input
                    System.out.println("Enter Grade " + i + " (0-100): ");
                    grade = scan.nextDouble();

                    if (grade >= 0 && grade <= 100) {
                        sum += grade;
                        break; // Exit loop for valid input
                    } else {
                        System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                    }
                }
            }

            // Calculate and display average grade
            double averageGrade = sum / 10;
            System.out.println("The Average Grade is: " + td.format(averageGrade));

            // Determine letter grade
            char grade1;
            if (averageGrade >= 90) {
                grade1 = 'A';
            } else if (averageGrade >= 80) {
                grade1 = 'B';
            } else if (averageGrade >= 70) {
                grade1 = 'C';
            } else if (averageGrade >= 60) {
                grade1 = 'D';
            } else {
                grade1 = 'F';
            }

            // Provide feedback based on letter grade
            System.out.print("Letter Grade: " + grade1 + " - ");
            switch (grade1) {
                case 'A':
                    System.out.println("Perfect Score!!");
                    break;
                case 'B':
                    System.out.println("Good Job!");
                    break;
                case 'C':
                    System.out.println("Average Score");
                    break;
                case 'D':
                    System.out.println("Try Harder Next Time");
                    break;
                case 'F':
                    System.out.println("You Failed");
                    break;
                default:
                    System.out.println("Invalid Grade");
            }
        } else {
            System.out.println("You've Entered the Wrong Username or Password");
        }
    }
}
