import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;

/**
 * bank class manipulate the bank accounts.
 * 
 * @author LC PC
 *
 */
public class Bank {
	// a name (String) which is the name of the bank, and an ArrayList named
	// accounts, which is an ArrayList of Account objects as instance variables.
	private static String bankName;
	private ArrayList<Account> accounts;
	private ChequingAccount c = new ChequingAccount();
	private SavingsAccount s = new SavingsAccount();

	// non-ar constructor
	Bank() {

	}

	/**
	 * parameterized constructor get the bank name and size used to create arraylist
	 * of Account type
	 * 
	 * @param bankName
	 * @param size
	 */
	Bank(String bName, int size) {
		bankName = bName;
		accounts = new ArrayList<Account>(size);
	}

	/**
	 * read account info from keyboard
	 * 
	 * @param input
	 */
	public void readInfo(Scanner input) {
		int option = 0;
		do {
			System.out.println("1. chequing");
			System.out.println("2. saving");
			System.out.print("Enter the type of account you want to create: ");
			try {
				option = input.nextInt();
				input.nextLine();
				switch (option) {
				case 1:
					c = new ChequingAccount();
					c.readInfo(input);
					accounts.add(c);
					break;
				case 2:
					s = new SavingsAccount();
					s.readInfo(input);
					accounts.add(s);
					break;
				default:
					System.out.println("*****Please choose from 1 and 2*****");
					break;
				}
			} catch (Exception e) {
				System.out.println("*****Invalid option, please enter an integer*****");
				input.nextLine();
			}
		} while ((option != 1) && (option != 2));
	}

	/**
	 * method to read file AccountsSource.txt pass the attributes to accounts
	 * arraylist object which is stored in heap memory try catch to handle
	 * exceptions returns nothing
	 */
	public void readFile() {
		try {
			Scanner input = new Scanner(Paths.get(".\\AccountsSource.txt"));
			while (input.hasNext()) {
				char type = input.next().charAt(0);
				long accNum = input.nextLong();
				String firstName = input.next();
				String lastName = input.next();
				String email = input.next();
				long phone = input.nextLong();
				double balance = input.nextDouble();
				Person accHolder = new Person(firstName, lastName, email, phone);
				Account a;
				if (type == 'C') {
					a = new ChequingAccount(accNum, accHolder, balance);
					accounts.add(a);
				} else if (type == 'S') {
					a = new SavingsAccount(accNum, accHolder, balance);
					accounts.add(a);
				}
			}
			System.out.println("*****accounts read from file*****");
		} catch (FileNotFoundException fe) {
			System.err.println("Can't find the file");
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}

	/**
	 * write the file to AccountsOutput.txt try catch to handle exceptions create
	 * the output file if it doesn't exits
	 * 
	 */
	public void writeFile() {
		File file = new File("AccountsOutput.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("*****File exits*****");
				e.printStackTrace();
			}
		}
		try {
			FileWriter writer = new FileWriter("AccountsOutput.txt");
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i) instanceof ChequingAccount) {
					writer.write("C| " + accounts.get(i).toString());
				} else if (accounts.get(i) instanceof SavingsAccount) {
					writer.write("S| " + accounts.get(i).toString());
				}
			}
			System.out.println("*****all accounts written to file*****");
			writer.close();
		} catch (IOException e) {
			System.out.println("*****Error when wrrting to file*****");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("*****Error when wrrting to file*****");
		}
	}

	/**
	 * update the balance monthly update the balance based on the account type
	 */
	public void updateBalance() {
		if (accounts.isEmpty()) {
			System.out.println("*****No account to print*****");
		} else {
			for (int i = 0; i < accounts.size(); i++) {
				c.balanceUpdate();
				s.balanceUpdate();
			}
		}

	}

	/**
	 * static methods to print stars
	 */
	public static void printStars() {
		System.out.println(
				"****************************************************************************************************");
	}

	/**
	 * method to print bank name
	 */
	public static void printBankName() {
		System.out.println("                     " + bankName.toUpperCase() + " BANK");// While printing the title, see
		// that
		// it is printed in uppercase
	}

	/**
	 * static methods to print the title,
	 */
	public static void printTitle() {
		System.out.printf(" %10s| %20s| %20s| %20s| %20s|%n", "Acc Number", "Name", "Email", "Phone", "Balance");
	}

	/**
	 * method to print account info
	 */
	public void printInfo() {
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i).toString());
		}
	}

	/**
	 * print everything including the header, bank name, and all accounts
	 */
	public void printAll() {
		if (accounts.isEmpty()) {
			System.out.println("*****No account to print*****");
		} else {
			Bank.printStars();
			Bank.printBankName();
			Bank.printStars();
			Bank.printTitle();
			Bank.printStars();
			this.printInfo();
		}

	}

}
