public class Flour {
    public static boolean canPack(int bigCount , int smallCount , int goal){
        if((bigCount < 0) || (smallCount < 0) || (goal <0)){
            return false;
        }
        if(((5 * bigCount) + smallCount) < goal){
            return false;
        }
        for(int i = bigCount ; i >= 0 ; i--){
            for(int j = smallCount ; j >= 0 ; j--){
                if(((5 * i) + j) == goal){
                    return true;
                }
            }
        }
        return false;
    }
}
