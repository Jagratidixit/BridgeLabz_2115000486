import java.util.*;
public class Level1Q1
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter pricipal :");
		double P=sc.nextDouble();
		System.out.print("Enter rate :");
		int R=sc.nextInt();
		System.out.print("Enter time :");
		int T=sc.nextInt();
		double simple_interest=simple_interest(P,R,T);
		System.out.print("Simple Interest is "+simple_interest);
	}
	public static double simple_interest(double P,int R,int T)
	{
	    double simple_interest=(P*R*T)/100;
	    return simple_interest;
	}
}
