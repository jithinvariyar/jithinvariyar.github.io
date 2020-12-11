package learnjava;

public class Main {

    public static void main(String[] args) {
        System.out.println(String.format("%.2f",3.14367));
        for(int i = 8 ; i > 1 ; i--){
            System.out.println("10000 at " + i + "% interest = " + String.format("%.2f",calculateInterest(10000 , (double) i)));
        }
        int count = 0;
        for(int i = 2 ; i < 20 ; i++){
            if(isPrime(i)){
                System.out.println(i);
                count++;
                if(count == 10){
                    break;
                }
            }
        }
    }
    public static double calculateInterest(double amount , double interestRate){
        return (amount * (interestRate / 100));
    }
    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        for(int i = 2 ; i <= (long) Math.sqrt(n) ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
