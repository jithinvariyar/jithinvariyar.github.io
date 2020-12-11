package learnjava;

public class Anonymous {
    void show() {
        System.out.println("I am in show() method of super class");
    }
}

class FlavorDemo {
    static Anonymous d = new Anonymous() {
        void show(){
            super.show();
            System.out.println("I am in FlavourDemo class, Inside show()");
        }
    };

    public static void main(String[] args) {
        d.show();
    }
}

