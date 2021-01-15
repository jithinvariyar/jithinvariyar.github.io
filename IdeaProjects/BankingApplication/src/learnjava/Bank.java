package learnjava;

import java.util.ArrayList;
public class Bank {
    private ArrayList<Branches> branchesList;
    private String name;
    public Bank(String name) {
        this.name = name;
        this.branchesList = new ArrayList<Branches>();
    }

    public boolean addNewBranch(String branchName){
        if(findBranches(branchName) == null){
            this.branchesList.add(new Branches(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String customerName , String branchName , double initialAmount){
        if(findBranches(branchName) != null){
            boolean isCustomer = findBranches(branchName).newCustomer(customerName , initialAmount);
            if(!isCustomer){
                System.out.println("This customer already exist in the branch " + branchName);
                return false;
            }
            return true;
        }
        System.out.println("There is no branch named " + branchName);
        return false;
    }

     public void addTransaction(String customerName , String branchName , double amount){
        Branches branch = findBranches(branchName);
        if(branch != null){
            if(branch.addCustomerTransaction(customerName , amount) == true){
                System.out.println("Transaction successfully processed..");
            }
            else{
                System.out.println("Transaction Failed\nThere is no customer with name " + customerName + " in branch " + branchName);
            }
        }
        else {
            System.out.println("Transaction failed..!\nThere is no branch with name " + branchName);
        }
    }

    private Branches findBranches(String branchName){
        for(int i = 0 ; i < branchesList.size() ; i++){
            if(branchesList.get(i).getName().equals(branchName)){
                return branchesList.get(i);
            }
        }
        return null;
    }

    public void customerList(String branchName){
        Branches branch = findBranches(branchName);
        if(branch != null){
            System.out.println("LIST OF CUSTOMERS IN BRANCH , " + branch.getName());
            for (int i = 0 ; i < branch.getCustomer().size(); i++){
                System.out.println("Customer name : " + branch.getCustomer().get(i).getName() +" With transactions : " + branch.getCustomer().get(i).getTransactions());
            }
        }
        else {
            System.out.println("Branch not found..!!");
        }
    }
}
