import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = getInput();
        int result = factorial(n);
        displayResult(n, result);
    }

    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        return num;
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void displayResult(int n, int result) {
        System.out.println("Factorial of " + n + " is: " + result);
    }
}
