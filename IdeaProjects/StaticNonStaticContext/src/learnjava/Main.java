package learnjava;

public class Main {

    public static void main(String[] args) {
	    Main newm = new Main();
	    newm.nonStatic();
    }
    public void nonStatic(){
        System.out.println("This is inside a non static method");
        staticOne();
    }

    public static void staticOne(){
        System.out.println("This is inside a static method");

    }
    public void nonStatic2(){
        nonStatic();
    }
}
