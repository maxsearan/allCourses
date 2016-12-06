package ex118accounts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*A private int data field named id for the account (default 0).
■ A private double data field named balance for the account (default 0).
■ AprivatedoubledatafieldnamedannualInterestRatethatstoresthecur-
rent interest rate (default 0). Assume all accounts have the same interest rate.
■ A private Date data field named dateCreated that stores the date when the
account was created.

/* Laurian Staicu 1696177
 * IPD 9 
 */
class Account {

    private ArrayList<Transaction> transactions;
    private String name;
    private int ID;
    static double balance = 0.0;
    private double annualInterestRate;
    private Date dateCreated;

    public Account(String name, int ID, double balance, double annualInterestRate, Date dateCreated) {
        this.name = name;
        this.ID = ID;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = dateCreated;
    }

    //ArrayList<Transaction> transactions = new ArrayList<>();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void getTransactions() {
        for (int i = 0; i < this.transactions.size(); i++) {

            System.out.println(transactions.get(i).toString());
        }
    }

    public void setTransactions(ArrayList<Transaction> transactions) throws ParseException {
        Date dateCreated;
        double amount;
        double balance;
        String description;
        Scanner input = new Scanner(System.in);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("enter transaction date yyyy/MM/dd");
        String dateS = input.nextLine();
        dateCreated = formatter.parse(dateS);

        System.out.println("enter amount");
        amount = input.nextDouble();
        input.nextLine();

        System.out.println("enter balance");
        balance = input.nextDouble();
        input.nextLine();

        System.out.println("enter balance");
        description = input.nextLine();

        Transaction t = new Transaction(dateCreated, amount, balance, description);
        this.transactions.add(t);
        System.out.println(t.getBalance());
    }

}

class Transaction {

    private Date date;
    private double amount;
    private double balance;
    private String description;

    //Transaction(type: char, amount: double, balance: double, description: String)
    public Transaction(Date date, double amount, double balance, String description) {
        setDate(date);
        setAmount(amount);
        setAmount(balance);
        setDescription(description);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

public class Ex118Accounts {

    public static void main(String[] args) {
        Account account;
        Date date;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = formatter.parse("2012/02/12");

            account = new Account("Larry", 34, 5000, 2, date);
            System.out.println(account.getID());

        } catch (ParseException ex) {
            System.out.println("cant create an account");
        }
    }

}
