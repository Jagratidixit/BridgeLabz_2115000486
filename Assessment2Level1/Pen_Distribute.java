public class pen_Distribute {
    public static void main(String[] args) {
        int pens = 14;
        int students = 3;
        int pensPerStudent = pens / students;
        int remainingPens = pens % students;
        System.out.println("Each student gets " + pensPerStudent + " pens.");
        System.out.println("Remaining pens: " + remainingPens);
    }
}

