import java.util.*;

class BankAccount {
    int accountNumber;
    double balance;
    
    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    void displayBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;
    
    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    void displayAccountType() {
        System.out.println("Savings Account with Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;
    
    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    void displayAccountType() {
        System.out.println("Checking Account with Withdrawal Limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int depositTerm;
    
    FixedDepositAccount(int accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }
    
    void displayAccountType() {
        System.out.println("Fixed Deposit Account with Term: " + depositTerm + " years");
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(101, 5000, 4.5);
        CheckingAccount checking = new CheckingAccount(102, 3000, 1000);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount(103, 10000, 5);
        
        savings.displayBalance();
        savings.displayAccountType();
        
        checking.displayBalance();
        checking.displayAccountType();
        
        fixedDeposit.displayBalance();
        fixedDeposit.displayAccountType();
    }
}
