
import java.util.ArrayList;

public class ContactService {
	private ArrayList<Contact> contacts;
	
	public ContactService() {
		contacts = new ArrayList<>();
	}
	
	public boolean addContact(Contact contact) {
		boolean contactExists = false;
		
		for(Contact currContact:contacts) {
			if(currContact.getID().equals(contact.getID())) {
				contactExists = true;
			}
		}
		if(!contactExists) {
			contacts.add(contact);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteContact(String contactID) {
		for(Contact currContact: contacts) {
			if(currContact.getID().equals(contactID)) {
				contacts.remove(currContact);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) throws Exception {
		for(Contact currContact:contacts) {
			if(currContact.getID().equals(contactID)) {
				if(!firstName.equals("") && !(firstName.length() > 10)) {
					currContact.setFirstName(firstName);
				}
				if(!lastName.equals("") && !(lastName.length() > 10)) {
					currContact.setLastName(lastName);
				}
				if(!phone.equals("") && (phone.length() == 10)) {
					currContact.setPhone(phone);
				}
				if(!address.equals("") && !(address.length() > 30)) {
					currContact.setAddress(address);
				}
				return true;
			}
		}
		return false;
	}
}
