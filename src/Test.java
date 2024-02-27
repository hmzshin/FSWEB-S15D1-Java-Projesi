public class Test {
    public static void main(String[] args) {
        Contact contact1 = Contact.createContact("ahmet", "355666");
        Contact contact2 = Contact.createContact("asdada", "355666");
        Contact contact3 = Contact.createContact("adsadad", "355666");

        MobilePhone mobilePhone = new MobilePhone("2233355");

        mobilePhone.addNewContact(contact1);
        mobilePhone.addNewContact(contact2);
        mobilePhone.addNewContact(contact3);

        mobilePhone.printContact();
    }
}
