package learnjava;

public class Main {

    public static void main(String[] args) {
        int result = 1+2;
        System.out.println("1+2 = " + result);
        int prevResult = result;
        result = result - 1;
        System.out.println(result);
        System.out.println(prevResult); //note prevResult not changed
        result = result * 10;
        System.out.println(result);
        System.out.println(prevResult); //Still not changed
        result = result / 5;
        System.out.println(result);
        System.out.println(prevResult); //still...
        result = result % 3;
        System.out.println(result);

        //result = result + 1, Here it will give answer 2
        result++;
        System.out.println(result);

        //result = result-1, Here it will give 1
        result--;
        System.out.println(result);

        //result = reslut + 2, Prints 3
        result += 2;
        System.out.println(result);

        //result = result * 10, Prints 30
        result *= 10;
        System.out.println(result);

        //result = result / 3, prints 10
        result /= 3;
        System.out.println(result);

        //result = result - 2, Prints 8
        result -= 2;
        System.out.println(result);

        boolean isAlien = true;
        if(isAlien)
            System.out.println("It is an alien");
        else
            System.out.println("It is not an alien");
        boolean isGhost = true;
        if(!isGhost){
            System.out.println("It is not a ghost");
            System.out.println("So I am happy.");
        }
        else{
            System.out.println("Yes, It is a ghost");
            System.out.println("I am scared now");
        }

        int topScore = 80;
        if(topScore < 100){
            System.out.println("You got the highest score.");
        }
        int secondTopScore = 60;
        if(topScore > secondTopScore && topScore < 100){
            System.out.println("Greater than second top score and less than 100");
        }

        if((topScore > 90) || (secondTopScore <= 90)){
            System.out.println("Either or both of the conditions are true");
        }

        boolean isCar = false;
        if(isCar = true){    //Note that no issue using single '=' in this case
            System.out.println("This is not supposed to happen"); //But this line will be printed
        }
        isCar = false;
        boolean wasCar = (isCar) ? true : false;
        if(!wasCar){
            System.out.println("wasCar is True");
        }
    }
}
