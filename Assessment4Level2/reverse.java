import java.util.Scanner;
public class Level2Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Invalid number.");
            System.exit(0);
        }

        int digitCount = String.valueOf(number).length();
        int[] digits = new int[digitCount];

        for (int i = 0; i < digitCount; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        System.out.println("Reversed Number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i]);
        }
    }
}
