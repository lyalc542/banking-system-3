import java.util.Scanner;

/**
 * person class contains personal attributes and methods to read personal info
 * 
 * @author LC PC
 *
 */
public class Person {
	// All personal attributes first name, last name, email, phone number
	private String firstName;
	private String lastName;
	private String email;
	private long phone;

	/**
	 * non-ar constructor
	 */
	Person() {

	}

	/**
	 * parameterized constructor
	 * 
	 * @param firstName 
	 * @param lastName
	 * @param email
	 * @param phone
	 */
	Person(String firstName, String lastName, String email, long phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * read personal info
	 * 
	 * @param input scanner input
	 */
	public void readInfo(Scanner input) {
		System.out.print("Enter first name: ");
		firstName = input.nextLine();
		System.out.print("Enter last name: ");
		lastName = input.nextLine();
		System.out.print("Enter email: ");
		email = input.next();
		input.nextLine();
		System.out.print("Enter phone number: ");
		phone = input.nextLong();
		input.nextLine();
	}

	/**
	 * getter for all the personal attributes
	 * 
	 * @return string for full name and email
	 * @return long for phone number
	 */
	public String getfullName() {
		return firstName + " " + lastName;
	}

	public String getEmail() {
		return email;
	}

	public Long getPhoneNumber() {
		return phone;
	}

}
