import java.util.Scanner;

public class Level1Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double userInput;

        System.out.println("Enter numbers to sum, enter 0 to finish:");

        while (true) {
            userInput = sc.nextDouble();
            if (userInput == 0) {
                break;
            }
            total += userInput;
        }

        System.out.println("The total sum is: " + total);
    }
}
