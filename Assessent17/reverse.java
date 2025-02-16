import java.util.*;

public class Reverse {
    public static String reverseString(String s) {
        StringBuilder revstr = new StringBuilder();
        for (char ch : s.toCharArray()) {
            revstr.append(ch);
        }
        return revstr.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(reverseString(s));
    }
}
