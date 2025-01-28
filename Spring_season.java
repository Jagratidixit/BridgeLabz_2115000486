import java.util.*;
public class Level1Q6
{
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
        System.out.print("Enter month :");
        int month=sc.nextInt();
        System.out.print("Enter day :");
        int day=sc.nextInt();
        boolean res=spring(month,day);
        if(res){
            System.out.print("Its Spring season");
        }
        else{
            System.out.print("not a Spring season");
        }
	}
	public static boolean spring(int month,int day){
	    if((month == 3 && day >= 20 && day <= 31) ||
            (month == 4 && day >= 1 && day <= 30) ||
            (month == 5 && day >= 1 && day <= 31) ||
            (month == 6 && day >= 1 && day <= 20)) {
	        return true;
	    }
	    else{
	        return false;
	    }
	}
}
