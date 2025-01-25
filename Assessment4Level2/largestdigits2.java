import java.util.Scanner;

public class Level2Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String number = sc.nextLine();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int count = 0;

        for (int i = 0; i < number.length(); i++) {
            char digitChar = number.charAt(i);

            if (Character.isDigit(digitChar)) {
                if (count == maxDigit) {
                    maxDigit += 10;
                    int[] temp = new int[maxDigit];
                    System.arraycopy(digits, 0, temp, 0, digits.length);
                    digits = temp;
                }
                digits[count++] = digitChar - '0';
            }
        }

        if (count < 2) {
            System.out.println("Not enough digits to find the largest and second largest.");
        } else {
            int largest = -1, secondLargest = -1;
            for (int i = 0; i < count; i++) {
                if (digits[i] > largest) {
                    secondLargest = largest;
                    largest = digits[i];
                } else if (digits[i] > secondLargest && digits[i] != largest) {
                    secondLargest = digits[i];
                }
            }

            System.out.println("The largest digit is: " + largest);
            System.out.println("The second largest digit is: " + secondLargest);
        }

    }
}
