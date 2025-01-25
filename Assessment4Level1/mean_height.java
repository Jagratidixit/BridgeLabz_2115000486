import java.util.Scanner;

public class Level1Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0;
        System.out.println("Enter heights of 11 players:");
        for (int i = 0; i < 11; i++) 
	sum += heights[i] = sc.nextDouble();
        System.out.println("Mean height: " + (sum / 11));
    }
}
