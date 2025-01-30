import java.util.*;

public class longest_word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();

        String longestWord = "";
        String array[] = s.split(" ");

        for (String str : array) {
            if (str.length() > longestWord.length()) {
                longestWord = str;
            }
        }

        System.out.print("Longest word is: " + longestWord);
    }
}

