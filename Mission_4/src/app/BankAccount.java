package app;

public class BankAccount {
	private String accountName;
	private String accountNum;
	private double balance;
	private boolean isOverdraftAllowed;
	private double overdraftSum;

	public BankAccount(String accountName, String accountNum, double balance, boolean isOverdraftAllowed,
			double overdraftSum) {
		this.accountName = accountName;
		this.accountNum = accountNum;
		this.balance = balance;
		this.isOverdraftAllowed = isOverdraftAllowed;
		this.overdraftSum = overdraftSum;
	}

	public BankAccount() {
		this("Account", "000001", 0, false, 0);
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean getIsOverdraftAllowed() {
		return isOverdraftAllowed;
	}

	public void setIsOverdraftAllowed(boolean isOverdraftAllowed) {
		this.isOverdraftAllowed = isOverdraftAllowed;
	}

	public void setOverdraftAllowed(boolean isOverdraftAllowed) {
		this.isOverdraftAllowed = isOverdraftAllowed;
	}

	public double getOverdraftSum() {
		return overdraftSum;
	}

	public void setOverdraftSum(double overdraftSum) {
		this.overdraftSum = overdraftSum;
	}

	public void deposit(double deposit) {
		// TODO - Check what to do if negative
		if (deposit > 0) {
			balance += deposit;
		}
	}

	public double withdrawal(double withdrawAmount) {
		// TODO - Check what to do if negative
		double actualWithdraw;
		double totalBalance;
		if (isOverdraftAllowed) {
			totalBalance = balance + overdraftSum;
		} else {
			totalBalance = balance;
		}
		actualWithdraw = Math.min(withdrawAmount, totalBalance);
		balance -= actualWithdraw;
		return actualWithdraw;
	}

	@Override
	public String toString() {
		return String.format("Account name: %s\nAccount number: %s\nBalance: %f", accountName, accountNum, balance);
	}

}