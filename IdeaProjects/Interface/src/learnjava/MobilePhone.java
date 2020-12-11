package learnjava;

public class MobilePhone implements Itelephone{
    private int myNumber;
    private boolean isOn = false;
    private boolean isRinging;

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile phone powered up");
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn) {
            System.out.println("Now Ringing.." + phoneNumber + " on Mobile phone");
        }
        else{
            System.out.println("Mobile phone is switched off");
        }
    }

    @Override
    public void answer() {
        if(isRinging){
            System.out.println("Answering the Mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber && isOn){
            isRinging = true;
            System.out.println("Melody Ring..");
        }
        else{
            System.out.println("Mobile phone not on or number is different");
            isRinging = false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }
}
