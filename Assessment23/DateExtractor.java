import java.util.regex.*;
import java.util.*;

public class DateExtractor {
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher matcher = Pattern.compile(
            "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b"
        ).matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 32/08/2024, 29/02/2020, and 00/12/2021.";
        System.out.println(extractDates(text)); // [12/05/2023, 29/02/2020]
    }
}
