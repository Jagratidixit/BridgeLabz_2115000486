import java.util.*;

class BankingSystem {
    Map<Integer, Double> accounts = new HashMap<>();
    TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            sortedAccounts.remove(accounts.get(accountNumber));
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        }
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for Account: " + accountNumber);
        }
    }

    public void displayAccounts() {
        System.out.println("Accounts (Unordered): " + accounts);
        System.out.println("Accounts Sorted by Balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount(1001, 5000.0);
        bank.createAccount(1002, 3000.0);
        bank.createAccount(1003, 7000.0);

        bank.deposit(1001, 2000.0);
        bank.requestWithdrawal(1002);
        bank.requestWithdrawal(1003);

        bank.displayAccounts();
        bank.processWithdrawals();
    }
}
