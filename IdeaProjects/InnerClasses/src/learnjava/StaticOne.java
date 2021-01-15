package learnjava;

public class StaticOne {
    private static int j = 10;
    public static class StaticDemo {
        public static void main(String[] args) {
            System.out.println("Hai, I am inside a static class");
        }

        public static void thisOne() {
            System.out.println("Everything is possible with programming " + j);
        }
    }
}
