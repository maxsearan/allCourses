package diet;

import java.util.ArrayList;
import java.util.*;

/* Laurian Staicu 1696177
 * IPD 9 
 */
class Account {

    private String mName;
    private int mId;
    private double mBalance;
    private double mAnnualInterestRate; // AnnualInterestRate is percentage.
    private Date mDateCreated;
    private ArrayList<Transaction> mTransactions;

    @Override
    public String toString() {
        return "Account{" + "mName=" + mName + ", mId=" + mId + ", mBalance=" + mBalance + ", mAnnualInterestRate=" + mAnnualInterestRate + ", mDateCreated=" + mDateCreated + ", mTransactions=" + mTransactions + '}';
    }

    public Account(String mName, double mBalance, double mAnnualInterestRate) {
        this.mName = mName;
        this.mBalance = mBalance;
        this.mAnnualInterestRate = mAnnualInterestRate;
         this.mDateCreated = new Date();
        
    }
    
    
    

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public double getmBalance() {
        return mBalance;
    }

    public void setmBalance(double mBalance) {
        this.mBalance = mBalance;
    }

    public double getmAnnualInterestRate() {
        return mAnnualInterestRate;
    }

    public void setmAnnualInterestRate(double mAnnualInterestRate) {
        this.mAnnualInterestRate = mAnnualInterestRate;
    }

    public Date getmDateCreated() {
        return mDateCreated;
    }

    public void setmDateCreated(Date mDateCreated) {
        this.mDateCreated = mDateCreated;
    }

    public ArrayList<Transaction> getmTransactions() {
        return mTransactions;
    }

    public void setmTransactions(ArrayList<Transaction> mTransactions) {
        this.mTransactions = mTransactions;
    }
    
    
    public void addTransaction(double amount){
        this.mTransactions.add(new Transaction(amount));
    }
    
    
    
}

class Transaction {
	// Data fields
	private java.util.Date date;
	private char type;

    public void Transaction(double amount) {
        this.date = new Date();
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "date=" + date + ", type=" + type + ", amount=" + amount + ", balance=" + balance + ", description=" + description + '}';
    }
	private double amount;
	private double balance;
	private String description;

    public Transaction(Date date, char type, double amount, double balance, String description) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Transaction( double amount) {
        this.date = new Date();
        this.amount = amount;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
}

public class Diet {


    public static void main(String[] args) {
         Account account = new Account("George", 1122, 1000);
        System.out.println(account.toString());
       account.addTransaction(56);
            
       
       
       
       
    }

}
