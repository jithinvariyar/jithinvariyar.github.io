package learnjava;

public class Main {

    public static void main(String[] args) {
        int value = 4;
        char value2 = 'D';
        switch(value){
            case 1 :
                System.out.println("Value was 1");
                break;
            case 2 :
                System.out.println("Value was 2");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Was 3 or 4 or 5");
                break;
            default:
                System.out.println("Was not 1 or 2 or 3 or 4 or 5");
        }
        switch (value2){
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
                System.out.println("The value is " + value2);
                break;
            default:
                System.out.println("The value is not a or b or c or d");
                break;
        }
        String month = "JanUaRy";
        switch (month.toLowerCase()){
            case "january":
                System.out.println("The given month is the first month");
                break;
            default:
                System.out.println("The given month is not the first month");
                break;
        }
    }
}
