package learnjava;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("9562 5716 27");
    public static void main(String[] args) {
	    boolean quit = false;
	    menuOptions();
        while(!quit){
            System.out.println("Select the desired option : ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 0 :
                    menuOptions();
                    break;
                case 1 :
                    printContacts();
                    break;
                case 2 :
                    addNewContact();
                    break;
                case 3 :
                    updateContact();
                    break;
                case 4 :
                    removeContact();
                    break;
                case 5 :
                    searchContact();
                    break;
                case 6:
                    quit = true;
                    break;

            }
        }
    }
    public static void menuOptions(){
        System.out.println("MENU");
        System.out.println("\n0. Menu options");
        System.out.println("1. Print contacts");
        System.out.println("2. Add new contact");
        System.out.println("3. Update an existing contact");
        System.out.println("4. Remove a contact");
        System.out.println("5. Search for a contact");
        System.out.println("6. Quit");
    }

    public static void printContacts(){
        mobilePhone.printContacts();
    }

    public static void addNewContact(){
        System.out.println("Enter the name : ");
        String name = scanner.nextLine();
        System.out.println("Enter the number : ");
        String number = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name,number);
        mobilePhone.addNewContact(newContact);
    }

    public static void updateContact(){
        System.out.println("Give name of contact to be modified : ");
        String oldName = scanner.nextLine();
        Contacts existingOne = mobilePhone.queryContact(oldName);
        System.out.println("Give name of new contact : ");
        String newName = scanner.nextLine();
        System.out.println("Give number of new contact : ");
        String newNumber = scanner.nextLine();
        Contacts newOne = Contacts.createContact(newName,newNumber);
        mobilePhone.updateContact(existingOne , newOne);

    }

    public static void removeContact(){
        System.out.println("Give name of contact to be deleted : ");
        String delName = scanner.nextLine();
        mobilePhone.removeContact(delName);
    }

    public static void searchContact(){
        System.out.println("Give name of contact to be searched : ");
        String serName = scanner.nextLine();

        Contacts hold = mobilePhone.queryContact(serName);
        if(hold == null){
            System.out.println("Contact not found!!!");
        }
        else{
            System.out.println("Contact with name " +hold.getName() + " Found!!!");
        }
    }
}
