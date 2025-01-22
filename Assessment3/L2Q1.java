import java.util.Scanner;

public class QuotientReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int quotient = number1 / number2;
        int reminder = number1 % number2;
        System.out.println("The Quotient is " + quotient + " and Reminder is " + reminder + " of two numbers " + number1 + " and " + number2);
    }
}
