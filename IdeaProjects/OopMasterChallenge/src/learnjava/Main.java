package learnjava;

class HamBurger{
    private String name;
    private double price;
    private String breadRollType;
    private String meat;
    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    private String addition3Name;
    private double addition3Price;
    private String addition4Name;
    private double addition4Price;

    public HamBurger(String name, double price, String breadRollType, String meat) {
        this.name = name;
        this.price = price;
        this.breadRollType = breadRollType;
        this.meat = meat;
    }

    public void addition1(String name , double price){
        this.addition1Name = name;
        this.addition1Price = price;
    }

    public void addition2(String name , double price){
        this.addition2Name = name;
        this.addition2Price = price;
    }

    public void addition3(String name , double price){
        this.addition3Name = name;
        this.addition3Price = price;
    }

    public void addition4(String name , double price){
        this.addition4Name = name;
        this.addition4Price = price;
    }

    public double itemizeHamBurger(){
        double hamBurgerPrice = this.price;
        System.out.println(this.name + " Hamburger" + " on a " + this.breadRollType + " roll" + " with " + this.meat + ", price is " + this.price);
        if(this.addition1Name != null){
            hamBurgerPrice += this.addition1Price;
            System.out.println("Added " + this.addition1Name + " For an extra " + this.addition1Price);
        }
        if(this.addition2Name != null) {
            hamBurgerPrice += this.addition2Price;
            System.out.println("Added " + this.addition2Name + " For an extra " + this.addition2Price);
        }

        if(this.addition3Name != null) {
            hamBurgerPrice += this.addition3Price;
            System.out.println("Added " + this.addition3Name + " For an extra " + this.addition3Price);
        }

        if(this.addition4Name != null) {
            hamBurgerPrice += this.addition4Price;
            System.out.println("Added " + this.addition4Name + "For an extra " + this.addition4Price);
        }

        return hamBurgerPrice;
    }

}
public class Main {
    public static void main(String[] args) {
        HamBurger hamBurger = new HamBurger("Basic" , 3.56 , "White" , "Sausage");
        //hamBurger.itemizeHamBurger();
        hamBurger.addition1("Tomato",0.27);
        hamBurger.addition2("Lattuce",0.75);
        hamBurger.addition3("Cheese",1.12);
        System.out.println("In total amount = " + hamBurger.itemizeHamBurger());
        HealthyBurger healthyBurger = new HealthyBurger(5.67 , "Bacon");
        //healthyBurger.itemizeHamBurger();
        healthyBurger.addition1("Egg",5.43);
        healthyBurger.setAddition1("Lentils",3.41);
        System.out.println("Total amount of healthy burger = " + healthyBurger.itemizeHamBurger());
        DeluxeBurger deluxeBurger = new DeluxeBurger();
        System.out.println(deluxeBurger.itemizeHamBurger());

    }
}
