import java.util.Scanner;

public class Level1Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the start value for the countdown: ");
        int startValue = sc.nextInt();
        
        for (int i = startValue; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("Liftoff!");
    }
}
