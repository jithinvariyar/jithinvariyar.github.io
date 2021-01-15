public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number){
        if(number < 0){
            return -1;
        }
        int last_digit = number % 10;
        while (number >= 10){
            number = number / 10;
        }
        return (last_digit + number);
    }
}
