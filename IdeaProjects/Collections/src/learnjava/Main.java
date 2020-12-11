package learnjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Alankar",8,12);
//	    theatre.getSeats();
//        if(theatre.reserveSeat("H11")){
//            System.out.println("Please pay 110Rs");
//        }
//        else {
//            System.out.println("Sorry, Seat is taken");
//        }
//
//        if(theatre.reserveSeat("H11")){
//            System.out.println("Please pay 110Rs");
//        }
//        else {
//            System.out.println("Sorry, Seat is taken");
//        }

        List<Theatre.Seat> seatsCopy = new ArrayList<>(theatre.seats);
        printList(seatsCopy);
        seatsCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")){
            System.out.println("Please pay for A02");
        }
        else{
            System.out.println(theatre.seats.get(1).getSeatNumber() + " is already reserved");
        }

        Collections.shuffle(seatsCopy);
        System.out.println("Printing SeatCopy");
        printList(seatsCopy);
        System.out.println("printing Theatre.Seats");
        printList(theatre.seats);

        seatsCopy.get(2).reserve();
        if(theatre.reserveSeat("H10")){
            System.out.println("Please pay for H10");
        }
        else{
            System.out.println(theatre.seats.get(93).getSeatNumber() + " is already reserved");
        }

        Theatre.Seat minSeat = Collections.min(seatsCopy);
        Theatre.Seat maxSeat = Collections.max(seatsCopy);
        System.out.println("The minimum seat in the list : " + minSeat.getSeatNumber());
        System.out.println("The maximum sear in the list is : " + maxSeat.getSeatNumber());

        sortList(seatsCopy);
        System.out.println("Printing sorted seatCopy list ");
        printList(seatsCopy);

//        List<Integer> testCopy = new ArrayList<>();
//        testCopy.add(1);
//        testCopy.add(2);
//        List<Integer> testCopy2 = new ArrayList<>(testCopy.size());
//        testCopy2.add(5);
//        testCopy2.add(4);
//        Collections.copy(testCopy2,testCopy);
    }

    public static void printList(List<Theatre.Seat> seatList){
        for(Theatre.Seat seat : seatList){
            System.out.print(seat.getSeatNumber());
            System.out.print(" ");
        }
        System.out.println("\n===============================================================================================================================================================================================================================================================================================================================================================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list){
        for(int i = 0 ; i < list.size()-1; i++){
            for(int j = i+1 ; j < list.size() ; j++){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list,i,j);
                }
            }
        }
    }

}
