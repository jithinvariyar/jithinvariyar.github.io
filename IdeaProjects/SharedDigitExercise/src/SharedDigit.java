public class SharedDigit {
    public static boolean hasSharedDigit(int param1 , int param2){
        if((param1 < 10) || (param1 > 99) || (param2 < 10) || (param2 > 99)){
            return false;
      }
        int hold = param2;
        int digit1 , digit2;
        while(param1 > 0){
            digit1 = param1 % 10;
            param2 = hold;
            while(param2 > 0){
                digit2 = param2 % 10;
                if(digit2 == digit1){
                    return true;
                }
                param2 = param2 / 10;
            }
            param1 = param1 / 10;
        }
        return false;
    }
}
