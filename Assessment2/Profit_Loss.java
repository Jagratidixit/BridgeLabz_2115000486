public class profit_Loss_Calc {
    public static void main(String[] args) {
        double costPrice = 129, sellingPrice = 191;
        double result = sellingPrice - costPrice;
        double percentage = (Math.abs(result) / costPrice) * 100;
        if (result > 0) {
            System.out.println("Profit: INR " + result + ", Percentage: " + percentage + "%");
        } else if (result < 0) {
            System.out.println("Loss: INR " + (-result) + ", Percentage: " + percentage + "%");
        } else {
            System.out.println("No profit, no loss");
        }
    }
}

