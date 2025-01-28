import java.util.Scanner;

public class Level1Q7 {
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        int result = findSum(n);
        System.out.println("The sum of the first " + n + " natural numbers is: " + result);
    }
}

	
