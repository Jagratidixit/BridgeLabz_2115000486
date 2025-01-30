import java.util.*;
public class Employee{
	String name;
	int id;
	double salary;
	
	//constructor
	public Employee(String name,int id,double salary){
	  this.name=name;
	  this.id=id;
	  this.salary=salary;
	}
	public void display(){
	 System.out.println("Employee name: "+name);
	 System.out.println("Employee id: "+id);
	 System.out.println("Employee salary: "+salary);
	}
	public static void main(String[] args){
		Employee employee1=new Employee("Jagrati Dixit",2115000486,50000);
		employee1.display();
}

}

