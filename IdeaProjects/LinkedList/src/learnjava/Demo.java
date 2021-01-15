package learnjava;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit,"Malappuram");
        addInOrder(placesToVisit,"Kochi");
        addInOrder(placesToVisit,"Vayanad");
        addInOrder(placesToVisit,"Kozhikode");
        addInOrder(placesToVisit,"Trissur");
        addInOrder(placesToVisit,"Palakkad");
        addInOrder(placesToVisit, "Malappuram");
        printList(placesToVisit);

        visit(placesToVisit);

//        Collections.sort(placesToVisit);
//        printList(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList){
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()){
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("============================");
    }


    private static boolean addInOrder(LinkedList<String> linkedList , String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0){
                System.out.println("City named " + newCity + " Already exist");
                return false;
            }

            else if(comparison > 0){
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }

            else{
                continue;
            }

        }
        stringListIterator.add(newCity);
        return true;
    }

    public static void visit(LinkedList<String> cities){
        ListIterator<String> listIterator = cities.listIterator(0);
        Scanner scanner = new Scanner(System.in);
        boolean quit =false;
        boolean goingForward = false;
        if(cities.isEmpty()){
            System.out.println("No cities in the list..!!");
            return;
        }
        else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
            while(!quit){
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option){
                    case 0 :
                        System.out.println("Holiday is over..");
                        quit = true;
                        break;
                    case 1:
                        if(!goingForward){
                            if(listIterator.hasNext()){
                                listIterator.next();
                            }
                            goingForward = true;
                        }
                        if(listIterator.hasNext()){
                            System.out.println("Now visiting " + listIterator.next());
                        }
                        else{
                            System.out.println("Reached the end of list..");

                        }
                        break;
                    case 2 :
                        if(goingForward){
                            if(listIterator.hasPrevious()){
                                listIterator.previous();
                            }
                            goingForward = false;
                        }
                        if(listIterator.hasPrevious()){
                            System.out.println("Now visiting " +listIterator.previous());

                        }
                        else {
                            System.out.println("We are at the start of the list");
                        }
                        break;
                    case 3 :
                        printMenu();
                        break;
                }
            }
    }

public static void printMenu(){
    System.out.println("SELECT AN OPTION");
    System.out.println("0. To stop the journey\n1. To visit next city in the list\n2. To visit previous city in the list\n3. To see menu options");
}


















}
