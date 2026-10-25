/** Represents a contact with an immutable ID and validated editable fields. */
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {
        this.contactId = validateText(contactId, 10, "contactId");
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    private static String validateText(String value, int maximum, String field) {
        if (value == null || value.length() > maximum) {
            throw new IllegalArgumentException(field + " must be non-null and at most "
                    + maximum + " characters.");
        }
        return value;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = validateText(firstName, 10, "firstName");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = validateText(lastName, 10, "lastName");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("[0-9]{10}")) {
            throw new IllegalArgumentException("phone must contain exactly 10 digits.");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = validateText(address, 30, "address");
    }
}
