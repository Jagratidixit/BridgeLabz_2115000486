import java.util.Scanner;

public class Level2Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        int count = 0;

        while (number != 0) {
            number /= 10;
            count++;
        }

        System.out.println("Number of digits: " + count);
    }
}
