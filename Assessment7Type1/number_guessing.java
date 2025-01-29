iymport java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        Random rand = new Random();
        boolean found = false;

        System.out.println("Think of a number between 1 and 100. I will try to guess it!");
        
        while (!found) {
            int guess = rand.nextInt(high - low + 1) + low;
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct'):");
            String feedback = sc.next().toLowerCase();

            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number!");
                found = true;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else {
                System.out.println("Invalid input! Please enter 'high', 'low', or 'correct'.");
            }
        }
    }
}
