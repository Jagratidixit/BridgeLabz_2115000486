import java.util.*;

public class RemoveDuplicates {
    public static String duplicateRemove(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.add(c)) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "programming";
        System.out.println(duplicateRemove(str));
    }
}
