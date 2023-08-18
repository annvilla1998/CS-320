
import java.util.*;

public class Contact {
	String contactID;
	
	String firstName;
	String lastName;
	String phone;
	String address;
	
	
	public Contact (String contactID, String firstName, String lastName, String phone, String address) throws Exception {

				
		if(contactID == null || firstName == null || lastName == null || phone == null || address == null) {
			throw new Exception("Please fill out all fields.");
		}
		if(contactID.length() > 10) {
			throw new Exception("Contact ID needs to be shorter than 10 characters.");
		}
		if(firstName.length() > 10) {
			throw new Exception("First name needs to be shorter than 10 characters.");
		}
		if(lastName.length() > 10) {
			throw new Exception("Last name needs to be shorter than 10 characters.");
		}
		if(phone.length() != 10) {
			throw new Exception("Phone number needs to be exactly 10 numbers.");
		}
		if(address.length() > 30) {
			throw new Exception("Address needs to be shorter than 30 characters.");
		}
		
		// Check that phone digits are numbers
		for(char num: phone.toCharArray()) {
			if(!Character.isDigit(num)) {
				throw new Exception("Phone number needs to be all digits.");
			}
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public void setFirstName(String firstName) throws Exception {
		if(firstName.length() > 10) {
			throw new Exception("First name needs to be shorter than 10 characters.");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) throws Exception {
		if(lastName.length() > 10) {
			throw new Exception("Last name needs to be shorter than 10 characters.");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) throws Exception {
		if(phone.length() != 10) {
			throw new Exception("Phone number needs to be exactly 10 numbers.");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) throws Exception {
		if(address.length() > 30) {
			throw new Exception("Address needs to be shorter than 30 characters.");
		}
		this.address = address;
	}
	
	public String getID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}
	
}




