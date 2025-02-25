import java.util.regex.*;
import java.util.*;

public class RepeatingWordsFinder {
    public static List<String> findRepeatingWords(String text) {
        List<String> words = new ArrayList<>();
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(text);

        while (matcher.find()) {
            words.add(matcher.group(1));
        }
        return words;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        System.out.println(findRepeatingWords(text)); // [is, repeated]
    }
}
