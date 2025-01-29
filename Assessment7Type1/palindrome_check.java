import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = getInput();
        boolean isPalindrome = checkPalindrome(str);
        displayResult(str, isPalindrome);
    }

    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        return str;
    }

    public static boolean checkPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void displayResult(String str, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }
}
