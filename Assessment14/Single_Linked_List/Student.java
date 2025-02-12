class StudentNode {
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    private StudentNode head;

    void addStudentAtBegin(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void addStudentAtPos(int rollNumber, String name, int age, char grade, int position) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        StudentNode temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteStudent(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    StudentNode searchStudent(int rollNumber) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateGrade(int rollNumber, char newGrade) {
        StudentNode temp = searchStudent(rollNumber);
        if (temp != null) temp.grade = newGrade;
    }

    void displayStudents() {
        StudentNode temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.addStudentAtBegin(1, "Jagrati", 20, 'A');
        list.addStudentAtEnd(2, "Aditi", 21, 'B');
        list.addStudentAtPos(3, "Vishesh", 22, 'C', 2);
        list.displayStudents();
        list.updateGrade(2, 'A');
        list.deleteStudent(1);
        System.out.println("After updates:");
        list.displayStudents();
    }
}
