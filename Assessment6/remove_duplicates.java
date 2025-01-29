import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String str="";
		for(int i=0;i<s.length();i++){
		    char ch=s.charAt(i);
		    if(str.indexOf(ch)==-1){//str.indexOf(ch) returns the index of the first occurrence of ch in str.
                                   //If ch is not found, it returns -1.
                                  //When indexOf(ch) == -1, it means ch is not yet added to str, so we append it.
		        str=str+ch;
		    }
		}
		
		System.out.print("Modified string: "+str);
	}
}
