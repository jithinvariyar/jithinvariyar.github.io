public class NumberToWords {
        public static void numberToWords(int number) {
        int reversed_number;
        int noOfDigitsInReverse;
        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            reversed_number = reverse(number);
            noOfDigitsInReverse = getDigitCount(reversed_number);
            if(reversed_number == 0){
                System.out.println("Zero");
            }
            while (reversed_number > 0) {
                switch ((reversed_number % 10)) {
                    case 0:
                        System.out.println("Zero");
                        break;
                    case 1:
                        System.out.println("One");
                        break;
                    case 2:
                        System.out.println("Two");
                        break;
                    case 3:
                        System.out.println("Three");
                        break;
                    case 4:
                        System.out.println("Four");
                        break;
                    case 5:
                        System.out.println("Five");
                        break;
                    case 6:
                        System.out.println("Six");
                        break;
                    case 7:
                        System.out.println("Seven");
                        break;
                    case 8:
                        System.out.println("Eight");
                        break;
                    case 9:
                        System.out.println("Nine");
                        break;
                    default:
                        break;
                }
                reversed_number = reversed_number / 10;
            }
            int zeros = getDigitCount(number) - noOfDigitsInReverse;
            while (zeros > 0) {
                System.out.println("Zero");
                zeros--;
            }
        }
    }

    public static int reverse(int number) {
        int reverse = 0;
        int flag = 0;
        if (number < 0) {
            number *= -1;
            flag = 1;
        }
        while (number > 0) {
            reverse = reverse + (number % 10);
            reverse = reverse * 10;
            number /= 10;
        }
        reverse /= 10;
        if (flag == 1) {
            reverse *= -1;
        }
        return reverse;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        int count = 0;
        if(number == 0){
            return 1;
        }
        while (number > 0) {
            count ++;
            number = number / 10;
        }
        return count;
    }
}
