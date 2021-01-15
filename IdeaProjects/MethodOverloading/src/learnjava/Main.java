package learnjava;

public class Main {

    public static void main(String[] args) {
        double d = calcFeetAndInchesToCentimeters(8 , 4);
        System.out.println(d);
        d = calcFeetAndInchesToCentimeters(157);
        System.out.println(d);
    }
    public static double calcFeetAndInchesToCentimeters(double feet , double inches){
        if((feet >= 0) && ((inches >=0 ) && (inches <= 12))){
            feet = feet * 12 * 2.54;
            inches = inches * 2.54;
            double param = feet + inches;
            return param;
        }
        else{
            return -1;
        }
    }
    public static double calcFeetAndInchesToCentimeters(double inches){
        if(inches >= 0){
            int feet = (int) inches / 12;
            double remainingInches = inches % 12;
            return calcFeetAndInchesToCentimeters(feet , remainingInches);
        }
        else{
            return -1;
        }
    }
}
