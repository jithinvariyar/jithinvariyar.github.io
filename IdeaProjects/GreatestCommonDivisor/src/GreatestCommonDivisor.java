public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first , int second){
        int smallest;
        int hold = 1;
        if((first < 10) || (second < 10)){
            return -1;
        }
        if(first >= second){
            smallest = second;
        }
        else{
            smallest = first;
        }
        for (int i = 2 ; i <= largest ; i++){
            if(first % i == 0){
                if(second % i ==0) {
                    hold = i;
                }
            }
        }
        return hold;
    }
}
