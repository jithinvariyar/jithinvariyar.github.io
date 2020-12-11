package learnjava;



public abstract class Bird extends Animal implements CanFly{
    public Bird(String name){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking..");
    }

    @Override
    public void breathe() {
        System.out.println("Breath in..Breath out..Repeat");
    }

    public void fly(){
        System.out.println(getName() + " Flapping it's wings");
    }
}
