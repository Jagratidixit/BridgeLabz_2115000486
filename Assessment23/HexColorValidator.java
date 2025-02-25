
public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        return color.matches("^#([A-Fa-f0-9]{6})$");
    }

    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500")); // true
        System.out.println(isValidHexColor("#ff4500")); // true
        System.out.println(isValidHexColor("#123"));    // false
    }
}
