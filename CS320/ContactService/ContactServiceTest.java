import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("ID1", "Eddie", "Loya", "5055551234", "1 Main Street");
        service.addContact(contact);
    }

    @Test
    void addsContactsWithDistinctIds() {
        Contact second = new Contact("ID2", "Ada", "Lovelace", "5055559876", "2 Main Street");
        service.addContact(second);
        assertSame(contact, service.getContact("ID1"));
        assertSame(second, service.getContact("ID2"));
    }

    @Test
    void rejectsNullAndDuplicateContacts() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
        assertThrows(IllegalArgumentException.class, () -> service.addContact(
                new Contact("ID1", "Ada", "Lovelace", "5055559876", "2 Main Street")));
        assertSame(contact, service.getContact("ID1"));
    }

    @Test
    void deletesContactByIdAndRejectsUnknownId() {
        service.deleteContact("ID1");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("ID1"));
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("ID1"));
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
    }

    @Test
    void updatesAllPermittedFieldsByContactId() {
        service.updateFirstName("ID1", "Eddie");
        service.updateLastName("ID1", "Lopez");
        service.updatePhone("ID1", "5055559999");
        service.updateAddress("ID1", "2 Main Street");
        assertEquals("ID1", contact.getContactId());
        assertEquals("Eddie", contact.getFirstName());
        assertEquals("Lopez", contact.getLastName());
        assertEquals("5055559999", contact.getPhone());
        assertEquals("2 Main Street", contact.getAddress());
    }

    @Test
    void rejectsInvalidUpdatesAndUnknownContactIds() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("ID1", "12345678901"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateLastName("ID1", null));
        assertThrows(IllegalArgumentException.class,
                () -> service.updatePhone("ID1", "555"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateAddress("ID1", "1234567890123456789012345678901"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("UNKNOWN", "Name"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateLastName(null, "Name"));
    }
}
