import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Holder: " + holderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Earned: " + calculateInterest());
    }
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02;
    private static final double MIN_BALANCE_FOR_LOAN = 5000;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for " + getHolderName());
        } else {
            System.out.println("Loan application denied due to low balance.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= MIN_BALANCE_FOR_LOAN;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Loan Eligibility: " + (calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("575440", "A", 20000));
        accounts.add(new CurrentAccount("585441", "B", 6000));
        accounts.add(new CurrentAccount("658415", "C", 3000));

        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println();
        }

        for (BankAccount account : accounts) {
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(10000);
                System.out.println();
            }
        }
    }
}
