import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ContactServiceTest {
	private ContactService cs;
	
	@Before
	public void run() {
		cs = new ContactService();
	}
	
	@Test
	public void testAdd() throws Exception {
		Contact contact1 = new Contact("12345", "Anabel", "Villa", "7601112432", "10023 Maple rd");
		assertEquals(true,cs.addContact(contact1));
	}
	
	@Test
	public void testDuplicateContact() throws Exception {
		Contact contact1 = new Contact("12345", "Anabel", "Villa", "7601112432", "10023 Maple rd");
		Contact contact2 = new Contact("12345", "Anabel", "Villa", "7601112432", "10023 Maple rd");
		cs.addContact(contact1);
		assertFalse(cs.addContact(contact2));
	}
	
	
	@Test
	public void testDelete() throws Exception {
		Contact contact1 = new Contact("12345", "Anabel", "Villalobos", "1234567890", "1234 Street");
		Contact contact2 = new Contact("12333", "Anthony", "Sieber", "7601167643", "10023 Maple rd");
		Contact contact3 = new Contact("56789", "Khalea", "Castillo", "7603434793", "9290 A ave");
		
		cs.addContact(contact1);
		cs.addContact(contact2);
		cs.addContact(contact3);
		
		assertEquals(true, cs.deleteContact(contact1.getID()));
	}
	
	@Test
	public void testDeleteNonExistentContact() {
		assertEquals(false, cs.deleteContact("29437"));
		assertEquals(false, cs.deleteContact("48576"));
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Contact contact1 = new Contact("12345", "Anabel", "Villa", "7601112432", "10023 Maple rd");
		Contact contact2 = new Contact("12333", "Anthony", "Sieber", "7601167643", "10023 Maple rd");
		Contact contact3 = new Contact("56789", "Khalea", "Castillo", "7603434793", "9290 A ave");
		
		cs.addContact(contact1);
		cs.addContact(contact2);
		cs.addContact(contact3);
		
		assertEquals(true, cs.updateContact(contact3.getID(), "Cali", "Castilla", "", ""));
	}
	
	@Test
	public void testUpdateNonExistentContact() throws Exception {
		assertEquals(false, cs.updateContact("48576", "Cali", "Castilla", "", ""));
	}
	
}
