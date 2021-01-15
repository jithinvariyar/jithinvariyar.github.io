public class LargestPrime {
    public static int getLargestPrime(int number){
        int factor = -1;
        int flag = 0;
        if(number < 0 ){
            return factor;
        }
        for(int i = 1 ; i <= number ; i++){
            if(number % i == 0){
                if(i == 1){
                   if(number == 1){
                       factor = -1;
                       continue;
                   }
                   factor = 1;
                   continue;
                }
                for(int j = 2 ; j <= (double)Math.sqrt(i) ; j++){
                    if(i % j == 0){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    factor = i;
                }
            }
        }
        return factor;
    }
}
