import java.util.*;
class Bank{
    String name;
    List<Account> bankAccounts;
    
    // Bank class mein, accounts ko constructor mein parameter ke roop mein pass karne ki zarurat nahi hai kyunki accounts list ko constructor ke andar hi new ArrayList<>() se initialize kiya ja raha hai.
    Bank(String name){
        this.name=name;
        this.bankAccounts=new ArrayList<>();
    }
    
    void openAccount(Customer customer,double balance,int accountNumber){
        Account account=new Account(customer,balance,accountNumber);
        bankAccounts.add(account);
        customer.addAccount(account);
    }
    
    void showAccounts(){
        System.out.println("Bank :"+name);
        for(Account acc:bankAccounts){
            acc.display();
        }
    }
}

class Account{
    Customer customer;//to access customer name 
    int accountNumber;
    double balance;
    Account( Customer customer,double balance,int accountNumber){
        this.customer=customer;
        this.balance=balance;
        this.accountNumber=accountNumber;
    }
    
    void display(){
        System.out.println("Customer name:"+customer.name);
        System.out.println("Account Number:"+accountNumber);
        System.out.println("Balance:$"+balance);
      
    }
}

class Customer{
    String name;
    //Customer reference was missing in Account class.
    //Fix: Added a Customer customer; field and initialized it in the constructor.
    //A Customer can have multiple accounts.so we need accounts
    List<Account> customerAccounts;
    
    Customer(String name){
        this.name=name;
        this.accounts=new ArrayList<>();
    }
    
    void addAccount(Account account){
        customerAccounts.add(account);
    }
    
    void viewBalance(){
        for(Account acc:customerAccounts){
            System.out.println("Balance for " + acc.accountNumber + ": $" + acc.balance);
        }

    }
}
public class Main
{
	public static void main(String[] args) {
		Bank b1=new Bank("Axis Bank");
		Bank b2=new Bank("HDFC Bank");
		
		Customer customer1=new Customer("Jagrati");
		Customer customer2=new Customer("Aditi");
		
	    //Account k alag object nhi banega vo Bank mein hi call ho gaya.
	    b1.openAccount(customer1,8000,101);
	    b2.openAccount(customer2,9000,102);
	    
	    b1.showAccounts();
          b2.showAccounts();
        
          customer1.viewBalance();
          customer2.viewBalance();
	  
		
		
	}
}
