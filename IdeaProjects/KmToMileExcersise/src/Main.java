public class Main {
    public static void main(String[] args) {
        SpeedConverter.printConversion(1);
        long miles = SpeedConverter.toMilesPerHour(5);
        System.out.println(miles);
    }
}
