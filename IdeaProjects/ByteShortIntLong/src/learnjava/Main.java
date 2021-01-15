package learnjava;

public class Main {

    public static void main(String[] args) {
        int myValue = 10000;
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer minimum value = " + myMinIntValue);
        System.out.println("Integer maximum value = " + myMaxIntValue);
        System.out.println("Busted maximum value = " +(myMaxIntValue+1)); //overflow condition
        System.out.println("Busted minimum value = " +(myMinIntValue-1)); //underflow condition

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte minimum value = " + myMinByteValue);
        System.out.println("Byte maximum value = " + myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short minimum value = " + myMinShortValue);
        System.out.println("Short maximum value = " + myMaxShortValue);

        long myLongValue = 100;
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("long minimum value = " + myMinLongValue);
        System.out.println("long maximum value = " + myMaxLongValue);
        long bigLongLiteralValue = 2_147_483_647_284L;
        System.out.println(bigLongLiteralValue);

        int myTotal = (myMaxIntValue / 2);
        System.out.println(myTotal);
        byte myNewByteValue = (byte) (myMinByteValue / 2);  //We have type casted here
        System.out.println(myNewByteValue);
        short myNewShortValue = (short) (myMaxShortValue / 3);
        System.out.println(myNewShortValue);

    }
}
