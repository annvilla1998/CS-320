import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ContactTest {
	
	@Test
	public void testCreateContact() throws Exception {
		Contact contact1 = new Contact("12345", "Anabel", "Villalobo", "1234567890", "1234 Street");
		assertNotNull(contact1);
	
		// Shorter than 10 characters
		assertEquals(contact1.getID(), "12345");
		
		// Shorter than 10 characters
		assertEquals(contact1.getFirstName(), "Anabel");
		
		// Shorter than 10 characters
		assertEquals(contact1.getLastName(), "Villalobo");
		
		// Exactly 10 characters
		assertEquals(contact1.getPhone(), "1234567890");
		
		// Shorter than 30 characters
		assertEquals(contact1.getAddress(), "1234 Street");
		
		
		Contact contact2 = new Contact("1234567890", "Anabelllll", "Villalobos", "1234567890", "This is 30 characters long ");
		assertNotNull(contact2);
		
		// Exactly 10 characters
		assertEquals(contact2.getID(), "1234567890");
		
		// Exactly 10 characters
		assertEquals(contact2.getFirstName(), "Anabelllll");
		
		// Exactly 10 characters
		assertEquals(contact2.getLastName(), "Villalobos");
		
		// Exactly 10 characters
		assertEquals(contact2.getPhone(), "1234567890");
		
		// Exactly 30 characters
		assertEquals(contact2.getAddress(), "This is 30 characters long ");
	}
	
	@Test 
	public void testNullId() {
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact(null, "Anabel", "Villalobos", "1234567890", "1234 Street");
		});
	}
	
	@Test 
	public void testNullFirstName() {
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact("12345", null, "Villalobos", "1234567890", "1234 Street");
		});
	}
	
	@Test 
	public void testNullLastName() {
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact("12345", "Anabel", null, "1234567890", "1234 Street");
		});
	}
	
	@Test 
	public void testNullPhone() {
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact("12345", "Anabel", "Villalobos", null, "1234 Street");
		});
	}
	
	@Test 
	public void testNullAddress() {
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact("12345", "Anabel", "Villalobos", "1234567890", null);
		});
	}
	
	@Test
	public void testLongID() {
		// Longer than 10 characters
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact("12345678910", "Anabel", "Villalobos", "1234567890", "1234 Street");
		});
	}
	
	@Test 
	public void testLongFirstName() throws Exception {
		// Longer than 10 characters
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact("12345", "Really long first name", "Villalobos", "1234567890", "1234 Street");
		});
		
		// Test setter
		Contact contact = new Contact("12345", "Anabel", "Villalobos", "1234567890", "1234 Street");
		Assertions.assertThrows(Exception.class, () -> {
			contact.setFirstName("Really long first name");
		});
	}
	
	
	@Test 
	public void testLongLastName() throws Exception {
		// Longer than 10 characters
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact("12345", "Anabel", "Really long last name", "1234567890", "1234 Street");
		});
		
		// Test setter
		Contact contact = new Contact("12345", "Anabel", "Villalobos", "1234567890", "1234 Street");
		Assertions.assertThrows(Exception.class, () -> {
			contact.setLastName("Really long last name");
		});
	}
	
	@Test 
	public void testPhoneNotTenDigits () throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			//Too Short
			Contact contact = new Contact("12345", "Anabel", "Villalobos", "123456789", "1234 Street");
		});
		Assertions.assertThrows(Exception.class, () -> {
			//Too Long
			Contact contact = new Contact("12345", "Anabel", "Villalobos", "12345678901", "1234 Street");
		});
		
		
		// Test setter
		Contact contact = new Contact("12345", "Anabel", "Villalobos", "1234567890", "1234 Street");
		Assertions.assertThrows(Exception.class, () -> {
			// Too short
			contact.setPhone("123456789");
		});
		Assertions.assertThrows(Exception.class, () -> {
			// Too long
			contact.setPhone("12345678901");
		});
	}
	
	@Test 
	public void testLongAddress () throws Exception {
		// Longer than 30 characters
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact("12345", "Anabel", "Villalobos", "1234567890", "Really long street address that should error out");
		});
		
		// Test setter
		Contact contact = new Contact("12345", "Anabel", "Villalobos", "1234567890", "1234 Street");
		Assertions.assertThrows(Exception.class, () -> {
			contact.setAddress("Really long street address that should error out");
		});
	}

	@Test
	public void testPhoneIsDigits () throws Exception {
		// Non digit number
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact1 = new Contact("12345", "Anabel", "Villalobo", "1234b67890", "1234 Street");
		});		
	}
}


