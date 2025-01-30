import java.util.*;
public class palindrome
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		boolean res=palindrome(s);
		if(res)
		System.out.println("String is palindrome");
		else
		System.out.println("String is not palindrome");

	}
	public static boolean palindrome(String s){
	    int i=0;
		int j=s.length()-1;
		while(i<j){
		    if(s.charAt(i)!=s.charAt(j)){
		        return false;
		    }
		    i++;
		    j--;
		}
		return true;
	}
}
