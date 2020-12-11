package learnjava;

public class BankAccount {
    private int accNo;
    private double balance;
    private String name;
    private String email;
    private int phNo;
    public BankAccount(){
        this(00000000 , 10000 , "Unknown" , "Unknown" , 0000000000);
        System.out.println("Empty constructor called");
    }
    public BankAccount(int accNo , double balance , String name , String email , int phNo){
        this.accNo = accNo;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.phNo = phNo;
    }

    public BankAccount(String name, String email, int phNo) {
        this(12345 , 00000 , name , email , phNo );
    }

//    public void setAccNo(int accNo) {
//        this.accNo = accNo;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPhNo(int phNo) {
//        this.phNo = phNo;
//    }
    public int getAccNo(){
        return accNo;
    }
    public double getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public int getPhNo(){
        return phNo;
    }
    public double deposit(double money){
       balance = balance + money;
       return balance;
    }
    public double withdraw(double money){
        if(money > balance){
            System.out.println("\nINSUFFICIENT FUND..!\n");
            return -1;
        }
        balance = balance - money;
        return balance;
    }
}
