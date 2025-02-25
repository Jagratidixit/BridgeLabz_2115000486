import java.util.regex.*;

public class CreditCardValidator {
    public static boolean isValidCard(String cardNumber) {
        String regex = "^(4\\d{15}|5\\d{15})$";
        return Pattern.matches(regex, cardNumber);
    }

    public static void main(String[] args) {
        System.out.println(isValidCard("4111111111111111")); // true (Visa)
        System.out.println(isValidCard("5111111111111111")); // true (MasterCard)
        System.out.println(isValidCard("6111111111111111")); // false
    }
}
