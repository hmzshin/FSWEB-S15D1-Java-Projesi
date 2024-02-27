import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MobilePhone {
    private List<Contact> myContacts;
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public Boolean addNewContact(Contact contact) {
        return this.myContacts.add(contact);
    }

    public Boolean updateContact(Contact oldContact, Contact newContact) {

        if (!this.myContacts.contains(oldContact)) {
            return false;
        }

        int indexOfExisting = this.myContacts.indexOf(oldContact);
        this.myContacts.set(indexOfExisting, newContact);
        return true;

    }

    public Boolean removeContact(Contact contact) {
        int indexOfExisting = this.myContacts.indexOf(contact);

        if (!this.myContacts.contains(contact)) {
            return false;
        }
        this.myContacts.remove(indexOfExisting);

        return true;
    }

    public Integer findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    public Integer findContact(String number) {
        Optional<Contact> contactOp = this.myContacts.stream()
                .filter((contact) -> contact.getPhoneNumber().equals(number))
                .findFirst();

        if (!contactOp.isPresent())
            return -1;

        return this.myContacts.indexOf(contactOp.get());
    }

    public Contact queryContact(String number) {
        Optional<Contact> contactOp = this.myContacts
                .stream()
                .filter((contact) -> contact.getPhoneNumber().equals(number))
                .findFirst();

        if (!contactOp.isPresent())
            return null;

        return contactOp.get();

    }

    public void printContact() {

        for (Contact contact : this.myContacts) {
            System.out.println(contact);
        }

    }

}
