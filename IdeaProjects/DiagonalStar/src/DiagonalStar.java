public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 0; i < (number - 1); i++) {
                for (int j = 0; j < number; j++) {
                    if (j == number - 1) {
                        System.out.print("*");
                        System.out.println();
                    } else if (i == 0) {
                        System.out.print("*");
                    } else if (j == 0) {
                        System.out.print("*");
                    } else if ((j - i) == 0) {
                        System.out.print("*");
                    } else if (j == (number - i) - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            int k =number;
            while(k > 0){
                System.out.print("*");
                k--;
            }
        }
    }
}
