import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

class ContactTest {
    private static Contact validContact() {
        return new Contact("ID1", "Eddie", "Loya", "5055551234", "1 Main Street");
    }

    @Test
    void constructorStoresValidFieldsAtBoundaries() {
        Contact contact = new Contact("1234567890", "1234567890", "1234567890",
                "0123456789", "123456789012345678901234567890");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("1234567890", contact.getFirstName());
        assertEquals("1234567890", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }

    @Test
    void constructorRejectsNullFields() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Eddie", "Loya", "5055551234", "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", null, "Loya", "5055551234", "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "Eddie", null, "5055551234", "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "Eddie", "Loya", null, "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "Eddie", "Loya", "5055551234", null));
    }

    @Test
    void constructorRejectsValuesOutsideLengthAndPhoneRules() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "Eddie", "Loya", "5055551234", "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "12345678901", "Loya", "5055551234", "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "Eddie", "12345678901", "5055551234", "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "Eddie", "Loya", "123456789", "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "Eddie", "Loya", "12345678901", "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "Eddie", "Loya", "505-551234", "Address"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "Eddie", "Loya", "5055551234",
                        "1234567890123456789012345678901"));
    }

    @Test
    void settersUpdateValidFieldsAndRejectInvalidValues() {
        Contact contact = validContact();
        contact.setFirstName("Eddie");
        contact.setLastName("Lopez");
        contact.setPhone("5055559999");
        contact.setAddress("2 Main Street");
        assertEquals("Eddie", contact.getFirstName());
        assertEquals("Lopez", contact.getLastName());
        assertEquals("5055559999", contact.getPhone());
        assertEquals("2 Main Street", contact.getAddress());
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("12345678901"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("notdigits1"));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress("1234567890123456789012345678901"));
    }

    @Test
    void contactIdIsPrivateFinalAndHasNoSetter() throws Exception {
        int modifiers = Contact.class.getDeclaredField("contactId").getModifiers();
        assertTrue(Modifier.isPrivate(modifiers));
        assertTrue(Modifier.isFinal(modifiers));
        assertFalse(java.util.Arrays.stream(Contact.class.getMethods())
                .anyMatch(method -> method.getName().equals("setContactId")));
    }
}
