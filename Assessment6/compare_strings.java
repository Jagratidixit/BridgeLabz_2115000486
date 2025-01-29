
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int result=0;
        int minlength=Math.min(str1.length(),str2.length());
        
        for(int i=0;i<minlength;i++){
            if(str1.charAt(i)>str2.charAt(i)){
                result=-1;//str2 comes first
                break;
            }
            else if(str1.charAt(i)<str2.charAt(i)){
                result=1;//str1 comes first
                break;
            }
        }
        
        if(result==0){ //means str1 and str2 equal till minlength
            if(str1.length()>str2.length()){
                result=-1;
            }
            else if(str1.length()<str2.length()){
                result=1;
            }
        }
        
         if (result == 1) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (result == -1) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
    }
}
