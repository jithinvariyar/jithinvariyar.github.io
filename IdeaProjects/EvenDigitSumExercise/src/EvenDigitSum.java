public class EvenDigitSum {
    public static int getEvenDigitSum(int number){
        if (number < 0){
            return -1;
        }
        int sum = 0;
        int hold = number;
        while(number > 0){
            if(((number % 10) % 2) == 0){
                sum = sum + (number % 10);
                number = number / 10;
            }
            else{
                number = number / 10;
            }
        }
        return sum;
    }
//    public static boolean isEven(int digit){
//        if(digit % 2 == 0){
//            return true;
//        }
//        return false;
//    }
}
