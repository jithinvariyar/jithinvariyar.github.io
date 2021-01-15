package learnjava;

public class Printer {
    private int tonerLevel;
    private int noOfPagesPrinted = 0;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        this.tonerLevel = tonerLevel;
        this.isDuplex = isDuplex;
        if(tonerLevel > -1 && tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        }
        else{
            this.tonerLevel = -1;
        }
    }

    public int fillUpToner(int tonerAmount){
        if(tonerAmount > 0 && tonerAmount <= 100){
            if(tonerLevel + tonerAmount > 100){
                return -1;
            }
            else{
                return (tonerLevel + tonerAmount);
            }
        }
        else{
            return -1;
        }

    }

    public int printPage(int pages){
        if(isDuplex){
            pages = (int) Math.ceil((double) pages / 2);
            System.out.println("Printing in Duplex Mode ...");
        }
        return (noOfPagesPrinted + pages);
    }

    public int getNoOfPagesPrinted() {
        return noOfPagesPrinted;
    }
}
