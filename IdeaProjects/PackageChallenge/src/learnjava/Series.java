package learnjava;

public class Series {
    public static int nSum(int n){
        int sum = 0;
        for(int i = 1 ; i <=n ; i++){
            sum = sum + i;
        }
        return sum;
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int fibonacci(int n){
        if(n == 0 ){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
