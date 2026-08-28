import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
public class ContactTest { 

    private final static String NAME = "Ada Lovelace";
    private final static String PHONE = "+1 617 555 1212";
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact(NAME, PHONE);
    } 

    @Test 
    void constructor_setsNameCorrectly() { 
        assertEquals(NAME, contact.getName()); 
    } 
 
    @Test
    void constructor_setsPhoneCorrectly() { 
        assertEquals(PHONE, contact.getPhone()); 
    } 
 
    @Test
    void getName_returnsExactString_notTransformed() { 
        assertEquals(NAME, contact.getName());
    } 
 
    @Test
    void toString_containsName() { 
        assertTrue(contact.toString().contains(NAME));
    } 
 
    @Test
    void toString_containsPhone() {
        assertTrue(contact.toString().contains(PHONE));
    }

    @Test
    void toString_sameOutputForDifferentContacts() {
        Contact otherContact = new Contact(NAME, PHONE);
        assertTrue(contact.toString().equals(otherContact.toString()));
    }
} 