import java.util.Scanner;

/**
 * driver class (test class)
 * 
 * @author LC PC
 *
 */
public class BankTest {
	static Scanner input;// static scanner object 
	/**
	 * Main method
	 * displays the menu
	 * @param args
	 */
	public static void main(String[] args) {
		// read the name of the bank and the number of accounts (stored in num). Keep in
		// mind that this number cannot be negative or 0
		input = new Scanner(System.in);
		System.out.print("Enter name of bank: ");
		String bankName = input.nextLine();
		int num=0;
		do {
			System.out.print("How many account holders do you have: ");
			try {
				num = input.nextInt();// give the size of the accounts arraylist
				input.nextLine();
				if (num <= 0) {
					System.out.println("*****Invalid number, must be greater than 0*****");
				}
			}catch(Exception e) {
				System.out.println("*****Invalid number, must be an integer*****");
				input.nextLine();
			}
		} while (num <= 0);
		Bank bank = new Bank(bankName, num);// A Bank object will be created with the name and num.
		int option = 0;
		do {
				System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n", "1.Read account", "2.Run monthly process", "3.Print all accounts",
						"4.Read data from file", "5.Write data to file","6.Exit");// Display a menu.
				System.out.print("Enter your option: ");
				if (input.hasNextInt()) {
					option = input.nextInt();
					input.nextLine();
					// switch case to handle the menu options
					switch (option) {
					case 1:// read account infomation from keyboard
						bank.readInfo(input);
						break;
					case 2:// update the balance
						bank.updateBalance();
						break;
					case 3:// print all accounts
						bank.printAll();
						break;
					case 4:// read information from a file
						bank.readFile();
						break;
					case 5:// write all accounts to a file
						bank.writeFile();
						break;
					case 6:// terminates the program
						System.out.println("Good bye");
						System.out.println("Program by Chang Liu");
						break;
					default:// print error message when have a wrong menu option
						System.out.println("*****Invalid menu oprtion, please choose from 1-6*****");
						break;
					}
				}else {
					System.out.println("*****Invalid menu option, must be an integer*****");
					input.nextLine();
				}
		} while ((option != 6));
		closeFile(); // close the file before ending the program
	}
	/**
	 * static method to close the opened file
	 */
	public static void closeFile() {
		if(input !=null) {
			input.close();
			//input = null;
		}
	}
}
