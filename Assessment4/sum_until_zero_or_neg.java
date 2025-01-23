import java.util.Scanner;
public class LevelQ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.print("Enter a number: ");

            if (number <= 0) {
                break;
            }

            sum += number;
        }

        System.out.println("The sum is: " + sum);
    }
}
