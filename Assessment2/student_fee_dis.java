import java.util.Scanner;

public class student_fee_Dis{
    public static void main(String[] args) {
        double fee, discountPercent;
        Scanner sc = new Scanner(System.in);
        
        fee = sc.nextDouble();
        discountPercent = sc.nextDouble();
        
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        
        System.out.print("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee + "\n");
    }
}


