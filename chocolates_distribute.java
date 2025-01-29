import java.util.Scanner;

public class Level1Q10 {
    public static int[] chocolates(int chocolates, int children) {
        int eachChildGets = chocolates / children;
        int remainingChocolates = chocolates % children;
        return new int[]{eachChildGets, remainingChocolates};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of chocolates: ");
        int chocolates = scanner.nextInt();
        System.out.print("Enter the number of children: ");
        int children = scanner.nextInt();

        int[] result = chocolates(chocolates, children);
        System.out.println("Each child gets: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
    }
}
