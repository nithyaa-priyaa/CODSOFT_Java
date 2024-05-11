import java.util.Scanner;

public class MarksCalculator {
    // Define the number of subjects (you can change this as per your requirement)
    private static final int NUM_SUBJECTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to store marks for each subject
        int[] marks = new int[NUM_SUBJECTS];

        // Input marks for each subject
        System.out.println("Enter marks for " + NUM_SUBJECTS + " subjects (out of 100):");
        for (int i = 0; i < NUM_SUBJECTS; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Calculate total marks
        int totalMarks = calculateTotalMarks(marks);

        // Calculate average percentage
        double averagePercentage = calculateAveragePercentage(totalMarks);

        // Calculate grade based on average percentage
        char grade = calculateGrade(averagePercentage);

        // Display results
        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    // Calculate total marks
    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Calculate average percentage
    private static double calculateAveragePercentage(int totalMarks) {
        return (double) totalMarks / NUM_SUBJECTS;
    }

    // Calculate grade based on average percentage
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 60) {
            return 'C';
        } else if (averagePercentage >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Display the results
    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }
}