package learnjava;

class Bound<T extends A & B & C> {

    private T objRef;

    public Bound(T obj) {
        this.objRef = obj;
    }

    public void doRunTest() {
        this.objRef.displayClass();
    }
}

interface B {
    public void displayClass();
}

class A implements C,B{
    public void displayClass() {
        System.out.println("Inside super class A");
    }
}

interface C{
}


public class Test {
    public static void main(String a[]) {
        //Creating object of sub class A and
        //passing it to Bound as a type parameter.
        Bound<A> bea = new Bound<>(new A());
        bea.doRunTest();

    }
}

