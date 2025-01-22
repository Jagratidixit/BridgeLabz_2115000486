import java.util.Scanner;
public class Km_To_Miles_Converter {
    public static void main(String[] args) {
        double km;
        Scanner sc = new Scanner(System.in);
        km = sc.nextDouble();  // Use nextDouble() for decimal input
        double miles = km / 1.6;
        System.out.print("The total miles is " + miles + " mile for the given " + km + " km\n");
    }
}



