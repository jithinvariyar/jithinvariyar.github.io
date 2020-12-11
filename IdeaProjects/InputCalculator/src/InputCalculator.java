import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int i = 0;
        long average;
        while(true){
            //System.out.print("Enter the number : ");
            if(scanner.hasNextInt()){
                sum += scanner.nextInt();
                i++;
            }
            else{
                break;
            }
        }
        average = Math.round (((double) sum / (double) i));
        System.out.println("SUM = " + sum + " AVG = " +average );
        scanner.close();
    }
}
