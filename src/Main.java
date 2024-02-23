import contact.Contact;
import engine.AddressBook;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean appIsRunning = true;

        System.out.println("Welcome to your Contacts App!");
        while(appIsRunning){
            System.out.println("What do you want to do today? Select an option:");
            System.out.println("1. View contacts");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Update a contact.");
            System.out.println("4. Delete a contact.");
            System.out.println("5. Find a contact");
            System.out.println("6. Exit application");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    addressBook.printContactList();
                    break;
                case 2:
                    System.out.println("Enter contact's name:");
                    String name = sc.nextLine();
                    System.out.println("Enter contact's phone:");
                    String phone = sc.nextLine();

                    Contact newContact = new Contact(
                            name,
                            phone
                    );
                    addressBook.addContact(newContact);
                    break;
                case 3:
                    System.out.println("Who's contact do you want to update?");
                    String contactCurrentName = sc.nextLine();
                    boolean contactIsPresent = addressBook.searchContact(contactCurrentName.toLowerCase());
                    if(contactIsPresent){
                        System.out.println("What do you want to update ? \n1. Name.\n2. Phone.\n3. Name and Phone.");
                        int updateChoice = sc.nextInt();
                        sc.nextLine();
                        if(updateChoice == 1){
                            System.out.println("Enter new name:");
                            String newName = sc.nextLine();
                            addressBook.updateContact(contactCurrentName, newName, null);
                        }
                        else if (updateChoice == 2) {
                            System.out.println("Enter new phone:");
                            String newPhone = sc.nextLine();
                            addressBook.updateContact(contactCurrentName, null, newPhone);
                        }
                        else{
                            System.out.println("Enter new name:");
                            String newName = sc.nextLine();
                            System.out.println("Enter new phone:");
                            String newPhone = sc.nextLine();
                            addressBook.updateContact(contactCurrentName, newName, newPhone);
                        }
                    }
                    else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("Whose contact do you want to delete?");
                    String contactToDelete = sc.nextLine();
                    addressBook.removeContact(contactToDelete);
                    break;
                case 5:
                    System.out.println("Who are you looking for?");
                    String whoToFind = sc.nextLine();
                    addressBook.findContact(whoToFind);
                    break;
                case 6:
                    appIsRunning = false;
                    System.out.println("See you soon!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}