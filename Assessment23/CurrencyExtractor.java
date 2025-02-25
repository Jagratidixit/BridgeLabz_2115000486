import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {
    public static List<String> extractCurrency(String text) {
        List<String> values = new ArrayList<>();
        String regex = "\\$?\\d+\\.\\d{2}";
        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        System.out.println(extractCurrency(text)); // [$45.99, 10.50]
    }
}
