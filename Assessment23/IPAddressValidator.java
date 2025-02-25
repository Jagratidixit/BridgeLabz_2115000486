import java.util.regex.*;

public class IPAddressValidator {
    public static boolean isValidIP(String ip) {
        String regex = "\\b((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\b";
        return Pattern.matches(regex, ip);
    }

    public static void main(String[] args) {
        System.out.println(isValidIP("192.168.1.1")); // true
        System.out.println(isValidIP("256.256.256.256")); // false
    }
}
