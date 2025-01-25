import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double weight, height;
            do {
                System.out.print("Enter weight for person " + (i + 1) + ": ");
                weight = sc.nextDouble();
            } while (weight <= 0);

            do {
                System.out.print("Enter height for person " + (i + 1) + ": ");
                height = sc.nextDouble();
            } while (height <= 0);

            double bmi = weight / (height * height);
            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("Height\tWeight\tBMI\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.println(personData[i][0] + "\t" + personData[i][1] + "\t" + personData[i][2] + "\t" + weightStatus[i]);
        }
    }
}
