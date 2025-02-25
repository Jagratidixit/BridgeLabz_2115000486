import java.util.Arrays;
import java.util.List;

public class CensorBadWords {
    public static String censorText(String text) {
        List<String> badWords = Arrays.asList("damn", "stupid");
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        System.out.println(censorText(text)); // "This is a **** bad example with some **** words."
    }
}
