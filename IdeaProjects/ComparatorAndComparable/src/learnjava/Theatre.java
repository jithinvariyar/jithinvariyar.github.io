package learnjava;
import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();


    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                }
                return 0;
            }
        };
    }

    public Theatre(String theatreName , int numRows , int seatsPerRows){
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for(char row = 'A' ; row <= lastRow ; row++){
            for(int seatNo = 1 ; seatNo <= seatsPerRows ; seatNo++ ){
                double price = 12.00;
                if((row < 'D') && (seatNo >=4 && seatNo<=9)){
                    price = 14.00;
                }
                else if((row > 'F') || (seatNo < 4 || seatNo > 9)){
                    price = 7.00;
                }
                Seat seat = new Seat(row +  String.format("%02d",seatNo),price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName(){
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber,0);
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

    public Collection<Seat> getSeats(){
        return this.seats;
    }

    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private double price;
        private boolean reserved =false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
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

        public double getPrice() {
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            return seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }

}
