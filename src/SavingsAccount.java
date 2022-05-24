/**
 * extends Account
 * 
 * @author LC PC
 *
 */
public class SavingsAccount extends Account {
// non-ar constructor
	SavingsAccount() {

	}
	/**
	 * overloaded constructor
	 * @param accNum
	 * @param accHolder
	 * @param balance
	 */
	SavingsAccount(long accNum,Person accHolder,double balance){
		this.accHolder = accHolder;
		this.accNum = accNum;
		this.balance = balance;
	}

	/**
	 * update the balance override abstract method
	 * 
	 * @Override
	 */
	public void balanceUpdate() {
		double mRate = balance * YRATE / 12;
		balance += mRate;
	}

}
