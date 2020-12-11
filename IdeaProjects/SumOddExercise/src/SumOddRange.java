public class SumOddRange {
    public static boolean isOdd(int number){
        boolean hold = false;
        if(number < 0){
            return false;
        }
        if(number % 2 != 0){
            hold = true;
        }
        return hold;
    }
    public static int sumOdd(int start , int end){
        if((end < start) || (start < 0) || (end < 0)){
            return -1;
        }
        int sum = 0;
        for(int i = start ; i <= end ; i++){
            if(isOdd(i)){
                sum = sum + i;
            }
        }
        return sum;
    }
}
