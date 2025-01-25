import java.util.Scanner;
public class Level2Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height (in meters) for person " + (i + 1) + ": ");
            double height = sc.nextDouble();
            System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
            double weight = sc.nextDouble();

            if (height <= 0 || weight <= 0) {
                System.out.println("Invalid input. Please re-enter.");
                i--;
                continue;
            }

            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = weight / (height * height);

            double bmi = personData[i][2];
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        System.out.println("\nDetails:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + " - Height: " + personData[i][0] + ", Weight: " + personData[i][1] + ", BMI: " + personData[i][2] + ", Status: " + weightStatus[i]);
        }
    }
}
