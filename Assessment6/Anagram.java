import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (str1.length() != str2.length()) {
            System.out.println("Both strings are not anagrams");
            return;
        }
        
        int[] freq = new int[256];  
        
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i)]++;
            freq[str2.charAt(i)]--;
        }
        
        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                System.out.println("Both strings are not anagrams");
                return;
            }
        }
        
        System.out.println("Both strings are anagrams");
    }
}
