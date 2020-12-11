public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double first , double second){
        first = first * 1000;
        int number1 = (int) first;
        second = second * 1000;
        int number2 = (int) second;
        if(number1 != number2){
            return false;
        }
        return true;
    }
}

