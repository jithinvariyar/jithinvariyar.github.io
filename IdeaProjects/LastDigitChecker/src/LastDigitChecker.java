public class LastDigitChecker {
    public static boolean hasSameLastDigit(int n1 , int n2 , int n3){
        if((n1 < 10) || (n1 > 1000) || (n2 < 10) || (n2 > 1000) || (n3 < 10) || (n3 > 1000)){
            return false;
        }
        n1 = n1 % 10;
        n2 = n2 % 10;
        n3 = n3 % 10;
        if (n1 == n2){
            return true;
        }
        if(n1 == n3){
            return true;
        }
        if(n2 == n3){
            return true;
        }
        return false;
    }
    public static boolean isValid(int n){
        if((n < 10) || (n > 1000)){
            return false;
        }
        return true;
    }
}
