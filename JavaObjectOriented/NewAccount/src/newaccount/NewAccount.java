package newaccount;

/* Laurian Staicu 1696177
 * IPD 9 
 */
import java.util.ArrayList;
import java.util.Date;

 class Account {

    protected String mName;
    protected int mId;
    protected double mBalance;
    protected double mAnnualInterestRate; // AnnualInterestRate is percentage.
    protected Date mDateCreated;
    protected ArrayList<Transaction> mTransactions;


    public Account() {
        mDateCreated = new Date();
        mTransactions = new ArrayList<>();
    }

    public Account(int id, double balance) {
        this();
        mId = id;
        mBalance = balance;
    }

    public Account(String name, int id, double balance) {
        this(id, balance);
        mName = name;

    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public double getBalance() {
        return mBalance;
    }

    public void setBalance(double balance) {
        mBalance = balance;
    }

    public double getAnnualInterestRate() {
        return mAnnualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        mAnnualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return mDateCreated;
    }

    public double getMonthlyInterestRate() {
        return mBalance * (mAnnualInterestRate / 12) / 100;
    }

    public void withdraw(double amount) {
        mTransactions.add(new Transaction('W', amount, mBalance, "withdraw"));
        mBalance -= amount;
    }

    public void deposit(double amount) {
        mTransactions.add(new Transaction('D', amount, mBalance, "deposit"));
        mBalance += amount;
    }

    @Override
    public String toString() {
        return "Account name: " + mName + "\n" + "Interest rate: " + mAnnualInterestRate + "\n" + mTransactions;
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(mTransactions);
    }

}
 class Transaction {
	// Data fields
	private java.util.Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;

	// Constructors
	/** Constructs a Transaction with specified 
	  * date, type, balance and description */
	public Transaction(char type, double amount, 
		double balance, String description) {
		date = new java.util.Date();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
	}

	// Methods
	/** getDate */
	public String getDate() {
		return date.toString();
	}
	/** Set a new type */
	public void setType(char type) {
		this.type = type;
	}

	/** Return type */
	public char getType() {
		return type;
	}

	/** Set new amount */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/** Return amount */
	public double getAmount() {
		return amount;
	}

	/** Set a new balance */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/** Return balance */
	public double getBalance() {
		return balance;
	}

	/** Set a new description */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Return description */
	public String getDescription() {
		return description;
	}
}
public class NewAccount {

      

    public static void main(String[] args) {
         Account account = new Account("George", 1122, 1000);
        account.setAnnualInterestRate(1.5);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);
        System.out.println(account);
    }

}
