package learnjava;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(50,false);
        System.out.println(printer.fillUpToner(40));
        System.out.println(printer.printPage(25));
    }
}
