import java.util.Scanner;

public class height_Converter {
    public static void main(String[] args) {
        double heightCm;
        Scanner sc = new Scanner(System.in);
        
        heightCm = sc.nextDouble();
        
        double totalInches = heightCm / 2.54;
        int feet = (int) totalInches / 12;
        int inches = (int) totalInches % 12;
        
        System.out.print("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + inches + "\n");
    }
}


