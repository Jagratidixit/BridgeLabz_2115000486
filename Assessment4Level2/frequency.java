import java.util.Scanner;

public class Level2Qq10 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        String numberStr = Integer.toString(number);
        int[] frequency = new int[10];
        
        for (char digit : numberStr.toCharArray()) {
            frequency[Character.getNumericValue(digit)]++;
        }
        
        System.out.println("Digit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + ": " + frequency[i]);
            }
        }
        
    }
}
