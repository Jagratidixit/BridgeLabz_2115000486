import java.util.Scanner;

class Level2Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        int[][] marks = new int[numStudents][3]; // [][0]: Physics, [][1]: Chemistry, [][2]: Maths
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");

            do {
                System.out.print("Physics (0-100): ");
                marks[i][0] = input.nextInt();
            } while (marks[i][0] < 0 || marks[i][0] > 100);

            do {
                System.out.print("Chemistry (0-100): ");
                marks[i][1] = input.nextInt();
            } while (marks[i][1] < 0 || marks[i][1] > 100);

            do {
                System.out.print("Maths (0-100): ");
                marks[i][2] = input.nextInt();
            } while (marks[i][2] < 0 || marks[i][2] > 100);

            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        System.out.println("\nResults:");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Student %d: Physics = %d, Chemistry = %d, Maths = %d, Percentage = %.2f%%, Grade = %c%n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }

    }
}
