import java.util.Scanner;

public class Level1Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();
        if (number < 1) {
            System.out.println("Not a natural number.");
            System.exit(0);
        }
        int[] odd = new int[number / 2 + 1];
        int[] even = new int[number / 2 + 1];
        int oddIndex = 0, evenIndex = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) even[evenIndex++] = i;
            else odd[oddIndex++] = i;
        }
        System.out.println("Odd numbers: " + java.util.Arrays.toString(odd));
        System.out.println("Even numbers: " + java.util.Arrays.toString(even));
    }
}
