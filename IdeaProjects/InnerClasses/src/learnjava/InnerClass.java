package learnjava;

public class InnerClass {
    private int j = 10;
    public class Nested{
        public void show(){
            System.out.println("\nThis is from nested class " +j);
        }
    }
    public void instantiate(){
        Nested inst = new Nested();
        inst.show();
    }
}
