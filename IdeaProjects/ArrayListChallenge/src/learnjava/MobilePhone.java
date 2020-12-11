package learnjava;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }
    public boolean updateContact(Contacts oldContact , Contacts newContact){
        int index = findContact(oldContact);
        if(index >= 0){
            myContacts.set(index , newContact);
            System.out.println(oldContact.getName() + " is replaced with " + newContact.getName());
            return true;
        }
        else{
            System.out.println(oldContact.getName() + " , not found..!!");
            return false;
        }
    }

    public void addNewContact(Contacts newContact){
        if(findContact(newContact.getName()) >= 0){
            System.out.println("Contact with name " + newContact.getName() + " Already exists");
        }
        else{
            myContacts.add(newContact);
            System.out.println("New contact with name " + newContact.getName() + " And with number " + newContact.getPhNo() + " is successfully added");
        }
    }

    private int findContact(Contacts contact){
        int index = myContacts.indexOf(contact);
        return index;
    }

    private int findContact(String contactName){
        for(int i = 0 ; i < myContacts.size() ; i ++){
            if(myContacts.get(i).getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        if(findContact(name) >= 0){
            return myContacts.get(findContact(name));
        }
        else{
            return null;
        }
    }

    public boolean removeContact(String name){
        int foundPosition = findContact(name);
        if(foundPosition >= 0){
            myContacts.remove(foundPosition);
            System.out.println("Contact of " + name + " , is deleted");
            return true;
        }
        System.out.println("Contact with name " + name + " Not found !!");
        return false;
    }

    public void printContacts(){
        System.out.println("CONTACT LIST");
        for(int i =0 ; i< myContacts.size() ;i++){
            System.out.print(myContacts.get(i).getName() + " --> ");
            System.out.println(myContacts.get(i).getPhNo());
        }
    }
}