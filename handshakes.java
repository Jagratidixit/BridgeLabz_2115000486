import java.util.*;
public class Level1Q2
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of students :");
        int n=sc.nextInt();
		int handshakes=handshakes(n);
		System.out.print("Total handshakes are "+handshakes);
	}
	public static int handshakes(int n)
	{
	    int handshakes=(n * (n - 1)) / 2;
	    return handshakes;
	}
}
