import java.util.HashMap;
import java.util.Map;

/** Stores contacts in memory and locates them by unique contact ID. */
public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact must be non-null with a unique ID.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        requireContact(contactId);
        contacts.remove(contactId);
    }

    public Contact getContact(String contactId) {
        return requireContact(contactId);
    }

    private Contact requireContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("No contact exists for the supplied ID.");
        }
        return contact;
    }

    public void updateFirstName(String contactId, String firstName) {
        requireContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        requireContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        requireContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        requireContact(contactId).setAddress(address);
    }
}
