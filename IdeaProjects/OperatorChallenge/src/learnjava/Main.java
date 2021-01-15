package learnjava;

public class Main {

    public static void main(String[] args) {
        double var1 = 20.00d;
        double var2 = 80.00d;
        double var3 = (var1+var2) * 100.00d;
        double var4 = var3 % 40.00d;
        boolean isNoRemainder = (var4==0) ? true : false;
        System.out.println(isNoRemainder);
        if(!isNoRemainder){
            System.out.println("Got some remainder");
        }
    }
}
