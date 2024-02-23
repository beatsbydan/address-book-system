package engine;

import contact.Contact;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private final List<Contact> contactList;
    public AddressBook(){
        this.contactList = new ArrayList<>();
    }
    public List<Contact> getContactList() {
        return contactList;
    }
    public void addContact(Contact contact){
        this.contactList.add(contact);
    }
    public void removeContact(String name){
        Contact currentContact = getContact(name);
        this.contactList.remove(currentContact);
    }
    public void updateContact(String currentName, String newName, String newPhone){
        Contact currentContact = getContact(currentName);
        if(newPhone != null && !newPhone.isEmpty()){
            currentContact.setPhone(newPhone);
        }
        if(newName != null && !newName.isEmpty()){
            currentContact.setName(newName);
        }
    }
    public void findContact(String name){
        for (Contact contact : this.contactList){
            if(contact.getName().equalsIgnoreCase(name)) {
                System.out.println("\nName: " + contact.getName() + ".\nPhone: " + contact.getPhone() + ".");
            }
        }
        System.out.println("Contact not found.");
    }
    public boolean searchContact(String name){
        for (Contact contact : this.contactList){
            if(contact.getName().equalsIgnoreCase(name)){
                return true;
            };
        }
        return false;
    }
    public void printContactList(){
        if(this.contactList.isEmpty()){
            System.out.println("You have no contacts.");
        }
        else {
            int i = 1;
            for (Contact contact : this.contactList) {
                System.out.println(i + ".\nName: " + contact.getName() + ".\nPhone: " + contact.getPhone() + ".");
                i++;
            }
        }
    }
    Contact getContact(String name){
        for (Contact contact : this.contactList){
            if(contact.getName().equalsIgnoreCase(name)){
                return contact;
            }
        }
        return null;
    }
}
