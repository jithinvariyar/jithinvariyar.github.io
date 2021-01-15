public class Main {
    public static void main(String[] args) {
        int i;
        int count = 0;
        int sum = 0;
        for(i = 1 ; i < 1001 ; i++){
            if((i % 3 == 0) && (i % 5 ==0)){
                    count++;
                    System.out.println("The number is " + i);
                    sum = sum + i;
                    if(count == 5) {
                        break;
                    }
            }
        }
        System.out.println(sum);
    }
}
