import java.util.*;
public class Circle{
	double radius;

	public Circle(){
	this(1.0);
	}
	
	public Circle(double radius){
	  this.radius=radius;
	}

	public void display(){
		System.out.println("Radius Of Circle:"+radius);
	}
	
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
       		double radius=sc.nextDouble();
		Circle c1=new Circle(radius);
		Circle c2=new Circle();//when no input given
		c1.display();
		c2.display();
	}
}
	

	
