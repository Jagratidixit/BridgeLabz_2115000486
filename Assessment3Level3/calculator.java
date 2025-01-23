import java.util.Scanner;

public class Level3Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double first = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double second = sc.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        String op = sc.next();

        double result = 0;
        boolean validOperator = true;

        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                } else {
                    System.out.println("Error! Division by zero.");
                    validOperator = false;
                }
                break;
            default:
                System.out.println("Invalid Operator");
                validOperator = false;
                break;
        }

        if (validOperator) {
            System.out.println("The result is: " + result);
        }

    }
}
