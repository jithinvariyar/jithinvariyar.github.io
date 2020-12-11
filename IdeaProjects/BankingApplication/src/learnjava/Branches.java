package learnjava;

import java.util.ArrayList;

public class Branches {
    private String name;
    private ArrayList<Customers> customer;

    public Branches(String branchName) {
        this.name = branchName;
        this.customer = new ArrayList<Customers>();
    }

    public ArrayList<Customers> getCustomer() {
        return customer;
    }

    public String getName() {
        return name;
    }

    public boolean newCustomer(String customerName , double initialAmount){
        if(findCustomer(customerName) == null){
            this.customer.add(new Customers(customerName , initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName , double amount){
        Customers existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customers findCustomer(String customerName){
        for(int i = 0 ; i < this.customer.size() ; i++){
            if(this.customer.get(i).getName().equals(customerName)){
                return this.customer.get(i);
            }
        }
        return null;
    }

}
