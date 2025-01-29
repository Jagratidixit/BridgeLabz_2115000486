import java.util.*;
public class Level1Q4
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the distance you have to run in meters:");
		double d=sc.nextDouble();
		System.out.print("Enter sides of triangle :");
        int l=sc.nextInt();
        int b=sc.nextInt();
        int h=sc.nextInt();
		int rounds=triangle(l,b,h,d);
        System.out.println("The athlete needs to complete " + rounds + " rounds to complete a "+d+" run.");
	}
	public static int triangle(int l,int b,int h,double d)
	{
	    int perimeter=l+b+h;
	    int round=(int) Math.ceil(d/perimeter);
	    return round;

	}
}
