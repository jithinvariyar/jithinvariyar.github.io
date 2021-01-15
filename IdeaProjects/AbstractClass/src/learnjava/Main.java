package learnjava;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Jackie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Australian ring neck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }
}
