package learnjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Alankar",8,12);
        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        }
        else {
            System.out.println("Sorry, Seat is taken");
        }

        if(theatre.reserveSeat("B13")){
            System.out.println("Please pay for B13");
        }
        else{
            System.out.println("Sorry seat is taken");
        }

        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        }
        else {
            System.out.println("Sorry, Seat is taken");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);
        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00",17.00));
        priceSeats.add(theatre.new Seat("A00",13.00));
        Collections.sort(priceSeats,theatre.PRICE_ORDER);
        System.out.println(Collections.max(priceSeats,Theatre.PRICE_ORDER).getSeatNumber());
        printList(priceSeats);

    }

    public static void printList(List<Theatre.Seat> seatList){
        for(Theatre.Seat seat : seatList){
            System.out.print(seat.getSeatNumber() + ": " + seat.getPrice());
            System.out.print("||");
        }
        System.out.println("\n===============================================================================================================================================================================================================================================================================================================================================================================================");
    }
}
