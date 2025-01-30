import java.util.*;
public class reverse
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String newstring="";
		int i=s.length()-1;
		while(i>=0){
		    newstring=newstring+s.charAt(i);
		    i--;
		}
		System.out.println("Reversed String is:"+newstring);

	}
}
