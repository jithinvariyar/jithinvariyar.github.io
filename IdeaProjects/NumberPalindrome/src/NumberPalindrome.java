public class NumberPalindrome {
    public static boolean isPalindrome(int number){
        int count = 0;
        if(number < 0){
            number = number * -1;
        }
        int reverse = 0;
        int hold = number;
        while(number > 0){
            reverse = reverse * 10;
            reverse = reverse + (number % 10);
            number = number / 10;
        }
        if(reverse == 1){
            return false;
        }
        if(hold == reverse){
            return true;
        }
        return false;
    }
}
