public class LicensePlateValidator {
    public static boolean isValidPlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        System.out.println(isValidPlate("AB1234")); // true
        System.out.println(isValidPlate("A12345")); // false
    }
}
