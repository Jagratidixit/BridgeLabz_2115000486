import java.util.*;

public class togglecase_characters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newstr = "";
        
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                newstr = newstr + Character.toUpperCase(str.charAt(i));
            } else {
                newstr = newstr + Character.toLowerCase(str.charAt(i));
            }
        }
        
        System.out.println("Modified String: " + newstr);
    }
}
