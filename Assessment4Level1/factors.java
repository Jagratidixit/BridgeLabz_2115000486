import java.util.Scanner;

public class Level1Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int maxFactor = 10, index = 0;
        int[] factors = new int[maxFactor];
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index == maxFactor) {
                    maxFactor *= 2;
                    factors = java.util.Arrays.copyOf(factors, maxFactor);
                }
                factors[index++] = i;
            }
        }
        System.out.println("Factors: " + java.util.Arrays.toString(java.util.Arrays.copyOf(factors, index)));
    }
}
