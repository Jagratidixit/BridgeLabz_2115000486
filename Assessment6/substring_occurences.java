import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();  // abababaca
        String sub = sc.nextLine();  // ab
        
        int count = 0;

        for (int i = 0; i <= str.length() - sub.length(); i++) {
            if (str.substring(i, i + sub.length()).equals(sub)) {
                count++; 
            }
        }
        
        System.out.println("Occurrences: " + count);
    }
}
