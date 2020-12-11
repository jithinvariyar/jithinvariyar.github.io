package learnjava;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Itelephone timPhone;
	    timPhone = new DeskPhone(123456);
	    timPhone.powerOn();
	    timPhone.callPhone(123456);
	    timPhone.answer();

		System.out.println("*****************************");
	    timPhone = new MobilePhone(24565);
	    timPhone.powerOn();
	    timPhone.callPhone(24565);
	    timPhone.answer();
    }
}
