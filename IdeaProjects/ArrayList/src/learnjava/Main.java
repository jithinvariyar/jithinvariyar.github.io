package learnjava;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 0 :
                    printInstructions();
                    break;
                case 1 :
                    groceryList.printGroceryList();
                    break;
                case 2 :
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4 :
                    removeItem();
                    break;
                case 5 :
                    searchForItem();
                    break;
                case 6 :
                    quit = true;
                    break;
            }

        }
    }
    public static void printInstructions(){
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search for an item in the list");
        System.out.println("\t To quit the application");
    }

    public static void addItem(){
        System.out.println("Enter the name of the item you want to add in to the list : ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.println("Enter the name of item you want to modify : ");
        String oldOne = scanner.nextLine();
        System.out.println("Enter the name of new Item : ");
        String newOne = scanner.nextLine();
        groceryList.modifyGroceryItem(oldOne , newOne);
    }

    public static void removeItem(){
        System.out.println("Enter the name of item you want to remove from the list : ");
        groceryList.removeGroceryItem(scanner.nextLine());
    }

    public static void searchForItem(){
        System.out.println("Enter the name of the item you want to search in the list : ");
        int itemPos = groceryList.findItem(scanner.nextLine());
        if(itemPos == -1){
            System.out.println("Item does not found in the list..!");
        }
        else{
            System.out.println("Item found..!. At index position : " + (itemPos+1));
        }
    }
}
