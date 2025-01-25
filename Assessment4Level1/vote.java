import java.util.*;
public class Level1Q1{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int arr[]=new int[10];
	for(int i=0;i<arr.length;i++){
		System.out.print("Enter your age: ");
		arr[i]=sc.nextInt();
		if(arr[i]<0){
			System.err.println("Inavalid Age");
			System.exit(0);
		}
		if(arr[i]>=18){
			System.out.println("The Student with the age "+arr[i]+" can vote");
		}
		else{
			System.out.println("The student with the age "+arr[i]+" cannot vote");
		}
	}
}
}
									
