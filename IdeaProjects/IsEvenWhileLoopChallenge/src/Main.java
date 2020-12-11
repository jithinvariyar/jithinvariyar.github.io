public class Main {
    public static void main(String[] args) {
        int count = 0;
        int number = 4;
        int finishNumber = 20;
        while(number <= finishNumber){
            number++;
            if(!isEvenNumber(number)){
                continue;
            }
            count++;
            System.out.println("Even number " + number);
            if(count == 5){
                break;
            }
        }
        System.out.println(count);
    }
    public static boolean isEvenNumber(int param){
        if(param % 2 == 0){
            return true;
        }
        return false;
    }
}
