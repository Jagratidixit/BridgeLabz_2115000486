class Employee {
    private static String companyName = "Google";
    private String name;
    private String designation;
    private static int totalemployees=0;
    private final int id;
    

    public Employee(String name, String designation, int id) {
        this.name = name;
        this.designation = designation;
        this.id = id;
        totalemployees++;
        
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalemployees);
    }

    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Employee name: " + name);
            System.out.println("Employee Designation: " + designation);
            System.out.println("Employee Id: " + id);
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Jagrati Dixit", "Software Developer", 100023);
        Employee employee2 = new Employee("Divyanshi Dubey", "Software Analyst", 100024);
        
        employee1.displayEmployeeDetails();
        employee2.displayEmployeeDetails();
        Employee.displayTotalEmployees();
        
    }
}
