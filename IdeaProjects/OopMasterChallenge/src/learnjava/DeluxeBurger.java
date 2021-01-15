package learnjava;

public class DeluxeBurger extends HamBurger{
    public DeluxeBurger() {
        super("Deluxe", 14.54, "White", "Sausage & Bacon");
        super.addition1("Chips",2.75);
        super.addition2("Drink",1.81);
    }

    @Override
    public void addition1(String name, double price) {
        System.out.println("Can't add additional items to a Deluxe Burger");

    }

    @Override
    public void addition2(String name, double price) {
        System.out.println("Can't add additional items to a Deluxe Burger");

    }

    @Override
    public void addition3(String name, double price) {
        System.out.println("Can't add additional items to a Deluxe Burger");
    }

    @Override
    public void addition4(String name, double price) {
        System.out.println("Can't add additional items to a Deluxe Burger");

    }
}
