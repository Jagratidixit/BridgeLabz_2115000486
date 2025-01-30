import java.util.*;
public class vowels_consonents
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next().toLowerCase();
		int vowels=0;
		int consonants=0;
		
		for(int i=0;i<s.length();i++){
		    char ch=s.charAt(i);
		     if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
		}
		System.out.println("Vowels are:"+vowels);
		System.out.println("Consonents are:"+consonants);
	}
}

