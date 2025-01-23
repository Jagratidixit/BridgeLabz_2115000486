public class Course_Fee_Dis {
    public static void main(String[] args) {
        double courseFee = 125000;
        double discountRate = 10;
        double discountAmount = (courseFee * discountRate) / 100;
        double discountedPrice = courseFee - discountAmount;
        System.out.print("Discounted amount: INR " + discountAmount + "\n");
        System.out.print("Discounted price: INR " + discountedPrice + "\n");
    }
}

