package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMainClass {
	private static Scanner sc = new Scanner(System.in);
	private AddressBook addressbook = new AddressBook();
	private List<Contacts> contacts = new ArrayList<>();
	private AddressBookMainClass addressbooks;

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program\n");

		AddressBookMainClass addressbook = new AddressBookMainClass();
		addressbook.addContacts();

	}

	public void addContacts() {

		System.out.println("Enter the First Name");
		String firstName = sc.next();

		System.out.println("Enter the Last Name");
		String lastName = sc.next();

		System.out.println("Enter the Address Name");
		String address = sc.next();

		System.out.println("Enter the City Name");
		String city = sc.next();

		System.out.println("Enter the State Name");
		String state = sc.next();

		System.out.println("Enter the Zip Name");
		int zip = sc.nextInt();

		System.out.println("Enter the PhoneNumber");
		long phoneNumber = sc.nextInt();

		System.out.println("Enter the email");
		String email = sc.next();
		Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
		contacts.add(contact);
		addressbook.setContacts(contacts);
	
	}

  public void editContact(String name, String editFirstName, String editLastName, String editAddress, String editCity,
		String editState, int editZip, long editPhoneNumber, String editEmail) {
	List<Contacts> contactDetails = addressbook.getContacts();
	for (int i = 0; i <= contactDetails.size() - 1; i++) {

		Contacts contactperson = contactDetails.get(i);
		if (contactperson.getFirstName().equals(name)) {

			contactperson.setFirstName(editFirstName);
			contactperson.setLastName(editLastName);
			contactperson.setAddress(editAddress);
			contactperson.setCity(editCity);
			contactperson.setPhoneNumber(editPhoneNumber);
			contactperson.setState(editState);
			contactperson.setZip(editZip);
			contactperson.setEmail(editEmail);
			contactDetails.set(i, contactperson);
			addressbook.setContacts(contactDetails);

		}
	}
	addressbooks.displayContacts(addressbook);
}

public void displayContacts(AddressBook addressBook) {
	List<Contacts> contactDetails = addressBook.getContacts();

	for (int i = 0; i <= contactDetails.size() - 1; i++) {
		Contacts contactperson = contactDetails.get(i);
		if (!contactperson.getFirstName().equals("")) {
			System.out.println("Conatct Details :");
			System.out.println("FirstName :" + contactperson.getFirstName() + "      LastName :"
					+ contactperson.getLastName() + "     Address :" + contactperson.getAddress() + "      City :"
					+ contactperson.getCity() + "       State :" + contactperson.getState() + "     Zip :"
					+ contactperson.getZip() + "     Phone Number :" + contactperson.getPhoneNumber());
		} else {

			System.out.println("No Conatct Details available :");
		}
	}
 }
public void deleteContactDetails(String name) {
	List<Contacts> contactDetails = addressbook.getContacts();
	for (int i = 0; i <= contactDetails.size() - 1; i++) {
		Contacts contactperson = contactDetails.get(i);
		if (contactperson.getFirstName().equals(name)) {
			contactDetails.remove(i);
			addressbook.setContacts(contactDetails);
		}
	}
	System.out.println("Contact deleted Successfully");
	addressbooks.displayContacts(addressbook);
  }
}

