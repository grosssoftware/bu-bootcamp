import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        String name = "Alice Abercrombie";
        contacts.put(name, new Contact(name, "+1 617 555 1111"));
        name = "Bob Barker";
        contacts.put(name, new Contact(name, "+1 617 555 2222"));
        name = "Charlie Chaplin";
        contacts.put(name, new Contact(name, "+1 617 555 3333"));
        name = "Dom DeLouise";
        contacts.put(name, new Contact(name, "+1 617 555 4444"));
        name = "Eddy Einstein";
        contacts.put(name, new Contact(name, "+1 617 555 5555"));
 
        // Step 5: look up a contact 
        String lookup = "Bob Barker";
        printContact(contacts.get(lookup));
        lookup = null;
        printContact(contacts.get(lookup));
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("=== All Contacts ===");
        for (Contact contact : sorted) {
            printContact(contact);
        }
    } 

    public static void printContact(Contact contact) {
        if (contact != null) {
            System.out.println(contact);
        }
        else {
            System.out.println("Contact not found");
        }
    }
}