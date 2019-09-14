package app;

public class TestBankAccount {
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount("David", "12345", 50, false, 20);
		System.out.println(bankAccount);
		System.out.println();
		System.out.println(bankAccount.withdrawal(20));
		System.out.println();
		System.out.println(bankAccount);
	}
}