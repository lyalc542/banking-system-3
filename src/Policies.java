/**
 * interface policies stores some constants like a fee for the Chequing account
 * ($13.50) and a yearly interest rate for the Savings account (3.99%)
 * 
 * @author LC PC
 *
 */
public interface Policies {
	// final variables, can't be changed in other classes
	final static double FEE = 13.50;// chequing account fee
	final static double YRATE = 3.99 / 100;// saving account yearly rate
}
