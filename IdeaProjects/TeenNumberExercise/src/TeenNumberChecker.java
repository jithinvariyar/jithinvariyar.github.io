public class TeenNumberChecker {
    public static boolean hasTeen(int param1 , int param2 , int param3){
        boolean hold = false;
        if(((param1 >= 13) && (param1 <= 19)) || ((param2 >= 13) && (param2 <=19)) || ((param3 >= 13) && (param3 <= 19))){
            hold = true;
        }
    return hold;
    }
    public static boolean isTeen(int param1){
        boolean hold = false;
        if((param1 >= 13) && (param1 <=19)){
            hold = true
        }
        return hold;
    }
}
