import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        
        System.out.print("Enter the unit (C for Celsius, F for Fahrenheit): ");
        char unit = sc.next().charAt(0);


        if (unit == 'C' || unit == 'c') {
            double fahrenheit = celsiusToFahrenheit(temp);
            System.out.println(temp + " Celsius is equal to " + fahrenheit + " Fahrenheit.");
        } else if (unit == 'F' || unit == 'f') {
            double celsius = fahrenheitToCelsius(temp);
            System.out.println(temp + " Fahrenheit is equal to " + celsius + " Celsius.");
        } else {
            System.out.println("Invalid unit entered.");
        }
    }


    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }


    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
