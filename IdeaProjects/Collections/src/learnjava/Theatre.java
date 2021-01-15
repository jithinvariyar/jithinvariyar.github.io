package learnjava;

import java.util.*;

public class Theatre {
    private final String theatreName;
    public List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName , int numRows , int seatsPerRows){
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for(char row = 'A' ; row <= lastRow ; row++){
            for(int seatNo = 1 ; seatNo <= seatsPerRows ; seatNo++ ){
                Seat seat = new Seat(row +  String.format("%02d",seatNo));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName(){
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        }
        else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
//        for(Seat seat : seats){
//            if(seat.getSeatNumber().equals(seatNumber)){
//                requestedSeat = seat;
//            }
//        }
//
//        if(requestedSeat==null){
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//        return requestedSeat.reserve();
    }

    public void getSeats(){
        for(Seat seat: seats){
            System.out.println(seat.getSeatNumber());
        }
    }

    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved =false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }
            else{
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }



}
