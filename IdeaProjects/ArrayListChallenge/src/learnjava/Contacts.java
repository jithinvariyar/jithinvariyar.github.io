package learnjava;

public class Contacts {
    private String name;
    private String phNo;

    public Contacts(String name, String phNo) {
        this.name = name;
        this.phNo = phNo;
    }

    public String getName() {
        return name;
    }

    public String getPhNo() {
        return phNo;
    }

    public static Contacts createContact(String name , String phNo){
        return new Contacts(name , phNo);
    }
}
