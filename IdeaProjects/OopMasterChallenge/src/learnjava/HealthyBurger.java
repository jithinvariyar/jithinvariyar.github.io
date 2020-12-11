package learnjava;

public class HealthyBurger extends HamBurger {
    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    public HealthyBurger(double price, String meat) {
        super("Healthy", price, "Brown rye" , meat);

    }
    public void setAddition1(String name , double price) {
        this.addition1Name = name;
        this.addition1Price = price;
    }

    public void setAddition2(String name , double price) {
        this.addition2Name = name;
        this.addition2Price = price;
    }

    @Override
    public double itemizeHamBurger() {
        double hamBurgerPrice = super.itemizeHamBurger();
        if(this.addition1Name != null){
            hamBurgerPrice += addition1Price;
            System.out.println("Added " + this.addition1Name + "For an extra " + this.addition1Price);
        }
        if(this.addition2Name != null){
            hamBurgerPrice += this.addition2Price;
            System.out.println("Added " + this.addition2Name + " For an extra " + this.addition2Price);
        }
        return hamBurgerPrice;
    }
}
