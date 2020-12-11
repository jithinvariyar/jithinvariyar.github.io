package learnjava;

public class Main {

    public static void main(String[] args) {
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFLoatValue = Float.MAX_VALUE;
        System.out.println("The minimum Float value = " +myMinFloatValue);
        System.out.println(("The maximum Float value = " +myMaxFLoatValue));

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("The minimum Double value = " +myMinDoubleValue);
        System.out.println(("The maximum Double value = " +myMaxDoubleValue));

        int myIntValue = 5 / 3;
        float myFloatValue = 5f / 3f; //If no f as suffix this line will generate an error
        double myDoubleValue = 5d / 3d;
        System.out.println("MyIntValue = " +myIntValue);
        System.out.println("MyFloatValue = " +myFloatValue);
        System.out.println("MyDoubleValue = " +myDoubleValue);

        double numberOfPounds = 200d;
        double convertedKiloGrams = numberOfPounds*0.45359237d;
        System.out.println("The pound value = " +numberOfPounds);
        System.out.println("The converted value to kilograms is = " +convertedKiloGrams);
    }
}
