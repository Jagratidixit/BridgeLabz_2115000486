import java.util.*;
public class BankAccount{
    private static String bankName="Axis Bank";
    private String accountHolderName;
    private final int  accountNumber;
    private static int totalAccounts=0;
    private double balance;
    
    public BankAccount(String accountHolderName, int accountNumber, double balance){
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        this.balance=balance;
        totalAccounts++;
    }
    
    public static int getTotalAccounts(){
        return totalAccounts;
    }
    
    public void displaydetails(){
        //Check if an account object is an instance of the BankAccount class before displaying its details
        if(this instanceof BankAccount){
            System.out.println("Bank Name :"+bankName);
            System.out.println("Account Holder Name :"+accountHolderName);
            System.out.println("Account Number:"+accountNumber);
            System.out.println("Balance:"+balance);
        }
    }
    
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        BankAccount account1=new BankAccount("Jagrati Dixit",1000345672,50000.0);
        BankAccount account2=new BankAccount("Aditi Dixit",1000345673,900000.0);
        
        account1.displaydetails();
        account2.displaydetails();
        
        System.out.println("Total Accounts:"+ getTotalAccounts());
    }

}
