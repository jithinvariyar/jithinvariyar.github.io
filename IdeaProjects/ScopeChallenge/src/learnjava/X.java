package learnjava;

import java.util.Scanner;

public class X {
    private int x;

    public X(Scanner x) {
        System.out.print("Enter the desired number: ");
        this.x = x.nextInt();
        x.nextLine();
    }

    public void x(){
        for(int x = 0 ; x < 13 ; x++){
            System.out.println(x + "times " + this.x + " equals to " + x * this.x);
        }
    }
}
