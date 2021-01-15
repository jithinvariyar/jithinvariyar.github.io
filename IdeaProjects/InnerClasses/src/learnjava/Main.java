package learnjava;

public class Main {

    public static void main(String[] args) {
        InnerClass.Nested n = new InnerClass().new Nested();
        n.show();


        MethodLocal m = new MethodLocal();
        m.insideThis();

        StaticOne.StaticDemo.thisOne();


    }
}


