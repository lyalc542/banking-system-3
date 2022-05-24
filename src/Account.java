import java.util.Scanner;


/**
 * abstract class account implements policies and extended by ChequingAccount and
 * SavingAccount classes
 * 
 * @author LC PC
 *
 */
public abstract class Account implements Policies {
	//instance variables to represent account number, the account holder (Person object), and the balance.
	protected long accNum;
	protected Person accHolder = new Person();
	protected double balance;
	/**
	 * non-ar constructor
	 */
	Account(){

	}
	/**
	 * 
	 * parameterized constructor
	 * 
	 * @param accNum takes account number
	 * @param accHolder Person object account holder
	 * @param balance account balance
	 */
	Account(long accNum, Person accHolder,double balance) {
		this.accHolder = accHolder;
		this.accNum = accNum;
		this.balance = balance;
	}

	/**
	 * read account info from keyboard
	 * 
	 * @param input scanner input from keyboard
	 */
	protected void readInfo(Scanner input) {
		System.out.print("Enter account number: ");
		accNum = input.nextLong();
		input.nextLine();
		accHolder.readInfo(input);
		do {
			System.out.print("Enter balance: ");
			balance = input.nextDouble();
			input.nextLine();
			if (balance < 0) {
				System.out.println("Balance can't be negative!");
			}
		} while (balance < 0);
	}

	/**
	 * abstract method specified in subclasses
	 */
	protected abstract void balanceUpdate();

	/**
	 * print all personal attributes and account info
	 * @Override toString() method
	 * @return String formatted example output
	 * 
	 */
	@Override
	public String toString() {

		return String.format(" %10d| %20s| %20s| %20d| %20.2f|%n", this.accNum, accHolder.getfullName(),
				accHolder.getEmail(), accHolder.getPhoneNumber(), this.balance);
	}


}
